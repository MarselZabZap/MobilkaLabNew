package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FunnyActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);

        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enter();
            }
        });

        findViewById(R.id.nextLab).setOnClickListener(view ->
                startActivity(new Intent(this, HistoryTextActivity.class)));
    }

    public void Enter(){
        TextView text = findViewById(androidx.core.R.id.text);
        text.setText("Поменяли текст");
        Toast t = Toast.makeText(this, "Ураааааа!!!", Toast.LENGTH_LONG); //Всплывающее сообщение
        t.show();
        Button btn2 = findViewById(R.id.btn2);
        btn2.setVisibility(View.INVISIBLE); //Исчезновение кнопки
    }
}