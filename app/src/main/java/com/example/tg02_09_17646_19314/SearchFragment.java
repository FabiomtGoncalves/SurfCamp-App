package com.example.tg02_09_17646_19314;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SearchFragment extends Fragment {

    ImageButton kalux;
    ImageButton alentejoCamp;
    ImageButton ericeira;
    ImageButton surfMilfontes;
    TextView txtVkalux;
    TextView txtVAlentejo;
    TextView txtVericeira;
    TextView txtVmilfontes;
    String nomeSurfCamp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        txtVkalux = view.findViewById(R.id.txtKalux);
        txtVAlentejo = view.findViewById(R.id.txtAlentejoSurfCamp);
        txtVericeira = view.findViewById(R.id.txtEriceiraSurfCamp);
        txtVmilfontes = view.findViewById(R.id.txtSurfMilfontes);

        kalux = view.findViewById(R.id.imgBtnStorpes);
        kalux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                nomeSurfCamp = "" + txtVkalux.getText().toString();
                bundle.putString("NomeSurfCamp", nomeSurfCamp);
                SurfCampInfoFragment surfCampInfoFragment = new SurfCampInfoFragment();
                surfCampInfoFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_layout, surfCampInfoFragment);
                transaction.commit();
            }
        });

        alentejoCamp = view.findViewById(R.id.imgBtnAlentejoSurfCamp);

        alentejoCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //nomeSurfCamp = "" + txt.getText();
                SurfCampInfoFragment surfCampInfoFragment = new SurfCampInfoFragment();
                bundle.putString("NomeSurfCamp", "" + txtVAlentejo.getText().toString());
                surfCampInfoFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_layout, surfCampInfoFragment);
                transaction.commit();
            }
        });

        ericeira = view.findViewById(R.id.imgBtnEriceiraSurfCamp);
        ericeira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //nomeSurfCamp = "" + txtVkalux.getText();
                SurfCampInfoFragment surfCampInfoFragment = new SurfCampInfoFragment();
                bundle.putString("NomeSurfCamp", "" + txtVericeira.getText().toString());
                surfCampInfoFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_layout, surfCampInfoFragment);
                transaction.commit();
            }
        });

        surfMilfontes = view.findViewById(R.id.imgBtnSurfMilfontes);
        surfMilfontes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //nomeSurfCamp = "" + txtVkalux.getText();
                bundle.putString("NomeSurfCamp", "" + txtVmilfontes.getText().toString());
                SurfCampInfoFragment surfCampInfoFragment = new SurfCampInfoFragment();
                surfCampInfoFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_layout, surfCampInfoFragment);
                transaction.commit();
            }
        });

        return view;

    }

}

