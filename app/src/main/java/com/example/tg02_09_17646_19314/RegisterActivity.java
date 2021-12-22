package com.example.tg02_09_17646_19314;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    public EditText user;
    public EditText email;
    public EditText pass;
    public EditText confPass;
    public Button registerButton;
    public String username = "";
    public String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();

        registerButton = (Button) findViewById(R.id.btnRegisto);
        registerButton.setOnClickListener(v->{
            Toast.makeText(this, "Entrou", Toast.LENGTH_SHORT).show();
            register();

        });
    }

    private void initializeViews()
    {
        user = (EditText) findViewById(R.id.etRegUtilizador);
        email = (EditText) findViewById(R.id.etRegEmail);
        pass = (EditText) findViewById(R.id.etRegPass);
        confPass = (EditText) findViewById(R.id.etRegConfPass);
    }

    public void deleteFile(){
        File dir = getFilesDir();
        File file = new File(dir, "my_filename");
        boolean deleted = file.delete();
    }

    public void register(){
        String FILENAME = "logins_file";
        String username = user.getText().toString() + "\n";
        String mail = email.getText().toString() + "\n";
        String password = pass.getText().toString() + "\n";
        String confPassword = confPass.getText().toString() + "\n";
        String division = "- \n";

        if (username.length() > 1 && mail.length() > 1 && password.length() > 1) {
            if (password.equals(confPassword)) {
                FileOutputStream fos = null;
                try {
                    File directory = getFilesDir();
                    File file = new File(directory, FILENAME);
                    fos = new FileOutputStream(file, true);

                    fos.write(username.getBytes());
                    fos.write(mail.getBytes());
                    fos.write(password.getBytes());
                    fos.write(division.getBytes());

                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "O ficheiro falhou!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Nao encontrou file", Toast.LENGTH_SHORT).show();
                }
                //EditText email = (EditText) findViewById(R.id.);
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "As passwords não correspondem!",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Prencha os campos!",Toast.LENGTH_SHORT).show();
        }

    }
}

