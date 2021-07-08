package com.unisa.teamforest.ui.video;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.unisa.teamforest.R;
import com.unisa.teamforest.databinding.FragmentVideoBinding;

import static android.content.Context.MODE_PRIVATE;

public class VideoFragment extends Fragment {

    private int punti;
    private String username;
    private SharedPreferences.Editor mEditor;
    Dialog dialog;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences mPrefs = getActivity().getSharedPreferences("db", MODE_PRIVATE );
        username = mPrefs.getString("username","");
        String nome = mPrefs.getString("nome","");
        String cognome = mPrefs.getString("cognome","");
        punti = mPrefs.getInt(username,0);
        int alberi = mPrefs.getInt(username + "1",0);
        mEditor = mPrefs.edit();
        root = inflater.inflate(R.layout.fragment_video, container, false);
        dialog = new Dialog(root.getContext());
        Button app_layer = (Button) root.findViewById (R.id.bt3);
        app_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAlertBox();
            }
        });

        Button app_layer1 = (Button) root.findViewById (R.id.bt1);
        app_layer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAlertBox();
            }
        });

        Button app_layer3 = (Button) root.findViewById (R.id.bt2);
        app_layer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAlertBox();
            }
        });

        return root;

    }
    public void CreateAlertBox(){
        dialog.setContentView(R.layout.dialogbox);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.WHITE)));
        Button btn = dialog.findViewById(R.id.bt1);
        btn.setOnClickListener(new View.OnClickListener() {
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
                    }
                });
                builder.setMessage("Grazie per aver condiviso! Sono stati aggiunti 50 punti al tuo account");
                builder.show();
                dialog.dismiss();
            }
        });

        Button btn1 = dialog.findViewById(R.id.bt2);
        btn1.setOnClickListener(new View.OnClickListener() {
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
                    }
                });
                builder.setMessage("Grazie per aver condiviso! Sono stati aggiunti 20 punti al tuo account");
                builder.show();
                dialog.dismiss();
            }
        });

        Button btn2 = dialog.findViewById(R.id.bt3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        punti=punti+70;
                        mEditor.putInt(username, punti).commit();
                    }
                });
                builder.setMessage("Grazie per aver condiviso! Sono stati aggiunti 70 punti al tuo account");
                builder.show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}