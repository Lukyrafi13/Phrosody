package com.example.myapplication.Function.Affect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Function.TurnEnd.QuizTurnEndOutputActivity;
import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

public class Activity_Affect_Output extends AppCompatActivity {

    private ImageButton gambarObjek_ai, GambarEmot;
    private ImageView jawabanQuizBenar,jawabanQuizSalah;

    private int currentIndex = 0;
    int nilai = 0;
    private TextView soal;
    private String key = "KEY_NILAI";

    private Integer[] objek_Contoh = {R.drawable.ao_teh};
    private Integer[] objek_Contoh_Emot = {R.drawable.ai_senyum};
    private Integer[] objek_Latihan = {R.drawable.ai_susu};
    private Integer[] objek_Latihan_Emot = {R.drawable.ai_sedih};
    private Integer[] objek_Soal = {R.drawable.ai_pisang, R.drawable.ai_puding, R.drawable.ai_telur, R.drawable.ai_jeruk, R.drawable.ai_roti, R.drawable.ai_coklat, R.drawable.ai_apel, R.drawable.ai_kue, R.drawable.ai_madu, R.drawable.ai_kacang, R.drawable.ai_keripik, R.drawable.ai_susu, R.drawable.ai_permen, R.drawable.ai_wortel, R.drawable.ai_keju, R.drawable.ai_tomat};
    private Integer[] objek_Soal_Emot = {R.drawable.ai_senyum, R.drawable.ai_sedih, R.drawable.ai_sedih, R.drawable.ai_sedih, R.drawable.ai_senyum, R.drawable.ai_senyum, R.drawable.ai_sedih, R.drawable.ai_sedih, R.drawable.ai_senyum, R.drawable.ai_sedih, R.drawable.ai_sedih, R.drawable.ai_senyum, R.drawable.ai_senyum, R.drawable.ai_sedih, R.drawable.ai_senyum, R.drawable.ai_senyum};

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
        setContentView(R.layout.activity_affect_output);

        gambarObjek_ai = findViewById(R.id.gambar_sound);
        GambarEmot = findViewById(R.id.GambarEmot);
        soal = findViewById(R.id.soal);
        jawabanQuizBenar = findViewById(R.id.jawabanQuizBenar);
        jawabanQuizSalah = findViewById(R.id.jawabanQuizSalah);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarObjek_ai.setImageResource(objek_Contoh[0]);
            GambarEmot.setImageResource(objek_Contoh_Emot[0]);
            kirimJawaban = new String[objek_Contoh.length];
        } else if (SubMenu_Soal == 2) {
            gambarObjek_ai.setImageResource(objek_Latihan[0]);
            GambarEmot.setImageResource(objek_Latihan_Emot[0]);
            kirimJawaban = new String[objek_Latihan.length];
        } else if (SubMenu_Soal == 3) {
            gambarObjek_ai.setImageResource(objek_Soal[0]);
            GambarEmot.setImageResource(objek_Soal_Emot[0]);
            kirimJawaban = new String[objek_Soal.length];
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
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
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
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Output.this, HasilNilaiActivity.class);
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
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek_ai.setImageResource(objek_Soal[currentIndex]);
        GambarEmot.setImageResource(objek_Soal_Emot[currentIndex]);
    }

    public void nextImageContoh() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek_ai.setImageResource(objek_Contoh[currentIndex]);
    }

    public void nextImageLatihan() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek_ai.setImageResource(objek_Latihan[currentIndex]);
    }
}