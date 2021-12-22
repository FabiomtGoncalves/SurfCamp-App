package com.example.tg02_09_17646_19314;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerButton = findViewById(R.id.btnRegistar);
        registerButton.setOnClickListener(v->{
            Intent register = new Intent(this, RegisterActivity.class);
            startActivity(register);
        });

        Button loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(v->{
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        });
    }
}