package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unisa.teamforest.MainActivity;
import com.unisa.teamforest.R;

public class DonationPoint extends AppCompatActivity {

    Button btnConfirmPaymentPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_point);

        btnConfirmPaymentPoint = findViewById(R.id.btnConfirmPaymentPoint);

        btnConfirmPaymentPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DonationPoint.this);
                builder.setCancelable(false);
                builder.setTitle("CONGRATULAZIONI");
                builder.setMessage("Hai completato il pagamento con successo!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
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