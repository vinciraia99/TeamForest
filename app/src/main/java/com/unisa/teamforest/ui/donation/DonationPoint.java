package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.unisa.teamforest.R;

public class DonationPoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_point);
    }
}