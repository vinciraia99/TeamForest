package com.unisa.teamforest.ui.donation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.unisa.teamforest.R;

import static android.content.Context.MODE_PRIVATE;

public class DonationFragment extends Fragment {

    Button btnPointDonation;
    Button btnMoneyDonation;
    private int punti;
    private String username;
    private SharedPreferences.Editor mEditor;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_donation, container, false);

        btnPointDonation = (Button) root.findViewById(R.id.btnPointDonation);
        btnMoneyDonation = (Button) root.findViewById(R.id.btnMoneyDonation);
        SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        int alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();
        TextView puntiView = (TextView) root.findViewById(R.id.puntidisp1);
        puntiView.setText("Punti disponibili: " + punti);

        btnPointDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),DonationPoint.class);
                startActivity(i);
            }
        });

        btnMoneyDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),DonationMoney.class);
                startActivity(i);
            }
        });

        return root;

    }

}