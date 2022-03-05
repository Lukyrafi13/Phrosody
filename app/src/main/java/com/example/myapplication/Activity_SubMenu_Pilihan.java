package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Form.Auditory_Discrimination.Activity_Long_Item_Auditory_Discrimination;
import com.example.myapplication.Form.Auditory_Discrimination.Activity_Short_Item_Auditory_Discrimination;
import com.example.myapplication.Form.Imitation.Activity_Long_Item_Imitation;
import com.example.myapplication.Form.Imitation.ShortItemImitationActivity;
import com.example.myapplication.Function.Affect.Activity_Affect_Input;
import com.example.myapplication.Function.Affect.Activity_Affect_Output;
import com.example.myapplication.Function.Chunking.Activity_Chunking_Input;
import com.example.myapplication.Function.Chunking.Activity_Chunking_Output;
import com.example.myapplication.Function.Focus.Activity_Focus_Input;
import com.example.myapplication.Function.Focus.Activity_Focus_Output;
import com.example.myapplication.Function.TurnEnd.QuizTurnEndInput;
import com.example.myapplication.Function.TurnEnd.QuizTurnEndOutputActivity;

public class Activity_SubMenu_Pilihan extends AppCompatActivity {

    private Button btnContoh, btnLatihan, btnSoal;
    private TextView submenu;

    private String key_SubMenu_Pilihan = "SUBMENU_PILIHAN";
    private String key_SubMenu_Soal = "SUBMENU_SOAL";
    private String key_SubMenu = "SUBMENU";
    String Pilihan_SubMenu_Soal_Contoh = "1";
    String Pilihan_SubMenu_Soal_Latihan = "2";
    String Pilihan_SubMenu_Soal_Soal = "3";

    String terima_SubMenu_Pilihan, terima_SubMenu;
    Integer SubMenu_Pilihan;

    /*
    Sub Menu Pilihan :
    Sub_Menu_Pilihan == 1 --> Imitation Short Item
    Sub_Menu_Pilihan == 2 --> Imitation Long Item
    Sub_Menu_Pilihan == 3 --> Auditory Short Item
    Sub_Menu_Pilihan == 4 --> Auditory Long Item
    Sub_Menu_Pilihan == 5 --> Turn End Input Item
    Sub_Menu_Pilihan == 6 --> Turn End Output Item
    Sub_Menu_Pilihan == 7 --> Affect Input Item
    Sub_Menu_Pilihan == 8 --> Affect Output Item
    Sub_Menu_Pilihan == 9 --> Chunking Input Item
    Sub_Menu_Pilihan == 10 --> Chinking Output Item
    Sub_Menu_Pilihan == 11 --> Focus Input Item
    Sub_Menu_Pilihan == 12 --> Focus Output Item

     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_pilihan);

        btnContoh = findViewById(R.id.btnContoh);
        btnLatihan = findViewById(R.id.btnLatihan);
        btnSoal = findViewById(R.id.btnSoal);
        submenu = findViewById(R.id.submenu);

        terima_SubMenu_Pilihan = getIntent().getStringExtra(key_SubMenu_Pilihan);
        SubMenu_Pilihan = Integer.parseInt(terima_SubMenu_Pilihan);

        terima_SubMenu = getIntent().getStringExtra(key_SubMenu);
        submenu.setText(terima_SubMenu);


        btnContoh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Pilihan == 1) {
                    //Imitation Short Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, ShortItemImitationActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 2) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Imitation.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 3) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Short_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 4) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 5) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndInput.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 6) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndOutputActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 7) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 8) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 9) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 10) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 11) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 12) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Contoh);
                    startActivity(intent);

                }
            }
        });

        btnLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Pilihan == 1) {
                    //Imitation Short Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, ShortItemImitationActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 2) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Imitation.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 3) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Short_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 4) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 5) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndInput.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 6) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndOutputActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 7) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 8) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 9) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 10) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 11) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 12) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Latihan);
                    startActivity(intent);

                }
            }
        });

        btnSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Pilihan == 1) {
                    //Imitation Short Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, ShortItemImitationActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 2) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Imitation.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 3) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Short_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 4) {
                    //Imitation Long Item
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Long_Item_Auditory_Discrimination.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 5) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndInput.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 6) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, QuizTurnEndOutputActivity.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 7) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 8) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Affect_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 9) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 10) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Chunking_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 11) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Input.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                } else if (SubMenu_Pilihan == 12) {
                    Intent intent = new Intent(Activity_SubMenu_Pilihan.this, Activity_Focus_Output.class);
                    intent.putExtra(key_SubMenu_Soal, Pilihan_SubMenu_Soal_Soal);
                    startActivity(intent);

                }

            }
        });
    }
}