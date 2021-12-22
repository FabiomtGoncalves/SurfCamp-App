package com.example.tg02_09_17646_19314;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class PaymentFragment extends Fragment{

    TextView dateReserva;
    TextView pacote;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnPay;
    Button btnBack;
    EditText txtNumber;
    Spinner spinnerMes;
    Spinner spinnerAno;
    EditText cvv;
    EditText nome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_payment, container, false);

        dateReserva = (TextView) view.findViewById(R.id.txtDate);
        pacote = (TextView) view.findViewById(R.id.txtPackage);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        btnPay = (Button) view.findViewById(R.id.btnPay);
        txtNumber = (EditText) view.findViewById(R.id.editTextNumber);
        spinnerMes = (Spinner) view.findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner) view.findViewById(R.id.spinnerAno);
        cvv = (EditText) view.findViewById(R.id.editTextCVV);
        nome = (EditText) view.findViewById(R.id.editTextTitularCartao);
        btnBack = (Button) view.findViewById(R.id.btnBack);

        hidden();

        Bundle bundle = getArguments();
        dateReserva.setText(String.valueOf(bundle.getString("date")));
        pacote.setText(String.valueOf(bundle.getString("pack")));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.mes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.ano, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAno.setAdapter(adapter2);

        Toast.makeText(getContext(), "Selecione um método de Pagamento.", Toast.LENGTH_SHORT).show();
        btnPay.setEnabled(false);

        btnPay.setOnClickListener(v -> {
            onClickPay(view);
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onClickRB(view);
            }
        });

        btnBack.setOnClickListener(v -> {
            onClickBack(view);
        });

        return view;
    }

    public void onClickRB(View view)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = view.findViewById(radioId);
        btnPay.setEnabled(true);

        if (radioButton.getText().equals("Cartão de Crédito")){
            txtNumber.setVisibility(View.VISIBLE);
            spinnerMes.setVisibility(View.VISIBLE);
            spinnerAno.setVisibility(View.VISIBLE);
            cvv.setVisibility(View.VISIBLE);
            nome.setVisibility(View.VISIBLE);
            btnPay.setText("Pagar com Cartão");
        }

        else if (radioButton.getText().equals("Paypal")) {
            hidden();
            btnPay.setText("Pagar com Paypal");
        }

        else {
            hidden();
            btnPay.setText("Pagar com Google Pay");
        }
    }

    public void hidden() {
        txtNumber.setVisibility(View.INVISIBLE);
        spinnerMes.setVisibility(View.INVISIBLE);
        spinnerAno.setVisibility(View.INVISIBLE);
        cvv.setVisibility(View.INVISIBLE);
        nome.setVisibility(View.INVISIBLE);
    }

    public void onClickBack(View view)
    {
        OffersFragment offersFragment = new OffersFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.homepage_layout, offersFragment);
        transaction.commit();
    }

    public void onClickPay(View view)
    {
        String confirmed = "A sua encomenda foi confirmada com sucesso!\nEncomenda ID: EO92X8M2B1" + "Data: " + dateReserva.getText() + "\nPacote: " + pacote.getText();
        Bundle message = new Bundle();
        message.putString("suporte", confirmed);
        SuporteFragment suporteFragment  = new SuporteFragment();
        suporteFragment.setArguments(message);
        Toast.makeText(getContext(), "Pagamento feito com Sucesso.", Toast.LENGTH_SHORT).show();
        SearchFragment searchFragment = new SearchFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.homepage_layout, searchFragment);
        transaction.commit();
    }

}
