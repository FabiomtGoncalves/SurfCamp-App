package com.example.tg02_09_17646_19314;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SuporteFragment extends Fragment {

    TextView user;
    TextView input;
    TextView suporte;
    Button enviar;
    String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_suporte, container, false);

        user = view.findViewById(R.id.txtUser);
        input = view.findViewById(R.id.txtInputText);
        enviar = view.findViewById(R.id.btnEnviar);
        suporte = view.findViewById(R.id.txtSuporte);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "" + "\n" + input.getText().toString() + "\n";
                user.setText(text);
            }
        });

        return view;
    }
}
