package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        String result = i.getStringExtra("user_result");
        TextView resultMessage = findViewById(R.id.resultMessage);
        resultMessage.setText(result);
    }
}