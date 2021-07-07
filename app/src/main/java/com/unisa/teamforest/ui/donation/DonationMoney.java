package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.unisa.teamforest.R;

public class DonationMoney extends AppCompatActivity {

    Button btnProcediMoney;
    private int punti;
    private String username;
    private int alberi;
    private SharedPreferences.Editor mEditor;
    int euroDonati;
    EditText puntiDaDonare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_money);
        btnProcediMoney = (Button) findViewById(R.id.btnProcediMoney);

        SharedPreferences mPrefs = getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();
        TextView puntiView = (TextView) findViewById(R.id.puntiDisp2);
        puntiView.setText("Punti disponibili: " + punti);
        puntiDaDonare = findViewById(R.id.euroDonati);


        btnProcediMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(puntiDaDonare.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Inserisci l'importo da donare",Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent i = new Intent(getApplicationContext(), DonationMoneyTwo.class);
                    euroDonati = Integer.parseInt(puntiDaDonare.getText().toString());
                    i.putExtra("euro", euroDonati);
                    startActivity(i);
                }
            }
        });
    }
}