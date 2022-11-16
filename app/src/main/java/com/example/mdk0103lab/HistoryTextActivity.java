package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HistoryTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_text);

        Button check_button = findViewById(R.id.check_button);

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkClick();
            }
        });
    }

    public void checkClick(){
        try {
            Spinner ans1 = findViewById(R.id.ans1);
            Spinner ans2 = findViewById(R.id.ans2);
            Spinner ans3 = findViewById(R.id.ans3);
            Spinner ans4 = findViewById(R.id.ans4);
            Spinner ans5 = findViewById(R.id.ans5);
            Spinner ans6 = findViewById(R.id.ans6);
            Spinner ans7 = findViewById(R.id.ans7);
            Spinner ans8 = findViewById(R.id.ans8);
            Spinner ans9 = findViewById(R.id.ans9);
            Spinner ans10 = findViewById(R.id.ans10);

            ArrayList user_answer = new ArrayList<>();
            user_answer.add(ans1.getSelectedItem().toString());
            user_answer.add(ans2.getSelectedItem().toString());
            user_answer.add(ans3.getSelectedItem().toString());
            user_answer.add(ans4.getSelectedItem().toString());
            user_answer.add(ans5.getSelectedItem().toString());
            user_answer.add(ans6.getSelectedItem().toString());
            user_answer.add(ans7.getSelectedItem().toString());
            user_answer.add(ans8.getSelectedItem().toString());
            user_answer.add(ans9.getSelectedItem().toString());
            user_answer.add(ans10.getSelectedItem().toString());

            ArrayList correct_answer = new ArrayList();
            correct_answer.addAll(Arrays.asList(new String[]{
                    "1861", "988", "Елизавета 1",
                    "США", "1949", "1991",
                    "Причина неизвестна", "Бенджамин Франклин",
                    "Кровавое воскресенье",
                    "Хотел больше свободного времени, и помочь детям"
            }));

            int result = 0;
            for (int i = 0; i < 10; i++) {
                Object answer = correct_answer.get(i);
                if (correct_answer.get(i).equals(user_answer.get(i)))
                    result++;
            }

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("user_result", ("Вы надбрали: " + result + " из 10"));
            startActivity(intent);
            Toast.makeText(this, "Вы набрали " + result + " из 10", Toast.LENGTH_SHORT).show();

        } catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}