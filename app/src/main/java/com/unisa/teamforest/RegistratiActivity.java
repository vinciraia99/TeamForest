package com.unisa.teamforest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegistratiActivity extends AppCompatActivity {
    Utente personas1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.homepage_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.registrazione);
        super.onCreate(savedInstanceState);


    }

    public void registrati(View view)
    {
        EditText username = (EditText)findViewById(R.id.username);
        String u = username.getText().toString();
        EditText password = (EditText)findViewById(R.id.password);
        String p = password.getText().toString();
        EditText email = (EditText)findViewById(R.id.email);
        String e = email.getText().toString();
        EditText nome = (EditText)findViewById(R.id.nome);
        String n = nome.getText().toString();
        EditText cognome = (EditText)findViewById(R.id.cognome);
        String c = cognome.getText().toString();

        if(u.isEmpty() || p.isEmpty() || e.isEmpty() || n.isEmpty() || c.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setMessage("Uno o più campi vuoti");
            builder.show();
        } else{
            Intent activity = new Intent(this, MainActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences mPrefs = getSharedPreferences("db", 0);
                    SharedPreferences.Editor mEditor = mPrefs.edit();
                    dialog.dismiss();
                    mEditor.putString("nome", n).commit();
                    mEditor.putString("cognome", c).commit();
                    mEditor.putString("username", u).commit();
                    mEditor.putString("email", e).commit();

                    startActivity(activity);
                }
            });
            builder.setMessage("Registrazione riuscita!");
            builder.show();
        }
    }
}
