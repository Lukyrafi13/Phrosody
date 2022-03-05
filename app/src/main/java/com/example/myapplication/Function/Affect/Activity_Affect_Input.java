package com.example.myapplication.Function.Affect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

import java.io.IOException;

public class Activity_Affect_Input extends AppCompatActivity {

    private ImageButton gambarObjek_ai, JawabanSenyum, JawabanSedih;

    private int currentIndex = 0;
    private int user_jawab; // 1 untuk senyum 0 untuk sedih
    int nilai = 0;
    private TextView soal;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";
    private String Nama;

    private Integer[] objek = {R.drawable.ai_pisang, R.drawable.ai_puding, R.drawable.ai_telur, R.drawable.ai_jeruk, R.drawable.ai_roti, R.drawable.ai_coklat, R.drawable.ai_apel, R.drawable.ai_kue, R.drawable.ai_madu, R.drawable.ai_kacang, R.drawable.ai_keripik, R.drawable.ai_susu, R.drawable.ai_permen, R.drawable.ai_wortel, R.drawable.ai_keju, R.drawable.ai_tomat};
    private Integer[] jawaban = {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1};
    private Integer[] sound = {R.raw.ai_suara1, R.raw.ai_suara2, R.raw.ai_suara3, R.raw.ai_suara4, R.raw.ai_suara5, R.raw.ai_suara6, R.raw.ai_suara7, R.raw.ai_suara8, R.raw.ai_suara9, R.raw.ai_suara10, R.raw.ai_suara11, R.raw.ai_suara12, R.raw.ai_suara13, R.raw.ai_suara14, R.raw.ai_suara15, R.raw.ai_suara16};

    private Integer[] objekContoh = {R.drawable.ai_keripik};
    private Integer[] jawabanContoh = {0};
    private Integer[] soundContoh = {R.raw.ai_suara11};

    private Integer[] objekLatihan = {R.drawable.ai_anggur};
    private Integer[] jawabanLatihan = {1};
    private Integer[] soundLatihan = {R.raw.ai_suara_latihan};


    private MediaPlayer mediaPlayer;

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
        setContentView(R.layout.activity_affect_input);

        gambarObjek_ai = findViewById(R.id.gambar_sound);
        JawabanSedih = findViewById(R.id.JawabanSedih);
        JawabanSenyum = findViewById(R.id.JawabanKiri);
        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            gambarObjek_ai.setImageResource(objekContoh[0]);
            user_jawab = jawabanContoh[currentIndex];
            kirimJawaban = new String[jawabanContoh.length];//ini

        } else if (SubMenu_Soal == 2) {
            gambarObjek_ai.setImageResource(objekLatihan[0]);
            user_jawab = jawabanLatihan[currentIndex];
            kirimJawaban = new String[jawabanLatihan.length];//ini

        } else if (SubMenu_Soal == 3) {
            gambarObjek_ai.setImageResource(objek[0]);
            user_jawab = jawaban[currentIndex];
            kirimJawaban = new String[jawaban.length];//ini

        }


        gambarObjek_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    playAudioSoalContoh();

                } else if (SubMenu_Soal == 2) {
                    playAudioSoalLatihan();

                } else if (SubMenu_Soal == 3) {
                    playAudioSoalSoal();

                }
            }
        });

        JawabanSenyum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }
                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }

            }
        });

        JawabanSedih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }
                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }
                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Affect_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Affect_Input.this, "Soal Selesai " + nilai, Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Affect_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
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
        gambarObjek_ai.setImageResource(objek[currentIndex]);
        user_jawab = jawaban[currentIndex];
    }

    public void nextImageContoh() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek_ai.setImageResource(objekContoh[currentIndex]);
        user_jawab = jawabanContoh[currentIndex];
    }

    public void nextImageLatihan() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        gambarObjek_ai.setImageResource(objekLatihan[currentIndex]);
        user_jawab = jawabanLatihan[currentIndex];
    }


    private void playAudioSoalSoal() {
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

    private void playAudioSoalContoh() {
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

    private void playAudioSoalLatihan() {
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