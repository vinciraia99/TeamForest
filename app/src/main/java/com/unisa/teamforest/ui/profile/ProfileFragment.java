package com.unisa.teamforest.ui.profile;

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
import com.unisa.teamforest.databinding.FragmentDashboardBinding;

public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profilo, container, false);
        SharedPreferences mPrefs = this.getActivity().getSharedPreferences("db", 0);
        String username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        String email = mPrefs.getString("email","");
        int punti = mPrefs.getInt(username,0);
        int alberi = mPrefs.getInt(username + "1",0);

        TextView user = (TextView) root.findViewById(R.id.dato_username);
        user.setText("Username: " + username);

        TextView mail = (TextView) root.findViewById(R.id.dato_email);
        mail.setText("E-mail: " + email);

        TextView n = (TextView) root.findViewById(R.id.dato_nome);
        n.setText("Nome: " + nome);

        TextView p = (TextView) root.findViewById(R.id.dato_punti);
        p.setText("Punti: " + punti);

        TextView a = (TextView) root.findViewById(R.id.dato_alberi);
        a.setText("Alberi piantati: " + alberi);
        return root;


    }
    public void onClickEsci(View w){
        getActivity().finish();
        System.exit(0);
    }

}