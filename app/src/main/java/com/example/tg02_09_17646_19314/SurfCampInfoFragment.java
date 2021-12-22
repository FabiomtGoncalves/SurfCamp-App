package com.example.tg02_09_17646_19314;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SurfCampInfoFragment extends Fragment {

    Button ofertas;
    Button btnBack;
    TextView nomeSurfCamp;
    ImageView imagemSurfCamp;
    ImageView logoSurfCamp;
    TextView mare;
    TextView temperatura;
    TextView vento;
    TextView ondas;
    TextView descricao;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_surf_camp_info, container, false);

        nomeSurfCamp = view.findViewById(R.id.txtNomeSurfCamp);
        imagemSurfCamp = view.findViewById(R.id.imgSurfCamp);
        logoSurfCamp = view.findViewById(R.id.imgLogoSurfCamp);
        mare = view.findViewById(R.id.txtMare);
        temperatura = view.findViewById(R.id.txtTemperatura);
        vento = view.findViewById(R.id.txtVento);
        ondas = view.findViewById(R.id.txtAlturaOndas);
        descricao = view.findViewById(R.id.txtDescricao);
        btnBack = view.findViewById(R.id.btnInfBack);

        Bundle bundle = getArguments();
        nomeSurfCamp.setText(String.valueOf(bundle.getString("NomeSurfCamp")));
        nomeSurfCamp.toString();

        if (nomeSurfCamp.getText().equals("Kalux Surf (Sines)")) {
            imagemSurfCamp.setImageResource(R.drawable.kalux);
            logoSurfCamp.setImageResource(R.drawable.kaluxlogo);
            descricao.setText("Escola de surf na Praia de São Torpes, em Sines. Serviço de ATL de surf, complementado com bar de praia / restaurante.");
        }

        else if (nomeSurfCamp.getText().equals("Alentejo Surf Camp (Vila Nova de Milfontes)")) {
            imagemSurfCamp.setImageResource(R.drawable.alentejosurfcamp);
            logoSurfCamp.setImageResource(R.drawable.alentejosurfcamp_logo);
            descricao.setText("Reconhecido como um dos melhores Surf Camps em Portugal, oferecemos cursos de surf de alto rendimento para iniciantes e intermediários para garantir o seu rápido progresso de qualidade no surf.");
        }

        else if (nomeSurfCamp.getText().equals("Ericeira SurfCamp (Ericeira)")) {
            imagemSurfCamp.setImageResource(R.drawable.ericeirasurf);
            logoSurfCamp.setImageResource(R.drawable.ericeiralogo);
            descricao.setText("A Ericeira Surf School promove surf tours, aulas de grupo, privadas e para crianças no âmbito do ensino e do treino, para todos os surfistas.");
        }

        else if (nomeSurfCamp.getText().equals("SurfMilfontes (Vila Nova de Milfontes)")) {
            imagemSurfCamp.setImageResource(R.drawable.surfmilfontes);
            logoSurfCamp.setImageResource(R.drawable.surfmilfonteslogo);
            descricao.setText("Queremos também promover o interesse dos jovens da zona de Vila Nova de Milfontes por um desporto que valorize não só as potencialidades do local onde vivem, mas também motive novas amizades. E, o melhor de tudo, incentiva o compartilhamento de conhecimentos e experiências ao mesmo tempo.");
        }

        ofertas = view.findViewById(R.id.btnConsultarOfertas);

        ofertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OffersFragment offersFragment  = new OffersFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_layout, offersFragment);
                transaction.commit();
            }
        });

        btnBack.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.homepage_layout, searchFragment);
            transaction.commit();
        });

        return view;
    }


}

