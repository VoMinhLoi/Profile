package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button  registerBTVar, loginBTVar;
    EditText nameBTVar, passETVar, confirmPassETVar;
    public static final String NAME = "name";
    public static final String PASS = "pass";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerBTVar = (Button) findViewById(R.id.registerBT);
        registerBTVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameBTVar = (EditText) findViewById(R.id.nameET);
                String nameVar = nameBTVar.getText().toString();
                passETVar = (EditText) findViewById(R.id.passET);
                String passVar = passETVar.getText().toString();
                confirmPassETVar = (EditText) findViewById(R.id.confirmPassET);
                String confirmPassVar = confirmPassETVar.getText().toString();
//                passVar == confirmPassVar
                if(nameVar.equals("") || passVar.equals("")){
                    System.out.println("Empty field!!!");
                }
                else{
                    if (passVar.equals(confirmPassVar)) {
                        Register(nameVar, passVar);
                    } else
                        System.out.println("Password does not match!!");
                }
            }
        });

        loginBTVar = (Button) findViewById(R.id.loginBT);
        loginBTVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    public void Register(String nameVar, String passVar){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.putExtra(NAME, nameVar);
        intent.putExtra(PASS, passVar);
        startActivity(intent);
    }
}
