package com.example.myapplication.Function.Chunking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activity_SubMenu_Pilihan;
import com.example.myapplication.Function.Affect.Activity_Affect_Input;
import com.example.myapplication.Function.Affect.SubMenu_Affect;
import com.example.myapplication.MulaiActivity;
import com.example.myapplication.R;

public class Activity_SubMenu_Chunking extends AppCompatActivity {

    private Button btnChunkingInput, btnChunkingOutput;
    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Chunking_Input = "9";
    String Pilihan_SubMenu_Chunking_Output = "10";
    String Pilihan_SubMenu_Chunking = "Chunking";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_chunking);

        btnChunkingInput = findViewById(R.id.btnChunkingInput);
        btnChunkingOutput = findViewById(R.id.btnChunkingOutput);

        btnChunkingInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Chunking.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Chunking_Input);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Chunking);
                startActivity(intent);
            }
        });

        btnChunkingOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_SubMenu_Chunking.this, Activity_SubMenu_Pilihan.class);
                intent.putExtra(key_SubMenu_Pilihan, Pilihan_SubMenu_Chunking_Output);
                intent.putExtra(key_SubMenu, Pilihan_SubMenu_Chunking);
                startActivity(intent);
            }
        });


    }
}