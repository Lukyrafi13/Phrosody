package com.example.myapplication.Function.Focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.R;

public class Activity_SubMenu_Focus extends AppCompatActivity {

    private Button btnFocusInput, btnFocusOutput;
    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Focus_Input = "11";
    String Pilihan_SubMenu_Focus_Output = "12";
    String Pilihan_SubMenu_Focus = "Focus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_focus);

        btnFocusInput = findViewById(R.id.btnFocusInput);
        btnFocusOutput = findViewById(R.id.btnFocusOutput);

        btnFocusInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Focus.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Focus_Input);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Focus);
                startActivity(intent);
            }
        });

        btnFocusOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Focus.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Focus_Output);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Focus);
                startActivity(intent);
            }
        });
    }
}