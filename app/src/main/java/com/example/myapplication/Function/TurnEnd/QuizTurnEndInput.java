package com.example.myapplication.Function.TurnEnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizTurnEndInput extends AppCompatActivity {

    private ImageButton gambarObjek, JawabanDeklaratif, JawabanTanya;
    private int currentIndex = 0;
    private int user_jawab; // 1 untuk tanya 0 untuk deklaratif
    int nilai = 0;
    private TextView soal;

    private String key = "KEY_NILAI";

    private Integer[] objek = {R.drawable.o_keju, R.drawable.o_apel, R.drawable.o_jeruk, R.drawable.o_kue, R.drawable.o_madu, R.drawable.o_coklat, R.drawable.o_pisang, R.drawable.o_anggur, R.drawable.o_jagung, R.drawable.o_permen, R.drawable.o_air, R.drawable.o_keripik, R.drawable.o_telur, R.drawable.o_puding, R.drawable.o_susu, R.drawable.o_kacang};
    private Integer[] tanya = {R.drawable.t_keju, R.drawable.t_apel, R.drawable.t_jeruk, R.drawable.t_kue, R.drawable.t_madu, R.drawable.t_coklat, R.drawable.t_pisang, R.drawable.t_anggur, R.drawable.t_jagung, R.drawable.t_permen, R.drawable.t_air, R.drawable.t_keripik, R.drawable.t_telur, R.drawable.t_puding, R.drawable.t_susu, R.drawable.t_kacang};
    private Integer[] deklaratif = {R.drawable.d_keju, R.drawable.d_apel, R.drawable.d_jeruk, R.drawable.d_kue, R.drawable.d_madu, R.drawable.d_coklat, R.drawable.d_pisang, R.drawable.d_anggur, R.drawable.d_jagung, R.drawable.d_permen, R.drawable.d_air, R.drawable.d_keripik, R.drawable.d_telur, R.drawable.d_puding, R.drawable.d_susu, R.drawable.d_kacang};
    private Integer[] jawaban = {0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0};
    private Integer[] sound = {R.raw.te_keju, R.raw.te_apel, R.raw.te_jeruk, R.raw.te_kue, R.raw.te_madu, R.raw.te_coklat, R.raw.te_pisang, R.raw.te_anggur, R.raw.te_jagung, R.raw.te_permen, R.raw.te_air, R.raw.te_keripik, R.raw.te_telur, R.raw.te_puding, R.raw.te_susu, R.raw.te_kacang};

    private Integer[] objekContoh = {R.drawable.o_teh};
    private Integer[] tanyaContoh = {R.drawable.t_teh};
    private Integer[] deklaratifContoh = {R.drawable.d_teh};
    private Integer[] jawabanContoh = {0};
    private Integer[] soundContoh = {R.raw.te_teh};

    private Integer[] objekLatihan = {R.drawable.o_roti};
    private Integer[] tanyaLatihan = {R.drawable.t_roti};
    private Integer[] deklaratifLatihan = {R.drawable.d_roti};
    private Integer[] jawabanLatihan = {1};
    private Integer[] soundLatihan = {R.raw.si_roti_tanya};

    String[] kirimJawaban;//ini

    private MediaPlayer mediaPlayer;

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
        setContentView(R.layout.activity_turn_end);

        gambarObjek = findViewById(R.id.gambar_sound);
        JawabanDeklaratif = findViewById(R.id.JawabanDeklaratif);
        JawabanTanya = findViewById(R.id.JawabanTanya);

        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarObjek.setImageResource(objekContoh[0]);
            JawabanTanya.setImageResource(tanyaContoh[0]);
            JawabanDeklaratif.setImageResource(deklaratifContoh[0]);
            user_jawab = jawabanContoh[currentIndex];
            kirimJawaban = new String[jawabanContoh.length];//ini
        } else if (SubMenu_Soal == 2) {
            gambarObjek.setImageResource(objekLatihan[0]);
            JawabanTanya.setImageResource(tanyaLatihan[0]);
            JawabanDeklaratif.setImageResource(deklaratifLatihan[0]);
            user_jawab = jawabanLatihan[currentIndex];
            kirimJawaban = new String[jawabanLatihan.length];//ini
        } else if (SubMenu_Soal == 3) {
            gambarObjek.setImageResource(objek[0]);
            JawabanTanya.setImageResource(tanya[0]);
            JawabanDeklaratif.setImageResource(deklaratif[0]);
            user_jawab = jawaban[currentIndex];
            kirimJawaban = new String[jawaban.length];//ini
        }


        gambarObjek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SubMenu_Soal == 1) {
                    playAudioContoh();
                } else if (SubMenu_Soal == 2) {
                    playAudioLatihan();
                } else if (SubMenu_Soal == 3) {
                    playAudioSoal();
                }

            }
        });

        JawabanDeklaratif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "benar";//ini
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();

                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "benar";
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();

                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "benar";
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }


            }
        });


        JawabanTanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "benar";
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "benar";
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "benar";
                        Toast.makeText(QuizTurnEndInput.this, "Jawaban benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                    }

                    if (currentIndex < 15) {

                        nextImageSoal();
                    } else {
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
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
        gambarObjek.setImageResource(objek[currentIndex]);
        JawabanTanya.setImageResource(tanya[currentIndex]);
        JawabanDeklaratif.setImageResource(deklaratif[currentIndex]);
        user_jawab = jawaban[currentIndex];
    }

    public void nextImageContoh() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek.setImageResource(objekContoh[currentIndex]);
        JawabanTanya.setImageResource(tanyaContoh[currentIndex]);
        JawabanDeklaratif.setImageResource(deklaratifContoh[currentIndex]);
        user_jawab = jawabanContoh[currentIndex];
    }

    public void nextImageLatihan() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek.setImageResource(objekLatihan[currentIndex]);
        JawabanTanya.setImageResource(tanyaLatihan[currentIndex]);
        JawabanDeklaratif.setImageResource(deklaratifLatihan[currentIndex]);
        user_jawab = jawabanLatihan[currentIndex];
    }

    private void playAudioSoal() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound[currentIndex]);
        //Menjalankan Audio / Musik
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();
    }

    private void playAudioContoh() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, soundContoh[currentIndex]);
        //Menjalankan Audio / Musik
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();
    }

    private void playAudioLatihan() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, soundLatihan[currentIndex]);
        //Menjalankan Audio / Musik
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();
    }
}