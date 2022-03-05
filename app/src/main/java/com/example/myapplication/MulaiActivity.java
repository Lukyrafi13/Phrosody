package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Form.Auditory_Discrimination.Activity_Long_Item_Auditory_Discrimination;
import com.example.myapplication.Form.Auditory_Discrimination.Activity_Short_Item_Auditory_Discrimination;
import com.example.myapplication.Function.TurnEnd.QuizTurnEndInput;
import com.example.myapplication.Function.TurnEnd.QuizTurnEndOutputActivity;

public class MulaiActivity extends AppCompatActivity {

    private EditText etNama;
    private Button btnMulai;

    Intent intent;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);

        etNama = findViewById(R.id.nama);
        btnMulai = findViewById(R.id.btnMulai);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        sharedPreferences.contains("nama");

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nama", nama);
                editor.apply();

                Intent intent = new Intent(MulaiActivity.this, SubMenu.class);
                startActivity(intent);


            }
        });
    }
}