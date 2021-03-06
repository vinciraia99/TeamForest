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
import android.widget.Toast;

import com.unisa.teamforest.MainActivity;
import com.unisa.teamforest.R;

public class DonationMoneyTwo extends AppCompatActivity {

    Button btnConfirmPaymentMoney;
    private int punti;
    private String username;
    private int alberi;
    private SharedPreferences.Editor mEditor;
    private int euroDonati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_money_two);

        btnConfirmPaymentMoney = (Button) findViewById(R.id.btnConfirmPaymentMoney);

        SharedPreferences mPrefs = getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();
        TextView puntiView = (TextView) findViewById(R.id.puntiDisp3);
        puntiView.setText("Punti disponibili: " + punti);
        euroDonati = getIntent().getIntExtra("euro",0);


        btnConfirmPaymentMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DonationMoneyTwo.this);;
                builder.setTitle("AVVISO");
                builder.setMessage("Sei sicuro di voler procedere al pagamento?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(DonationMoneyTwo.this);;
                        builder2.setTitle("CONGRATULAZIONI");
                        builder2.setCancelable(false);
                        builder2.setMessage("Hai completato il pagamento con successo!");
                        builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                alberi= alberi +(euroDonati/3);
                                mEditor.putInt(username + "1",alberi).commit();
                                startActivity(i);
                            }
                        });
                        builder2.show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
                builder.show();
            }
        });
    }
}