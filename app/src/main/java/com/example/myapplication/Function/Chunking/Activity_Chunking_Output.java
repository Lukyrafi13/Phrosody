package com.example.myapplication.Function.Chunking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Function.Affect.Activity_Affect_Output;
import com.example.myapplication.Function.TurnEnd.QuizTurnEndOutputActivity;
import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

public class Activity_Chunking_Output extends AppCompatActivity {

    private ImageView gambarQuiz;
    private ImageView jawabanQuizBenar,jawabanQuizSalah;
    private int currentIndex = 0;
    private TextView soal;
    private String key = "KEY_NILAI";
    int nilai = 0;

    //soal Quiz
    private Integer[] GambarSoal = {R.drawable.ci_soal1_b, R.drawable.ci_soal2_a, R.drawable.ci_soal3_b, R.drawable.ci_soal4_a, R.drawable.ci_soal5_a, R.drawable.ci_soal6_b, R.drawable.ci_soal7_a, R.drawable.ci_soal8_b, R.drawable.ci_soal9_a, R.drawable.ci_soal10_a, R.drawable.ci_soal11_b, R.drawable.ci_soal12_a, R.drawable.ci_soal13_b, R.drawable.ci_soal14_a, R.drawable.ci_soal15_a, R.drawable.ci_soal16_b};
    private Integer[] GambarContoh = {R.drawable.c_contoh1};
    private Integer[] GambarLatihan = {R.drawable.c_latihan1};

    private String key_SubMenu_Soal = "SUBMENU_SOAL";
    private String terima_SubMenu_Soal;
    String[] kirimJawaban;//ini

    /*
    Sub Menu Soal :
    Sub_Menu_Soal == 1 --> Contoh
    Sub_Menu_Soal == 2 --> Latihan
    Sub_Menu_Soal == 3 --> Soal
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chunking_output);

        gambarQuiz = findViewById(R.id.gambarQuiz_CO);
        jawabanQuizBenar = findViewById(R.id.jawabanQuizBenar);
        jawabanQuizSalah = findViewById(R.id.jawabanQuizSalah);

        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);


        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarQuiz.setImageResource(GambarContoh[currentIndex]);
            kirimJawaban = new String[GambarContoh.length];
        } else if (SubMenu_Soal == 2) {
            gambarQuiz.setImageResource(GambarLatihan[currentIndex]);
            kirimJawaban = new String[GambarLatihan.length];
        } else if (SubMenu_Soal == 3) {
            gambarQuiz.setImageResource(GambarSoal[currentIndex]);
            kirimJawaban = new String[GambarSoal.length];
        }

        jawabanQuizBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kirimJawaban[currentIndex] = "benar";//ini
                nilai++;

                if (SubMenu_Soal == 1) {
                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }
                }


            }
        });

        jawabanQuizSalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                kirimJawaban[currentIndex] = "salah";//ini

                if (SubMenu_Soal == 1) {
                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
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