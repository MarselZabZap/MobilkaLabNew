package com.example.mdk0103lab;

import static com.example.mdk0103lab.RegistrationActivity.SAVE_TEXT1;
import static com.example.mdk0103lab.RegistrationActivity.SAVE_TEXT2;
import static com.example.mdk0103lab.RegistrationActivity.mySP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingInActivity extends AppCompatActivity {
    EditText login, password;
    Button btnSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btnSingIn = findViewById(R.id.bntSingIn);

        btnSingIn.setOnClickListener(view -> validation());
    }

    void validation() {
        mySP = getPreferences(MODE_PRIVATE);

        String saveLog = mySP.getString(SAVE_TEXT1, "");
        Log.d("TAG", "validation: " + saveLog);

        /*if (!saveLog.equals(login.getText().toString()) || login.getText().toString().isEmpty()) {
            Toast.makeText(this, "Неверный логин", Toast.LENGTH_LONG).show();
        }
        else if (!savePass.equals(password.getText().toString()) || password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Успешно", Toast.LENGTH_LONG).show();
        }*/
    }
}