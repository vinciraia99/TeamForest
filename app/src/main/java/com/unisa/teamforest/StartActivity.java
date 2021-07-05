package com.unisa.teamforest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.unisa.teamforest.databinding.ActivityMainBinding;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.startactivity);
        super.onCreate(savedInstanceState);
    }

    public void login(View view)
    {
        Intent activity = new Intent(this, LoginActivity.class);
        startActivity(activity);
    }

    public void registrati(View view)
    {
        Intent activity = new Intent(this, RegistratiActivity.class);
        startActivity(activity);
    }
}