package com.ticketcount.busticketcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
TextView datetv,datatv,typetv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        datatv=findViewById(R.id.data);
        datetv=findViewById(R.id.date);
        typetv=findViewById(R.id.type);
        Intent intent=getIntent();
        String date=intent.getStringExtra("date");
        String data=intent.getStringExtra("data");
        String type=intent.getStringExtra("type");

        datetv.setText(date);
        typetv.setText(type);
        datatv.setText(data);
        Log.v("DEBUG","CHECK");
    }
}
