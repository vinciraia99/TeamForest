package com.unisa.teamforest.ui.home;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.unisa.teamforest.R;
import com.unisa.teamforest.databinding.FragmentHomeBinding;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    private int punti;
    private String username;
    private SharedPreferences.Editor mEditor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        int alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();

        TextView nomeView = (TextView) root.findViewById(R.id.textNome);
        nomeView.setText("Benvenuto/a "+nome+" "+cognome);
        TextView puntiView = (TextView) root.findViewById(R.id.textPunti);
        puntiView.setText("I tuoi punti: " + punti);
        TextView alberiView = (TextView) root.findViewById(R.id.textAlberi);
        alberiView.setText("Alberi piantati: " + alberi);

        LinearLayout app_layer = (LinearLayout) root.findViewById (R.id.notizia1);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+10;
                        mEditor.putInt(username, punti).commit();
                        TextView puntiView = (TextView) root.findViewById(R.id.textPunti);
                        puntiView.setText("I tuoi punti: " + punti);
                    }
                });
                builder.setMessage("Grazie per aver cliccato! Sono stati aggiunti 10 punti al tuo account");
                builder.show();
            }
        });

        LinearLayout app_layer1 = (LinearLayout) root.findViewById (R.id.notizia2);
        app_layer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+20;
                        mEditor.putInt(username, punti).commit();
                        TextView puntiView = (TextView) root.findViewById(R.id.textPunti);
                        puntiView.setText("I tuoi punti: " + punti);
                    }
                });
                builder.setMessage("Grazie per aver cliccato! Sono stati aggiunti 20 punti al tuo account");
                builder.show();
            }
        });
        LinearLayout app_layer3 = (LinearLayout) root.findViewById (R.id.notizia3);
        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+50;
                        mEditor.putInt(username, punti).commit();
                        TextView puntiView = (TextView) root.findViewById(R.id.textPunti);
                        puntiView.setText("I tuoi punti: " + punti);
                    }
                });
                builder.setMessage("Grazie per aver cliccato! Sono stati aggiunti 50 punti al tuo account");
                builder.show();
            }
        });




        return root;

    }

}