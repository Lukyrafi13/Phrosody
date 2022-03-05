package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class menuutama extends AppCompatActivity {

    private Button btnLogin,btnTentangAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutama);

        btnLogin = findViewById(R.id.btnLogin);
        btnTentangAplikasi = findViewById(R.id.btnTentangAplikasi);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuutama.this, MulaiActivity.class);
                startActivity(intent);
            }
        });

        btnTentangAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuutama.this, Tentang_Aplikasi_Activity.class);
                startActivity(intent);
            }
        });
    }


}