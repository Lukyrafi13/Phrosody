package com.example.myapplication.Function.TurnEnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class QuizTurnEndOutputActivity extends AppCompatActivity {

    private ImageView gambarQuiz;
    private Button btnNext;
    private int currentIndex = 0;
    private TextView soal;

    //soal Quiz
    private Integer[] GambarSoal = {R.drawable.d_keju, R.drawable.t_apel, R.drawable.d_jeruk, R.drawable.t_kue, R.drawable.t_madu, R.drawable.d_coklat, R.drawable.d_pisang, R.drawable.t_anggur, R.drawable.d_jagung, R.drawable.t_permen, R.drawable.t_air, R.drawable.d_keripik, R.drawable.t_telur, R.drawable.t_puding, R.drawable.d_susu, R.drawable.d_kacang};
    private Integer[] GambarContoh = {R.drawable.d_teh};//yang keju salah belum ada rousrce nya
    private Integer[] GambarLatihan = {R.drawable.d_roti_tanya};

    private String key_SubMenu_Soal = "SUBMENU_SOAL";
    private String terima_SubMenu_Soal;



    /*
    Sub Menu Soal :
    Sub_Menu_Soal == 1 --> Contoh
    Sub_Menu_Soal == 2 --> Latihan
    Sub_Menu_Soal == 3 --> Soal
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_turn_end_output);

        gambarQuiz = findViewById(R.id.gambarQuiz_FE);
        btnNext = findViewById(R.id.btnNext_FE);

        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);


        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarQuiz.setImageResource(GambarContoh[currentIndex]);
        } else if (SubMenu_Soal == 2) {
            gambarQuiz.setImageResource(GambarLatihan[currentIndex]);
        } else if (SubMenu_Soal == 3) {
            gambarQuiz.setImageResource(GambarSoal[currentIndex]);
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SubMenu_Soal == 1) {
                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(QuizTurnEndOutputActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(QuizTurnEndOutputActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(QuizTurnEndOutputActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                }

            }
        });

    }

    public void nextImageSoal() {
        currentIndex++;
        gambarQuiz.setImageResource(GambarSoal[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageLatihan() {
        currentIndex++;
        gambarQuiz.setImageResource(GambarLatihan[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageContoh() {
        currentIndex++;
        gambarQuiz.setImageResource(GambarContoh[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }
}