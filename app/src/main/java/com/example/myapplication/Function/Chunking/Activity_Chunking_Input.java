package com.example.myapplication.Function.Chunking;

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

public class Activity_Chunking_Input extends AppCompatActivity {

    private ImageButton gambar_sound, JawabanKiri, JawabanKanan;
    private int currentIndex = 0;
    private int user_jawab; // 1 untuk Kanan 0 untuk Kiri
    int nilai = 0;
    private TextView soal;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";
    String Nama;

    private Integer[] sound = {R.raw.p_soal1, R.raw.p_soal2, R.raw.p_soal3, R.raw.p_soal4, R.raw.p_soal5, R.raw.p_soal6, R.raw.p_soal7, R.raw.p_soal8, R.raw.p_soal9, R.raw.p_soal10, R.raw.p_soal11, R.raw.p_soal12, R.raw.p_soal13, R.raw.p_soal14, R.raw.p_soal15, R.raw.p_soal16};
    private Integer[] kiri = {R.drawable.ci_soal1_a, R.drawable.ci_soal2_a, R.drawable.ci_soal3_a, R.drawable.ci_soal4_a, R.drawable.ci_soal5_a, R.drawable.ci_soal6_a, R.drawable.ci_soal7_a, R.drawable.ci_soal8_a, R.drawable.ci_soal9_a, R.drawable.ci_soal10_a, R.drawable.ci_soal11_a, R.drawable.ci_soal12_a, R.drawable.ci_soal13_a, R.drawable.ci_soal14_a, R.drawable.ci_soal15_a, R.drawable.ci_soal16_a};
    private Integer[] kanan = {R.drawable.ci_soal1_b, R.drawable.ci_soal2_b, R.drawable.ci_soal3_b, R.drawable.ci_soal4_b, R.drawable.ci_soal5_b, R.drawable.ci_soal6_b, R.drawable.ci_soal7_b, R.drawable.ci_soal8_b, R.drawable.ci_soal9_b, R.drawable.ci_soal10_b, R.drawable.ci_soal11_b, R.drawable.ci_soal12_b, R.drawable.ci_soal13_b, R.drawable.ci_soal14_b, R.drawable.ci_soal15_b, R.drawable.ci_soal16_b};
    private Integer[] jawaban = {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1};

    private Integer[] soundContoh = {R.raw.p_soal10};
    private Integer[] kiriContoh = {R.drawable.ci_soal10_a};
    private Integer[] kananContoh = {R.drawable.ci_soal10_b};
    private Integer[] jawabanContoh = {0};

    private Integer[] soundLatihan = {R.raw.p_soal5};
    private Integer[] kiriLatihan = {R.drawable.ci_soal5_a};
    private Integer[] kananLatihan = {R.drawable.ci_soal5_b};
    private Integer[] jawabanLatihan = {0};

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
        setContentView(R.layout.activity_chunking_input);

        gambar_sound = findViewById(R.id.gambar_sound);
        JawabanKiri = findViewById(R.id.JawabanKiri);
        JawabanKanan = findViewById(R.id.JawabanKanan);
        soal = findViewById(R.id.soal);


        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        //Nama Pengisi Quiz
        Nama = (getIntent().getStringExtra(key_nama));

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            JawabanKanan.setImageResource(kananContoh[0]);
            JawabanKiri.setImageResource(kiriContoh[0]);
            user_jawab = jawabanContoh[currentIndex];
            kirimJawaban = new String[jawabanContoh.length];//ini

        } else if (SubMenu_Soal == 2) {
            JawabanKanan.setImageResource(kananLatihan[0]);
            JawabanKiri.setImageResource(kiriLatihan[0]);
            user_jawab = jawabanLatihan[currentIndex];
            kirimJawaban = new String[jawabanLatihan.length];//ini

        } else if (SubMenu_Soal == 3) {
            JawabanKanan.setImageResource(kanan[0]);
            JawabanKiri.setImageResource(kiri[0]);
            user_jawab = jawaban[currentIndex];
            kirimJawaban = new String[jawaban.length];//ini

        }

        gambar_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudioContoh();

                } else if (SubMenu_Soal == 2) {
                    playAudioLatihan();

                } else if (SubMenu_Soal == 3) {
                    playAudioSoalSoal();

                }
            }
        });

        JawabanKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 1) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }

            }
        });

        JawabanKiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab == 0) {
                        Toast.makeText(Activity_Chunking_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Chunking_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Chunking_Input.this, HasilNilaiActivity.class);
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
        JawabanKiri.setImageResource(kiri[currentIndex]);
        JawabanKanan.setImageResource(kanan[currentIndex]);
        user_jawab = jawaban[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageContoh() {
        currentIndex++;
        JawabanKiri.setImageResource(kiriContoh[currentIndex]);
        JawabanKanan.setImageResource(kananContoh[currentIndex]);
        user_jawab = jawabanContoh[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageLatihan() {
        currentIndex++;
        JawabanKiri.setImageResource(kiriContoh[currentIndex]);
        JawabanKanan.setImageResource(kananContoh[currentIndex]);
        user_jawab = jawabanContoh[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
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