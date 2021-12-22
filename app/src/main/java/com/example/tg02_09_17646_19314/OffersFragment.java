package com.example.tg02_09_17646_19314;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class OffersFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Button buttonReserva;
    Button buttonBack;
    CalendarView calendarView;
    String date;
    String pacote;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_offers, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerOffers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.ofertas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        buttonReserva = view.findViewById(R.id.buttonReserva);
        calendarView = view.findViewById(R.id.calendarView);
        buttonBack = view.findViewById(R.id.buttonBack);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });

        buttonBack.setOnClickListener(v -> {
            onClickBack(view);
        });

        buttonReserva.setOnClickListener(v -> {
            onClickReserva(view);
        });

        return view;

    }

    public void onClickBack(View view)
    {
        SearchFragment searchFragment = new SearchFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.homepage_layout, searchFragment);
        transaction.commit();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinnerOffers);

        pacote = parent.getItemAtPosition(position).toString();

        if (pacote.equals("Selecione uma Oferta")){
            Toast.makeText(getContext(), "Selecione uma Oferta.", Toast.LENGTH_SHORT).show();
            buttonReserva.setEnabled(false);
            //buttonReserva.setClickable(false);
        }

        else {
            buttonReserva.setEnabled(true);
            //buttonReserva.setClickable(true);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClickReserva(View view)
    {
        Bundle payment = new Bundle();
        payment.putString("date", date);
        payment.putString("pack", pacote);
        PaymentFragment paymentFragment  = new PaymentFragment();
        paymentFragment.setArguments(payment);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.homepage_layout, paymentFragment);
        transaction.commit();
    }
}
