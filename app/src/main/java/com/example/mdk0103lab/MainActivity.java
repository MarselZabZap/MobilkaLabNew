package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSum, btnDiff, nextLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSum = findViewById(R.id.buttonSum);
        btnDiff = findViewById(R.id.buttonDiff);
        nextLab = findViewById(R.id.nextLab);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum(view);
            }
        });

        btnDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diff(view);
            }
        });

        findViewById(R.id.nextLab).setOnClickListener(view ->
                startActivity(new Intent(this, FunnyActivity.class)));
    }

    public void sum(View view){
        try {
            EditText num1 = findViewById(R.id.edt_num_1);
            EditText num2 = findViewById(R.id.edt_num_2);
            TextView result = findViewById(R.id.textViewRes);

            int firstNum = Integer.parseInt(num1.getText().toString());
            int secondNum = Integer.parseInt(num2.getText().toString());
            int sum = firstNum + secondNum;

            result.setText("Сумма = " + sum);
        }
        catch (Exception ex) {
            Toast t = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
            t.show();
        }
    }

    public void diff(View view){
        try {
            EditText num1 = findViewById(R.id.edt_num_1);
            EditText num2 = findViewById(R.id.edt_num_2);
            TextView result = findViewById(R.id.textViewRes);

            int firstNum = Integer.parseInt(num1.getText().toString());
            int secondNum = Integer.parseInt(num2.getText().toString());
            int diff = firstNum - secondNum;

            result.setText("Разность = " + diff);
        }
        catch (Exception ex) {
            Toast t = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
            t.show();
        }
    }


}