package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    private TextView txtWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String strUsername = getIntent().getStringExtra("Username");
        txtWelcome =findViewById(R.id.txt_welcome);
        txtWelcome.setText("Welcome " +strUsername);

    }
}
