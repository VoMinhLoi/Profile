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
    public static final String NAME = "name";
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
                Intent intentLogIn1 = getIntent();
                String useNameRG = intentLogIn1.getStringExtra(RegisterActivity.NAME);
                String passRG = intentLogIn1.getStringExtra(RegisterActivity.PASS);
                if(passVar.equals("")){
                    System.out.println("Hãy nhập mật khẩu!!!");
                }
                else {
                    if(userNameVar.equals(useNameRG)){
                        if(passVar.equals(passRG)){
                            Intent intentLogIn2 = new Intent(LoginActivity.this, MainActivity.class);
                            intentLogIn2.putExtra(NAME, userNameVar);
                            startActivity(intentLogIn2);
                        }
                        else {
                            System.out.println("Sai mật khẩu!!!");
                        }

                    }
                    else
                        System.out.println("Sai tài khoản!!!");
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
}
