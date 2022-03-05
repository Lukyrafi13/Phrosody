package com.example.myapplication.Function.Affect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.R;

public class SubMenu_Affect extends AppCompatActivity {

    private Button btnAffectInput, btnAffectOutput;
    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Affect_Input = "7";
    String Pilihan_SubMenu_Affect_Output = "8";
    String Pilihan_SubMenu_Affect = "Affect";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_affect);

        btnAffectInput = findViewById(R.id.btnAffectInput);
        btnAffectOutput = findViewById(R.id.btnAffectOutput);

        btnAffectInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubMenu_Affect.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Affect_Input);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Affect);
                startActivity(intent);
            }
        });

        btnAffectOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubMenu_Affect.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Affect_Output);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Affect);
                startActivity(intent);
            }
        });
    }
}