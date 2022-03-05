package com.example.myapplication.Function.Focus;

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

public class Activity_Focus_Input extends AppCompatActivity {

    private ImageButton gambar_sound, JawabanKiri, JawabanKanan;
    private int currentIndex = 0;
    private int user_jawab_soal, user_jawab_latihan, user_jawab_contoh; // 1 untuk Kiri 0 untuk Kanan
    int nilai = 0;
    private TextView soal;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";
    String Nama;

    private Integer[] soundsoal = {R.raw.f_soal1, R.raw.f_soal2, R.raw.f_soal3, R.raw.f_soal4, R.raw.f_soal5, R.raw.f_soal6, R.raw.f_soal7, R.raw.f_soal8, R.raw.f_soal9, R.raw.f_soal10, R.raw.f_soal11, R.raw.f_soal12, R.raw.f_soal13, R.raw.f_soal14, R.raw.f_soal15, R.raw.f_soal16};
    private Integer[] kiri = {R.drawable.baju_hitam, R.drawable.celana_biru, R.drawable.baju_merah, R.drawable.dasi_biru, R.drawable.baju_hijau, R.drawable.celana_hijau, R.drawable.baju_hijau, R.drawable.celana_biru, R.drawable.dasi_merah, R.drawable.dasi_hijau, R.drawable.celana_hijau, R.drawable.baju_merah, R.drawable.dasi_biru, R.drawable.celana_biru, R.drawable.dasi_merah, R.drawable.baju_hitam};
    private Integer[] kanan = {R.drawable.baju_merah, R.drawable.celana_hijau, R.drawable.baju_hitam, R.drawable.dasi_merah, R.drawable.baju_biru, R.drawable.celana_hitam, R.drawable.baju_hitam, R.drawable.celana_merah, R.drawable.dasi_biru, R.drawable.dasi_hitam, R.drawable.celana_biru, R.drawable.baju_hitam, R.drawable.dasi_hijau, R.drawable.celana_hijau, R.drawable.dasi_biru, R.drawable.baju_merah};
    private Integer[] jawaban_soal = {1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0};

    private Integer[] soundcontoh = {R.raw.f_contoh1};
    private Integer[] kiricontoh = {R.drawable.celana_biru};
    private Integer[] kanancontoh = {R.drawable.celana_hitam};
    private Integer[] jawaban_contoh = {0};

    private Integer[] soundlatihan = {R.raw.f_latihan1};
    private Integer[] kirilatihan = {R.drawable.baju_biru};
    private Integer[] kananlatihan = {R.drawable.baju_merah};
    private Integer[] jawaban_latihan = {1};

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
        setContentView(R.layout.activity_focus_input);

        gambar_sound = findViewById(R.id.gambar_sound);
        JawabanKiri = findViewById(R.id.JawabanKiri);
        JawabanKanan = findViewById(R.id.JawabanKanan);
        soal = findViewById(R.id.soal);

        user_jawab_soal = jawaban_soal[currentIndex];
        user_jawab_contoh = jawaban_contoh[currentIndex];
        user_jawab_latihan = jawaban_latihan[currentIndex];


        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            JawabanKanan.setImageResource(kanancontoh[0]);
            JawabanKiri.setImageResource(kiricontoh[0]);
            kirimJawaban = new String[jawaban_contoh.length];//ini

        } else if (SubMenu_Soal == 2) {
            JawabanKanan.setImageResource(kananlatihan[0]);
            JawabanKiri.setImageResource(kirilatihan[0]);
            kirimJawaban = new String[jawaban_latihan.length];//ini

        } else if (SubMenu_Soal == 3) {
            JawabanKanan.setImageResource(kanan[0]);
            JawabanKiri.setImageResource(kiri[0]);
            kirimJawaban = new String[jawaban_soal.length];//ini

        }


        gambar_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudioContoh();
                } else if (SubMenu_Soal == 2) {
                    playAudioLatihan();
                } else if (SubMenu_Soal == 3) {
                    playAudioSoal();
                }
            }
        });

        JawabanKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab_contoh == 0) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 0) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 0) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
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
                    if (user_jawab_contoh == 1) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageContoh();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 1) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextImageLatihan();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 1) {
                        Toast.makeText(Activity_Focus_Input.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextImageSoal();
                    } else {
                        Toast.makeText(Activity_Focus_Input.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Focus_Input.this, HasilNilaiActivity.class);
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
        user_jawab_soal = jawaban_soal[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageContoh() {
        currentIndex++;
        JawabanKiri.setImageResource(kiricontoh[currentIndex]);
        JawabanKanan.setImageResource(kanancontoh[currentIndex]);
        user_jawab_contoh = jawaban_contoh[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextImageLatihan() {
        currentIndex++;
        JawabanKiri.setImageResource(kirilatihan[currentIndex]);
        JawabanKanan.setImageResource(kananlatihan[currentIndex]);
        user_jawab_latihan = jawaban_latihan[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    private void playAudioSoal() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, soundsoal[currentIndex]);
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
        mediaPlayer = MediaPlayer.create(this, soundcontoh[currentIndex]);
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
        mediaPlayer = MediaPlayer.create(this, soundlatihan[currentIndex]);
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