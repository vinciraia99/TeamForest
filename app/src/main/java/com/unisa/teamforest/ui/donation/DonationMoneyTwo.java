package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.unisa.teamforest.MainActivity;
import com.unisa.teamforest.R;
import com.unisa.teamforest.ui.dashboard.DashboardFragment;

public class DonationMoneyTwo extends AppCompatActivity {

    Button btnConfirmPaymentMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_money_two);

        btnConfirmPaymentMoney = (Button) findViewById(R.id.btnConfirmPaymentMoney);

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