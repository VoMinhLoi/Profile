package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView nameTVVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentMain = getIntent();
        String name = intentMain.getStringExtra(LoginActivity.NAME);
        System.out.println(name);
        nameTVVar = (TextView) findViewById (R.id.nameTV);
        nameTVVar.setText(name);
    }
}