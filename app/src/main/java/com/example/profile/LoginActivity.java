package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button loginBTVar, registerBTVar;
    EditText userNameETVar, passETVar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBTVar = (Button) findViewById(R.id.loginBT);
        userNameETVar = (EditText) findViewById(R.id.nameET);
        passETVar = (EditText) findViewById(R.id.passET);
        loginBTVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameVar = userNameETVar.getText().toString();
                String passVar = passETVar.getText().toString();
                Intent intent = getIntent();
                String useNameRG = intent.getStringExtra(RegisterActivity.NAME);
                String passRG = intent.getStringExtra(RegisterActivity.PASS);
                if(userNameVar.equals(useNameRG)){
                    System.out.println(userNameVar);
                    System.out.println(useNameRG);
                    if(passVar.equals(passRG)){
                        System.out.println(passVar);
                        System.out.println(passRG);
                        Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intentMain);

                    }
                }
                else {
                    System.out.println("Sai tài khoản hoặc mật khẩu");
                }
            }
        });
        registerBTVar = (Button) findViewById(R.id.registerBT);
        registerBTVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setDataByExtra(){

    }
}
