package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Form.SubMenuFormActivity;
import com.example.myapplication.Function.SubMenu_Function;

public class SubMenu extends AppCompatActivity {

    private Button btnFunction, btnForm, btnHapusNama;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        btnFunction = findViewById(R.id.btnFunction);
        btnForm = findViewById(R.id.btnForm);
        btnHapusNama = findViewById(R.id.btnHapusNama);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);

        btnHapusNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(SubMenu.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btnFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu.this, SubMenu_Function.class);
                startActivity(intent);
            }
        });

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu.this, SubMenuFormActivity.class);
                startActivity(intent);
            }
        });
    }
}