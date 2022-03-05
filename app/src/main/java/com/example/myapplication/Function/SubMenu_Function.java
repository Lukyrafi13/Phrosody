package com.example.myapplication.Function;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Function.Chunking.Activity_Chunking_Input;
import com.example.myapplication.Function.Chunking.Activity_SubMenu_Chunking;
import com.example.myapplication.Function.Focus.Activity_SubMenu_Focus;
import com.example.myapplication.Function.TurnEnd.SubMenuTurnEndActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Function.Affect.SubMenu_Affect;

public class SubMenu_Function extends AppCompatActivity {

    private Button btnTurnEnd, BtnAffect, btnFocus, btnChunking;
    private TextView tvWatermark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_function);

        btnTurnEnd = findViewById(R.id.btnTurnEnd);
        BtnAffect = findViewById(R.id.btnAffect);
        btnFocus = findViewById(R.id.btnFocus);
        btnChunking = findViewById(R.id.btnChunking);
        tvWatermark = findViewById(R.id.watermark);


        btnChunking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubMenu_Function.this, Activity_SubMenu_Chunking.class);
                startActivity(intent);
            }
        });

        btnTurnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu_Function.this, SubMenuTurnEndActivity.class);
                startActivity(intent);

            }
        });

        BtnAffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubMenu_Function.this, SubMenu_Affect.class);
                startActivity(intent);
            }
        });

        btnFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubMenu_Function.this, Activity_SubMenu_Focus.class);
                startActivity(intent);
            }
        });
    }
}