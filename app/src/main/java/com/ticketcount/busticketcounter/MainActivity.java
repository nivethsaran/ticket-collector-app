package com.ticketcount.busticketcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] ticket_type = {"Ticket 17", "Ticket 22"};
    Spinner spinner;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        toolbar=findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.mainmenu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.menu_history)
                {
                    Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.menu_support)
                {
                    Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7339065577"));
                    startActivity(intent);
                }
                return false;
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ticket_type);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ticket_type[i], Toast.LENGTH_SHORT).show();

                final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (i == 0) {
                    transaction.replace(R.id.container_fragment, new Ticket17());
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else if (i == 1) {
                    transaction.replace(R.id.container_fragment, new Ticket21());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
