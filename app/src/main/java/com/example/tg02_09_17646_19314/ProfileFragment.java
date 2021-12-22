package com.example.tg02_09_17646_19314;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProfileFragment extends Fragment {

    Button editProfileButton;
    Button saveChangesButton;
    Button logoff;
    EditText pNome;
    EditText uNome;
    EditText email;
    EditText nif;
    EditText morada;
    EditText nacionalidade;
    EditText dataNasc;
    Spinner genero;
    TextView nome;
    TextView nomeU;
    TextView mail;
    TextView tNif;
    TextView address;
    TextView nationality;
    TextView date;
    TextView gender;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        pNome = view.findViewById(R.id.etPrNome);
        uNome = view.findViewById(R.id.etUlNome);
        email = view.findViewById(R.id.etEmail);
        nif = view.findViewById(R.id.etNIF);
        morada = view.findViewById(R.id.etMorada);
        nacionalidade = view.findViewById(R.id.etNacionalidade);
        dataNasc = view.findViewById(R.id.etDataNasc);
        genero = view.findViewById(R.id.sGenero);
        nome = view.findViewById(R.id.lbPrimeiroNome);
        nomeU = view.findViewById(R.id.lbUltimoNome);
        mail = view.findViewById(R.id.lbEmail);
        tNif = view.findViewById(R.id.lbNIF);
        address = view.findViewById(R.id.lbMorada);
        nationality = view.findViewById(R.id.lbNacionalidade);
        date = view.findViewById(R.id.lbDataNasc);
        gender = view.findViewById(R.id.lbGenero);

        editProfileButton = view.findViewById(R.id.btnEditarPerfil);

        editProfileButton.setOnClickListener(v -> {
            ConstraintLayout info = view.findViewById(R.id.clInfo);
            info.setVisibility(View.INVISIBLE);
            ConstraintLayout buttons = view.findViewById(R.id.clBtuttons);
            buttons.setVisibility(View.INVISIBLE);
            ConstraintLayout edit = view.findViewById(R.id.clEdit);
            edit.setVisibility(View.VISIBLE);
            Button save = view.findViewById(R.id.btnSave);
            save.setVisibility(View.VISIBLE);
        });

        saveChangesButton = view.findViewById(R.id.btnSave);

        saveChangesButton.setOnClickListener(v -> {
            ConstraintLayout info = view.findViewById(R.id.clInfo);
            info.setVisibility(View.VISIBLE);
            ConstraintLayout buttons = view.findViewById(R.id.clBtuttons);
            buttons.setVisibility(View.VISIBLE);
            ConstraintLayout edit = view.findViewById(R.id.clEdit);
            edit.setVisibility(View.INVISIBLE);
            Button save = view.findViewById(R.id.btnSave);
            save.setVisibility(View.INVISIBLE);
            changeInfo();
        });

        logoff = view.findViewById(R.id.btnLogoff);

        logoff.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void changeInfo() {
        nome.setText(pNome.getText().toString());
        nomeU.setText(uNome.getText().toString());
        mail.setText(email.getText().toString());
        tNif.setText(nif.getText().toString());
        address.setText(morada.getText().toString());
        nationality.setText(nacionalidade.getText().toString());
        date.setText(dataNasc.getText().toString());
        gender.setText(genero.getSelectedItem().toString());

    }
}
