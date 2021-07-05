package com.unisa.teamforest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Utente personas1;
    Utente personas2;
    Utente personas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.login);
        super.onCreate(savedInstanceState);

         personas1 = new Utente("Davide","Agazzi","davide","12345","davideagazzi@gmail.com");
         personas2 = new Utente("Giorgio","D'amico","giorgio","12345","girgio@gmail.com");
         personas3 = new Utente("Giovanna ","Iannone","giovanna","12345","giovanna@gmail.com");

    }

    public void login(View view)
    {
        EditText username = (EditText)findViewById(R.id.username);
        String u = username.getText().toString();
        EditText password = (EditText)findViewById(R.id.password);
        String p = password.getText().toString();
        SharedPreferences mPrefs = getSharedPreferences("db", 0);
        int punti = mPrefs.getInt(username.getText().toString(),0);
        int alberi = mPrefs.getInt(username.getText().toString()+"1",0);

        if(u.equals(personas1.getUsername()) && p.equals(personas1.getPassword())){
            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putString("nome", personas1.getNome()).commit();
            mEditor.putString("cognome", personas1.getCognome()).commit();
            mEditor.putString("username", personas1.getUsername()).commit();
            mEditor.putString("email", personas1.getEmail()).commit();
            Intent activity = new Intent(this, MainActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(activity);

        } else if(u.equals(personas2.getUsername()) && p.equals(personas2.getPassword())){
            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putString("nome", personas2.getNome()).commit();
            mEditor.putString("cognome", personas2.getCognome()).commit();
            mEditor.putString("username", personas2.getUsername()).commit();
            mEditor.putString("email", personas2.getEmail()).commit();
            Intent activity = new Intent(this, MainActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(activity);

        } else if(u.equals(personas3.getUsername()) && p.equals(personas3.getPassword())){
            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putString("nome", personas2.getNome()).commit();
            mEditor.putString("cognome", personas2.getCognome()).commit();
            mEditor.putString("username", personas3.getUsername()).commit();
            mEditor.putString("email", personas3.getEmail()).commit();
            Intent activity = new Intent(this, MainActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(activity);
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setMessage("Username o password errati. Riprova");
            builder.show();
        }
    }
}
