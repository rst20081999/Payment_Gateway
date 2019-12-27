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

public class CreatePassActivity extends AppCompatActivity {
    EditText enterpass,enterpassconfirm;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pass);
        enterpass=(EditText) findViewById(R.id.editText);
        enterpassconfirm=(EditText) findViewById(R.id.editText2);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1= enterpass.getText().toString();
                String text2= enterpass.getText().toString();

                if(text1.equals("")||text2.equals("")){
                    Toast.makeText(CreatePassActivity.this,"Error in Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(text1.equals(text2)){
                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor= settings.edit();
                        editor.putString("password",text1);
                        editor.apply();

                        Intent Homeintent = new Intent(CreatePassActivity.this, MainActivity.class);
                        startActivity(Homeintent);
                        finish();
                    }
                    else{
                        Toast.makeText(CreatePassActivity.this,"Paddword Dorsnt match",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
