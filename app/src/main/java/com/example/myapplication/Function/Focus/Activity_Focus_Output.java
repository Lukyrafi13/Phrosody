package com.example.myapplication.Function.Focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Function.Affect.Activity_Affect_Output;
import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

public class Activity_Focus_Output extends AppCompatActivity {

    private ImageView gambarQuiz_FE;
    private ImageView jawabanQuizBenar,jawabanQuizSalah;
    private int currentIndex = 0;
    private TextView soal;
    private String key = "KEY_NILAI";
    int nilai = 0;


    //soal Quiz
    private Integer[] GambarQuizContoh = {R.drawable.fe_sapi_hijau};
    private Integer[] GambarQuizLatihan = {R.drawable.fe_domba_hijau};
    private Integer[] GambarQuizSoal = {R.drawable.fe_sapi_merah, R.drawable.fe_domba_merah, R.drawable.fe_sapi_merah, R.drawable.fe_domba_merah, R.drawable.fe_sapi_biru, R.drawable.fe_domba_biru, R.drawable.fe_sapi_biru, R.drawable.fe_domba_biru, R.drawable.fe_sapi_kuning, R.drawable.fe_domba_kuning, R.drawable.fe_sapi_kuning, R.drawable.fe_domba_kuning, R.drawable.fe_domba_hijau, R.drawable.fe_sapi_hijau, R.drawable.fe_domba_hijau, R.drawable.fe_sapi_hijau};


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
        setContentView(R.layout.activity_focus_output);

        gambarQuiz_FE = findViewById(R.id.gambarQuiz_FE);
        jawabanQuizBenar = findViewById(R.id.jawabanQuizBenar);
        jawabanQuizSalah = findViewById(R.id.jawabanQuizSalah);
        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarQuiz_FE.setImageResource(GambarQuizContoh[currentIndex]);
            kirimJawaban = new String[GambarQuizContoh.length];
        } else if (SubMenu_Soal == 2) {
            gambarQuiz_FE.setImageResource(GambarQuizLatihan[currentIndex]);
            kirimJawaban = new String[GambarQuizLatihan.length];
        } else if (SubMenu_Soal == 3) {
            gambarQuiz_FE.setImageResource(GambarQuizSoal[currentIndex]);
            kirimJawaban = new String[GambarQuizSoal.length];
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
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
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
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Output.this, HasilNilaiActivity.class);
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
        gambarQuiz_FE.setImageResource(GambarQuizSoal[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageContoh() {
        currentIndex++;
        gambarQuiz_FE.setImageResource(GambarQuizContoh[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageLatihan() {
        currentIndex++;
        gambarQuiz_FE.setImageResource(GambarQuizLatihan[currentIndex]);
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }
}