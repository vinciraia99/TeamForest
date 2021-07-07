package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.unisa.teamforest.MainActivity;
import com.unisa.teamforest.R;

public class DonationPoint extends AppCompatActivity {

    Button btnConfirmPaymentPoint;
    private int punti;
    private String username;
    private int alberi;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_point);
        SharedPreferences mPrefs = getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();
        TextView puntiView = (TextView) findViewById(R.id.puntiDispDonazione);
        puntiView.setText("Punti disponibili: " + punti);

        btnConfirmPaymentPoint = findViewById(R.id.btnConfirmPaymentPoint);

        btnConfirmPaymentPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DonationPoint.this);
                builder.setCancelable(false);
                builder.setTitle("CONGRATULAZIONI");
                builder.setMessage("Hai completato la donazione con successo!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText puntiDaDonare = findViewById(R.id.puntiDaDonare);
                        int puntiDonati= Integer.parseInt(puntiDaDonare.getText().toString());
                        punti=punti-puntiDonati;
                        mEditor.putInt(username, punti).commit();
                        alberi= alberi +(puntiDonati/50);
                        mEditor.putInt(username + "1",alberi).commit();
                        TextView puntiView = (TextView) findViewById(R.id.puntiDispDonazione);
                        puntiView.setText("Punti disponibili: " + punti);
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
                builder.show();
            }
        });
    }
}