package com.example.tg02_09_17646_19314;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private String user = "";
    private String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();

        Button entrar = findViewById(R.id.btnEntrar);
        entrar.setOnClickListener(v-> {
            makeLogin();
        });
    }

    private void initializeViews()
    {
        username = (EditText) findViewById(R.id.etUtilizador);
        password = (EditText) findViewById(R.id.etPassword);
    }

    public void makeLogin(){
        String FILENAME = "logins_file";
        String user = username.getText().toString();
        String pass = password.getText().toString();
        File path = getFilesDir();

        boolean b = false;
        String aBuffer = "";
        int counter = 0;
        try {
            File myFile = new File(path, FILENAME);
            BufferedReader myReader = new BufferedReader(new FileReader(myFile));
            String aDataRow = "";

            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow + " ";
                if(counter % 4 == 0 && user.equals(aDataRow)){
                    b = true;
                    aDataRow = myReader.readLine();
                    aBuffer += aDataRow + " ";
                    aDataRow = myReader.readLine();
                    aBuffer += aDataRow + " ";
                    if(pass.equals(aDataRow)){
                        Intent login = new Intent(this, HomePageActivity.class);
                        Toast.makeText(this, "Login Efetuado com Sucesso!", Toast.LENGTH_SHORT).show();
                        startActivity(login);
                    }else{
                        Toast.makeText(getApplicationContext(), "As credenciais estão inválidas!",Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!b){
            Toast.makeText(getApplicationContext(), "As credenciais estão inválidas!",Toast.LENGTH_SHORT).show();
        }
    }
}