package com.example.payment.pass_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payment.MainActivity;
import com.example.payment.R;
import com.example.payment.SplashScreen;

public class EnterPassActivity extends AppCompatActivity {
    Button button;
    EditText enterpass;
    String password,getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pass);
        SharedPreferences settings =getSharedPreferences("PREFS",0);
        getPassword=settings.getString("password","");

        enterpass=(EditText) findViewById(R.id.editText);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=enterpass.getText().toString();
                if(password.equals(getPassword)){
                    Intent Homeintent = new Intent(EnterPassActivity.this, MainActivity.class);
                    startActivity(Homeintent);
                    finish();
                }
                else{
                    Toast.makeText(EnterPassActivity.this,"Please Enter Correct Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
