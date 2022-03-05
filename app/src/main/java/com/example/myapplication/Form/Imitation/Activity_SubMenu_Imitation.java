package com.example.myapplication.Form.Imitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.R;

public class Activity_SubMenu_Imitation extends AppCompatActivity {

    private Button btnShortImitation, btnLongImitation;

    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Imitation_Sort = "1";
    String Pilihan_SubMenu_Imitation_Long = "2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_imitation);

        btnLongImitation = findViewById(R.id.btnLongImitation);
        btnShortImitation = findViewById(R.id.btnShortImitation);

        btnShortImitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Imitation.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Imitation_Sort);
                intent.putExtra(key_SubMenu, "Imitation");
                startActivity(intent);
            }
        });


        btnLongImitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Imitation.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Imitation_Long);
                intent.putExtra(key_SubMenu, "Imitation");
                startActivity(intent);
            }
        });
    }
}