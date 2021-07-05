package com.unisa.teamforest.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.unisa.teamforest.R;
import com.unisa.teamforest.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        SharedPreferences mPrefs = this.getActivity().getSharedPreferences("db", 0);
        String username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        int punti = mPrefs.getInt(username,0);
        int alberi = mPrefs.getInt(username + "1",0);

        TextView nomeView = (TextView) root.findViewById(R.id.textNome);
        nomeView.setText("Benvenuto/a "+nome+" "+cognome);
        TextView puntiView = (TextView) root.findViewById(R.id.textPunti);
        puntiView.setText("I tuoi punti: " + punti);
        TextView alberiView = (TextView) root.findViewById(R.id.textAlberi);
        alberiView.setText("Alberi piantati: " + alberi);




        return root;

    }

}