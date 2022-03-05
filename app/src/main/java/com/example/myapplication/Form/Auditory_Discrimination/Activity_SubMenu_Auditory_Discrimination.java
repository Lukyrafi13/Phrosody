package com.example.myapplication.Form.Auditory_Discrimination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.R;

public class Activity_SubMenu_Auditory_Discrimination extends AppCompatActivity {

    private Button btnShortAD, btnLongAD;

    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Auditory_Sort = "3";
    String Pilihan_SubMenu_Auditory_Long = "4";
    String Pilihan_SubMenu_Auditory = "Auditory Discrimination";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_auditory_discrimination);

        btnLongAD = findViewById(R.id.btnLongAD);
        btnShortAD = findViewById(R.id.btnShortAD);

        btnShortAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Auditory_Discrimination.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Auditory_Sort);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Auditory);
                startActivity(intent);
            }
        });


        btnLongAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Auditory_Discrimination.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Auditory_Long);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Auditory);
                startActivity(intent);
            }
        });
    }
}