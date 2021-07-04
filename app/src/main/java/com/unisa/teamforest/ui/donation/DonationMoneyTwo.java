package com.unisa.teamforest.ui.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.unisa.teamforest.R;
import com.unisa.teamforest.ui.dashboard.DashboardFragment;

public class DonationMoneyTwo extends AppCompatActivity {

    Button btnConfirmPaymentMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_money_two);

        btnConfirmPaymentMoney = (Button) findViewById(R.id.btnConfirmPaymentMoney);


    }
}