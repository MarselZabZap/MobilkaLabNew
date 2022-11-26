package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText log, pass, logV, passV;
    Button save, load, singIn;
    public static SharedPreferences mySP;
    static final String USER_DATA = "";
    static final String SAVE_TEXT1 = "Сохранение почты";
    static final String SAVE_TEXT2 = "Сохранение пароля";
    final String SAVE_TEXT3 = "Сохранение подтверждения почты";
    final String SAVE_TEXT4 = "Сохранение подтверждения пароля";
    public static String saveLog, savePass, saveLog_Valid, savePass_Valid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        log = findViewById(R.id.edtLogin);
        pass = findViewById(R.id.edtPassword);
        logV = findViewById(R.id.edtLogin_Valid);
        passV = findViewById(R.id.edtPassword_Valid);
        save = findViewById(R.id.btnSave);
        load = findViewById(R.id.btnDownload);
        singIn = findViewById(R.id.bntSingIn);

        save.setOnClickListener(view -> save());
        load.setOnClickListener(view -> load());

        singIn.setOnClickListener(view ->
                startActivity(new Intent(this, SingInActivity.class)));
    }

    public void save(){
        savePref();
    }

    public void load(){
        loadPref();
    }


    void savePref(){

        if (log.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || logV.getText().toString().isEmpty() || passV.getText().toString().isEmpty()) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_LONG).show();
        }
        else if (pass.getText().toString().length() < 10) {
            Toast.makeText(this, "Пароль должен состоять минимум из 10 символов", Toast.LENGTH_LONG).show();
        }
        else if (!passV.getText().toString().equals(pass.getText().toString())) {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
        }
        else {
            mySP = getPreferences(MODE_PRIVATE);

            SharedPreferences.Editor edit = mySP.edit();
            edit.putString(SAVE_TEXT1, log.getText().toString());
            edit.putString(SAVE_TEXT2, pass.getText().toString());
            edit.putString(SAVE_TEXT3, logV.getText().toString());
            edit.putString(SAVE_TEXT4, passV.getText().toString());

            log.getText().clear();
            pass.getText().clear();
            logV.getText().clear();
            passV.getText().clear();
            edit.apply();
            Toast.makeText(this, "Сохранено", Toast.LENGTH_LONG).show();
        }
    }

    void loadPref(){
        mySP = getPreferences(MODE_PRIVATE);

        saveLog = mySP.getString(SAVE_TEXT1, "");
        log.setText(saveLog);

        savePass = mySP.getString(SAVE_TEXT2, "");
        pass.setText(savePass);

        saveLog_Valid = mySP.getString(SAVE_TEXT3, "");
        logV.setText(saveLog_Valid);

        savePass_Valid = mySP.getString(SAVE_TEXT4, "");
        passV.setText(savePass_Valid);

        Toast.makeText(this, "Загружено", Toast.LENGTH_LONG).show();
    }
}