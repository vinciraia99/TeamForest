package com.unisa.teamforest.ui.donation;

import android.content.Intent;
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

public class DonationFragment extends Fragment {

    Button btnPointDonation;
    Button btnMoneyDonation;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_donation, container, false);

        btnPointDonation = (Button) root.findViewById(R.id.btnPointDonation);
        btnMoneyDonation = (Button) root.findViewById(R.id.btnMoneyDonation);

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