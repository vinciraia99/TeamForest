package com.unisa.teamforest.ui.games;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.unisa.teamforest.R;
import com.unisa.teamforest.databinding.FragmentDashboardBinding;
import com.unisa.teamforest.databinding.FragmentGamesBinding;

import static android.content.Context.MODE_PRIVATE;

public class GamesFragment extends Fragment {

    private int punti;
    private String username;
    private SharedPreferences.Editor mEditor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_games, container, false);

        Button button = (Button) root.findViewById(R.id.bt1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
                username = mPrefs.getString("username","");
                String nome = mPrefs.getString("nome","");
                String cognome = mPrefs.getString("cognome","");
                punti = mPrefs.getInt(username,0);
                int alberi = mPrefs.getInt(username + "1",0);
                mEditor = mPrefs.edit();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+10;
                        mEditor.putInt(username, punti).commit();
                    }
                });
                builder.setMessage("Grazie per aver giocato! Sono stati aggiunti 10 punti al tuo account" + username);
                builder.show();
            }
        });

        Button button2 = (Button) root.findViewById(R.id.bt2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
                username = mPrefs.getString("username","");
                String nome = mPrefs.getString("nome","");
                String cognome = mPrefs.getString("cognome","");
                punti = mPrefs.getInt(username,0);
                int alberi = mPrefs.getInt(username + "1",0);
                mEditor = mPrefs.edit();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+10;
                        mEditor.putInt(username, punti).commit();
                    }
                });
                builder.setMessage("Grazie per aver giocato! Sono stati aggiunti 10 punti al tuo account" + username);
                builder.show();
            }
        });

        Button button3 = (Button) root.findViewById(R.id.bt3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
                username = mPrefs.getString("username","");
                String nome = mPrefs.getString("nome","");
                String cognome = mPrefs.getString("cognome","");
                punti = mPrefs.getInt(username,0);
                int alberi = mPrefs.getInt(username + "1",0);
                mEditor = mPrefs.edit();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+20;
                        mEditor.putInt(username, punti).commit();
                    }
                });
                builder.setMessage("Grazie per aver giocato! Sono stati aggiunti 20 punti al tuo account" + username);
                builder.show();
            }
        });

        Button button4 = (Button) root.findViewById(R.id.bt4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
                username = mPrefs.getString("username","");
                String nome = mPrefs.getString("nome","");
                String cognome = mPrefs.getString("cognome","");
                punti = mPrefs.getInt(username,0);
                int alberi = mPrefs.getInt(username + "1",0);
                mEditor = mPrefs.edit();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+60;
                        mEditor.putInt(username, punti).commit();
                    }
                });
                builder.setMessage("Grazie per aver giocato! Sono stati aggiunti 60 punti al tuo account" + username);
                builder.show();
            }
        });

        return root;

    }
}