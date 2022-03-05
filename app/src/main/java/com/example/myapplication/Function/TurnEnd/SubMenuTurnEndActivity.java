package com.example.myapplication.Function.TurnEnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.R;

public class SubMenuTurnEndActivity extends AppCompatActivity {

    private Button btnTunEndInput, btnTurnEndOutput;

    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_TurnEnd_Input = "5";
    String Pilihan_SubMenu_TurnEnd_Output = "6";
    String Pilihan_SubMenu_Turn_End = "Turn End";

    private String key_pilihan = "KEY_PILIHAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_turn_end);

        btnTunEndInput = findViewById(R.id.btnTurnEndInput);
        btnTurnEndOutput = findViewById(R.id.btnTurnEndOutput);

        btnTunEndInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenuTurnEndActivity.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_TurnEnd_Input);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Turn_End);
                startActivity(intent);
            }
        });

        btnTurnEndOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenuTurnEndActivity.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_TurnEnd_Output);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Turn_End);
                startActivity(intent);
            }
        });


    }
}