package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unisa.teamforest.R;

public class DonationMoney extends AppCompatActivity {

    Button btnProcediMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_money);
        btnProcediMoney = (Button) findViewById(R.id.btnProcediMoney);

        btnProcediMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DonationMoneyTwo.class);
                startActivity(i);
            }
        });
    }
}