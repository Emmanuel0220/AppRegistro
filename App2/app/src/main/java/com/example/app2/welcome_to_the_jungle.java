package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app2.Json.MyInfo;

public class welcome_to_the_jungle extends AppCompatActivity {

    String aux = null;
    MyInfo myInfo = null;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {

            Object object = null;

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome_to_the_jungle);
            textView = findViewById(R.id.textView65);
            Intent intent = getIntent();
            if (intent != null) {
                if (intent.getExtras() != null) {
                    object = intent.getExtras().get("Objeto");
                    if (object != null) {
                        if (object instanceof MyInfo) {
                            myInfo = (MyInfo) object;
                            textView.setText("Bienvenido " + myInfo.getUsuario());
                        }
                    }
                }
            }
        }
    }
}