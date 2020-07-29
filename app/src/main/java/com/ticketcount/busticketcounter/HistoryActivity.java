package com.ticketcount.busticketcounter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.ticketcount.busticketcounter.R;
import com.ticketcount.busticketcounter.database.TicketDB;
import com.ticketcount.busticketcounter.database.TicketDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        new RetriveTask().execute();
    }

    class RetriveTask extends AsyncTask<Void,Void, List<TicketDB>>
    {
        List<String> dates =new ArrayList<String>();
        @Override
        protected List<TicketDB> doInBackground(Void... voids) {
            TicketDatabase db = Room.databaseBuilder(getApplicationContext(), TicketDatabase.class, "ticketdb").build();
            List<TicketDB> list=new ArrayList<TicketDB>();
            list=db.ticketDao().retrieveData();
            return list;
        }

        @Override
        protected void onPostExecute(final List<TicketDB> ticketDBS) {
            super.onPostExecute(ticketDBS);
            listView = findViewById(R.id.lv);

            List<String> type = new ArrayList<String>();
            for (TicketDB ticket : ticketDBS) {
                long datelong = ticket.date;
                DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
                Date result = new Date(datelong);
                dates.add(simple.format(result));
                type.add(ticket.ticketype);
            }
            List<Map<String, String>> listmain = new ArrayList<>();
            HashMap<String, String> map;

            for (int i = 0; i < dates.size(); i++) {
                map = new HashMap<String, String>();
                map.put("dates", dates.get(i));
                map.put("types", type.get(i));
                Log.v("DEBUG", type.get(i));
                listmain.add(map);
            }

            String[] from = {"dates", "types"};
            int[] to = {android.R.id.text1, android.R.id.text2};
            SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), listmain, android.R.layout.simple_list_item_2, from, to);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(HistoryActivity.this, DataActivity.class);
                    intent.putExtra("data", ticketDBS.get(i).details);
                    intent.putExtra("date", dates.get(i));
                    intent.putExtra("type", ticketDBS.get(i).ticketype);
                    startActivity(intent);

                }
            });

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    PopupMenu popup = new PopupMenu(HistoryActivity.this, view, Gravity.RIGHT);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.deletemenu, popup.getMenu());
                    final int position = i;
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.delete) {
                                TicketDB ticketDB = new TicketDB();
                                ticketDB.date = ticketDBS.get(position).date;
                                ticketDB.ticketype = ticketDBS.get(position).ticketype;
                                ticketDB.details = ticketDBS.get(position).details;
                                new DeleteTask().execute(ticketDB);
                            }

                            return true;

                        }
                    });
                    popup.show();
                    return true;
                }
            });

        }

        }
        class DeleteTask extends AsyncTask<TicketDB,Void,Void>
        {

            @Override
            protected Void doInBackground(TicketDB... ticketDBS) {
                TicketDatabase db = Room.databaseBuilder(getApplicationContext(), TicketDatabase.class, "ticketdb").build();
                db.ticketDao().deleteData(ticketDBS[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                new RetriveTask().execute();
            }
        }

    }


