package com.ticketcount.busticketcounter;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ticketcount.busticketcounter.database.TicketDB;
import com.ticketcount.busticketcounter.database.TicketDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ticket17 extends Fragment {

    private EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12, et13, et14, et15, et16, et17;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16, tv17;
    private TextView tva1, tva2, tva3, tva4, tva5, tva6, tva7, tva8, tva9, tva10, tva11, tva12, tva13, tva14, tva15, tva16, tva17;
    private long s1=0,s2=0,s3=0,s4=0,s5=0,s6=0,s7=0,s8=0,s9=0,s10=0,s11=0,s12=0,s13=0,s14=0,s15=0,s16=0,s17=0;
    private int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10=0,c11=0,c12=0,c13=0,c14=0,c15=0,c16=0,c17=0;
    private int cess_c1=0,cess_c2=0,cess_s1=0,cess_s2=0;


    TextView amount,count,cessamount,cesscount;
    private  int countvar=0,cesscountvar=0;
    long amountvar=0,cessamountvar=0;

    Button copy,save;
    public Ticket17() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ticket17, container, false);

        amount=view.findViewById(R.id.amount_tv);
        count=view.findViewById(R.id.count_tv);
        cessamount=view.findViewById(R.id.cess_amount);
        cesscount=view.findViewById(R.id.cess_count);

        copy=view.findViewById(R.id.copy_button);
        save=view.findViewById(R.id.save_button);

        et1 = view.findViewById(R.id.et1);
        et2 = view.findViewById(R.id.et2);
        et3 = view.findViewById(R.id.et3);
        et4 = view.findViewById(R.id.et4);
        et5 = view.findViewById(R.id.et5);
        et6 = view.findViewById(R.id.et6);
        et7 = view.findViewById(R.id.et7);
        et8 = view.findViewById(R.id.et8);
        et9 = view.findViewById(R.id.et9);
        et10 = view.findViewById(R.id.et10);
        et11 = view.findViewById(R.id.et11);
        et12 = view.findViewById(R.id.et12);
        et13 = view.findViewById(R.id.et13);
        et14 = view.findViewById(R.id.et14);
        et15 = view.findViewById(R.id.et15);
        et16 = view.findViewById(R.id.et16);
        et17 = view.findViewById(R.id.et17);

        tva1=view.findViewById(R.id.tva1);
        tva2=view.findViewById(R.id.tva2);
        tva3=view.findViewById(R.id.tva3);
        tva4=view.findViewById(R.id.tva4);
        tva5=view.findViewById(R.id.tva5);
        tva6=view.findViewById(R.id.tva6);
        tva7=view.findViewById(R.id.tva7);
        tva8=view.findViewById(R.id.tva8);
        tva9=view.findViewById(R.id.tva9);
        tva10=view.findViewById(R.id.tva10);
        tva11=view.findViewById(R.id.tva11);
        tva12=view.findViewById(R.id.tva12);
        tva13=view.findViewById(R.id.tva13);
        tva14=view.findViewById(R.id.tva14);
        tva15=view.findViewById(R.id.tva15);
        tva16=view.findViewById(R.id.tva16);
        tva17=view.findViewById(R.id.tva17);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et1.getText().toString().equals("")||et1.getText()==null)
                {
                    int d=0;
                    s1=8*d;
                    c1=d;
                    tva1.setText(Integer.toString(8*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et1.getText().toString());
                    s1=8*d;
                    c1=d;
                    tva1.setText(Integer.toString(8*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et2.getText().toString().equals("")||et2.getText()==null)
                {
                    int d=0;
                    s2=10*d;
                    c2=d;
                    tva2.setText(Integer.toString(10*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et2.getText().toString());
                    s2=10*d;
                    c2=d;
                    tva2.setText(Integer.toString(10*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et3.getText().toString().equals("")||et3.getText()==null)
                {
                    int d=0;
                    s3=12*d;
                    c3=d;
                    tva3.setText(Integer.toString(12*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et3.getText().toString());
                    s3=12*d;
                    c3=d;
                    tva3.setText(Integer.toString(12*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et4.getText().toString().equals("")||et4.getText()==null)
                {
                    int d=0;
                    s4=13*d;
                    c4=d;
                    tva4.setText(Integer.toString(13*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et4.getText().toString());
                    s4=13*d;
                    c4=d;
                    tva4.setText(Integer.toString(13*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et5.getText().toString().equals("")||et5.getText()==null)
                {
                    int d=0;
                    s5=15*d;
                    c5=d;
                    tva5.setText(Integer.toString(15*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et5.getText().toString());
                    s5=15*d;
                    c5=d;
                    tva5.setText(Integer.toString(15*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et6.getText().toString().equals("")||et6.getText()==null)
                {
                    int d=0;
                    s6=17*d;
                    c6=d;
                    tva6.setText(Integer.toString(17*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et6.getText().toString());
                    s6=17*d;
                    c6=d;
                    tva6.setText(Integer.toString(17*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et7.getText().toString().equals("")||et7.getText()==null)
                {
                    int d=0;
                    s7=19*d;
                    c7=d;
                    tva7.setText(Integer.toString(19*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et7.getText().toString());
                    s7=19*d;
                    c7=d;
                    tva7.setText(Integer.toString(19*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et8.getText().toString().equals("")||et8.getText()==null)
                {
                    int d=0;
                    s8=20*d;
                    c8=d;
                    tva8.setText(Integer.toString(20*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et8.getText().toString());
                    s8=20*d;
                    c8=d;
                    tva8.setText(Integer.toString(20*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et9.getText().toString().equals("")||et9.getText()==null)
                {
                    int d=0;
                    s9=21*d;
                    c9=d;
                    tva9.setText(Integer.toString(21*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et9.getText().toString());
                    s9=21*d;
                    c9=d;
                    tva9.setText(Integer.toString(21*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et10.getText().toString().equals("")||et10.getText()==null)
                {
                    int d=0;
                    s10=22*d;
                    c10=d;
                    tva10.setText(Integer.toString(22*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et10.getText().toString());
                    s10=22*d;
                    c10=d;
                    tva10.setText(Integer.toString(22*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et11.getText().toString().equals("")||et11.getText()==null)
                {
                    int d=0;
                    s11=24*d;
                    c11=d;
                    tva11.setText(Integer.toString(24*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et11.getText().toString());
                    s11=24*d;
                    c11=d;
                    tva11.setText(Integer.toString(24*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et12.getText().toString().equals("")||et12.getText()==null)
                {
                    int d=0;
                    s12=26*d;
                    c12=d;
                    tva12.setText(Integer.toString(26*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et12.getText().toString());
                    s12=26*d;
                    c12=d;
                    tva12.setText(Integer.toString(26*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et13.getText().toString().equals("")||et13.getText()==null)
                {
                    int d=0;
                    s13=27*d;
                    c13=d;
                    tva13.setText(Integer.toString(27*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et13.getText().toString());
                    s13=27*d;
                    c13=d;
                    tva13.setText(Integer.toString(27*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et14.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et14.getText().toString().equals("")||et14.getText()==null)
                {
                    int d=0;
                    s14=29*d;
                    c14=d;
                    tva14.setText(Integer.toString(29*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et14.getText().toString());
                    s14=29*d;
                    c14=d;
                    tva14.setText(Integer.toString(29*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et15.getText().toString().equals("")||et15.getText()==null)
                {
                    int d=0;
                    s15=10*d;
                    c15=d;
                    tva15.setText(Integer.toString(10*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }
                else
                {

                    int d=Integer.parseInt(et15.getText().toString());
                    s15=10*d;
                    c15=d;
                    tva15.setText(Integer.toString(10*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et16.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et16.getText().toString().equals("")||et16.getText()==null)
                {
                    int d=0;
                    s16=1*d;
                    c16=d;
                    tva16.setText(Integer.toString(1*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                    cessamountvar=s16+s17;
                    cesscountvar=c16+c17;
                    cessamount.setText("Cess Total(in Rs):: Rs"+cessamountvar);
                    cesscount.setText("Cess Count: Rs"+cesscountvar);
                }
                else
                {

                    int d=Integer.parseInt(et16.getText().toString());
                    s16=1*d;
                    c16=d;
                    tva16.setText(Integer.toString(1*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                    cessamountvar=s16+s17;
                    cesscountvar=c16+c17;
                    cessamount.setText("Cess Total(in Rs):: Rs"+cessamountvar);
                    cesscount.setText("Cess Count: Rs"+cesscountvar);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et17.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et17.getText().toString().equals("")||et17.getText()==null)
                {
                    int d=0;
                    s17=2*d;
                    c17=d;
                    tva17.setText(Integer.toString(2*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                    cessamountvar=s16+s17;
                    cesscountvar=c16+c17;
                    cessamount.setText("Cess Total(in Rs):: Rs"+cessamountvar);
                    cesscount.setText("Cess Count: Rs"+cesscountvar);
                }
                else
                {

                    int d=Integer.parseInt(et17.getText().toString());
                    s17=2*d;
                    c17=d;
                    tva17.setText(Integer.toString(2*d));
                    countvar=c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+c13+c14+c15+c16+c17;
                    amountvar=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12+s13+s14+s15+s16+s17;
                    amount.setText("Total(in Rs): "+Long.toString(amountvar));
                    count.setText("No.of Tickets: "+Integer.toString(countvar));
                    cessamountvar=s16+s17;
                    cesscountvar=c16+c17;
                    cessamount.setText("Cess Total(in Rs):: Rs"+cessamountvar);
                    cesscount.setText("Cess Count: Rs"+cesscountvar);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String db="8x"+c1+"             =" +s1+"\n"+
                        "10x"+c2+"            =" +s2+"\n"+
                        "12x"+c3+"            =" +s3+"\n"+
                        "13x"+c4+"            =" +s4+"\n"+
                        "15x"+c5+"            =" +s5+"\n"+
                        "17x"+c6+"            =" +s6+"\n"+
                        "19x"+c7+"            =" +s7+"\n"+
                        "20x"+c8+"            =" +s8+"\n"+
                        "21x"+c9+"            =" +s9+"\n"+
                        "22x"+c10+"           ="+s10+"\n"+
                        "24x"+c11+"           ="+s11+"\n"+
                        "26x"+c11+"           ="+s12+"\n"+
                        "27x"+c12+"           ="+s13+"\n"+
                        "29x"+c13+"           ="+s14+"\n"+
                        "10(Combo)x"+c14+"    ="+s15+"\n"+
                        "Cess1x"+c15+"        ="+s16+"\n"+
                        "Cess2x"+c16+"        ="+s17+"\n"+
                        "Cess Count"+"        ="+cesscountvar+"\n"+
                        "Cess Total(in Rs):"+"    ="+cessamountvar+"\n"+
                        "Count"+"             ="+countvar+"\n"+
                        "Total(Rs)"+"         ="+amountvar+"\n";;
                ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(null, db);
                if (clipboard == null) return;
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(),"Copied to Clipboard",Toast.LENGTH_SHORT).show();

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String db="8x"+c1+"             =" +s1+"\n"+
                          "10x"+c2+"            =" +s2+"\n"+
                          "12x"+c3+"            =" +s3+"\n"+
                          "13x"+c4+"            =" +s4+"\n"+
                          "15x"+c5+"            =" +s5+"\n"+
                          "17x"+c6+"            =" +s6+"\n"+
                          "19x"+c7+"            =" +s7+"\n"+
                          "20x"+c8+"            =" +s8+"\n"+
                          "21x"+c9+"            =" +s9+"\n"+
                          "22x"+c10+"           ="+s10+"\n"+
                          "24x"+c11+"           ="+s11+"\n"+
                          "26x"+c12+"           ="+s12+"\n"+
                          "27x"+c13+"           ="+s13+"\n"+
                          "29x"+c14+"           ="+s14+"\n"+
                          "10(Combo)x"+c15+"    ="+s15+"\n"+
                          "Cess1x"+c16+"        ="+s16+"\n"+
                          "Cess2x"+c17+"        ="+s17+"\n"+
                          "Cess Count"+"        ="+cesscountvar+"\n"+
                          "Cess Total(in Rs):"+"    ="+cessamountvar+"\n"+
                          "Count"+"             ="+countvar+"\n"+
                          "Total(Rs)"+"         ="+amountvar+"\n";;

                Toast.makeText(getActivity(),db,Toast.LENGTH_LONG).show();
                new DBTask().execute(db);


            }
        });

        return view;

    }
    class DBTask extends AsyncTask<String,Void,Void>
    {

        @Override
        protected Void doInBackground(String... strings) {
            TicketDatabase db = Room.databaseBuilder(getActivity(), TicketDatabase.class, "ticketdb").build();
            TicketDB ticketDB = new TicketDB();
            ticketDB.details = strings[0];
            ticketDB.date =System.currentTimeMillis();
            ticketDB.ticketype="Route17";
            db.ticketDao().saveData(ticketDB);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getActivity(),"SAVED",Toast.LENGTH_SHORT).show();
        }
    }

}
