package com.example.mdk0103lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText log, pass, logV, passV;
    Button save, load;
    SharedPreferences mySP;
    final String SAVE_TEXT1 = "Сохранение почты";
    final String SAVE_TEXT2 = "Сохранение пароля";
    final String SAVE_TEXT3 = "Сохранение подтверждения почты";
    final String SAVE_TEXT4 = "Сохранение подтверждения пароля";


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

        save.setOnClickListener(view -> save());
        load.setOnClickListener(view -> load());
    }

    public void save(){
        savePref();
    }

    public void load(){
        loadPref();
    }

    void savePref(){
        mySP = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor edLog = mySP.edit();
        edLog.putString(SAVE_TEXT1, log.getText().toString());
        edLog.putString(SAVE_TEXT2, pass.getText().toString());
        edLog.putString(SAVE_TEXT3, logV.getText().toString());
        edLog.putString(SAVE_TEXT4, passV.getText().toString());
        edLog.apply();

        log.getText().clear();
        pass.getText().clear();
        logV.getText().clear();
        passV.getText().clear();

        Toast.makeText(this, "Сохранено", Toast.LENGTH_LONG).show();
    }

    void loadPref(){
        mySP = getPreferences(MODE_PRIVATE);

        String saveLog = mySP.getString(SAVE_TEXT1, "");
        log.setText(saveLog);

        String savePass = mySP.getString(SAVE_TEXT2, "");
        pass.setText(savePass);

        String saveLog_Valid = mySP.getString(SAVE_TEXT3, "");
        logV.setText(saveLog_Valid);

        String savePass_Valid = mySP.getString(SAVE_TEXT4, "");
        passV.setText(savePass_Valid);

        Toast.makeText(this, "Загружено", Toast.LENGTH_LONG).show();
    }
}