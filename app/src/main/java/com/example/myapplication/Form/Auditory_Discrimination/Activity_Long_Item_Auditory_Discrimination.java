package com.example.myapplication.Form.Auditory_Discrimination;

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

public class Activity_Long_Item_Auditory_Discrimination extends AppCompatActivity {

    private ImageButton gambar_sound1, gambar_sound2, JawabanCeklis, JawabanSilang;
    private TextView soal;
    private int currentIndex = 0;
    private Integer user_jawab_contoh, user_jawab_latihan, user_jawab_soal; // 1 untuk Silang 0 untuk Ceklis
    int nilai = 0;

    private String key = "KEY_NILAI";

    private Integer[] sound_soal_1 = {R.raw.adl_soal1_a, R.raw.adl_soal2, R.raw.adl_soal3_a, R.raw.adl_soal4, R.raw.adl_soal5, R.raw.adl_soal6_a, R.raw.adl_soal7, R.raw.adl_soal8, R.raw.adl_soal9_a, R.raw.adl_soal10, R.raw.adl_soal11, R.raw.adl_soal12_a, R.raw.adl_soal13, R.raw.adl_soal14, R.raw.adl_soal15_a, R.raw.adl_soal16_a};
    private Integer[] sound_soal_2 = {R.raw.adl_soal1_b, R.raw.adl_soal2, R.raw.adl_soal3_b, R.raw.adl_soal4, R.raw.adl_soal5, R.raw.adl_soal6_b, R.raw.adl_soal7, R.raw.adl_soal8, R.raw.adl_soal9_b, R.raw.adl_soal10, R.raw.adl_soal11, R.raw.adl_soal12_b, R.raw.adl_soal13, R.raw.adl_soal14, R.raw.adl_soal15_b, R.raw.adl_soal16_b};
    private Integer[] jawaban_soal = {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1};

    private Integer[] sound_contoh_1 = {R.raw.adl_contoh1_a};
    private Integer[] sound_contoh_2 = {R.raw.adl_contoh1_b};
    private Integer[] jawaban_contoh = {1};

    private Integer[] sound_latihan_1 = {R.raw.adl_latihan1_a};
    private Integer[] sound_latihan_2 = {R.raw.adl_latihan1_b};
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
        setContentView(R.layout.activity_long_item_auditory_discrimination);

        gambar_sound1 = findViewById(R.id.gambar_sound1);
        gambar_sound2 = findViewById(R.id.gambar_sound2);
        JawabanCeklis = findViewById(R.id.JawabanCeklis);
        JawabanSilang = findViewById(R.id.JawabanSilang);
        soal = findViewById(R.id.soal);


        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        if (SubMenu_Soal == 1) {
            user_jawab_contoh = jawaban_contoh[currentIndex];
            kirimJawaban = new String[jawaban_contoh.length];//ini

        } else if (SubMenu_Soal == 2) {
            user_jawab_latihan = jawaban_latihan[currentIndex];
            kirimJawaban = new String[jawaban_latihan.length];//ini

        } else if (SubMenu_Soal == 3) {
            user_jawab_soal = jawaban_soal[currentIndex];
            kirimJawaban = new String[jawaban_soal.length];//ini

        }

        gambar_sound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudioContoh1();
                } else if (SubMenu_Soal == 2) {
                    playAudioLatihan1();
                } else if (SubMenu_Soal == 3) {
                    playAudioSoal1();
                }
            }
        });

        gambar_sound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudioContoh2();
                } else if (SubMenu_Soal == 2) {
                    playAudioLatihan2();
                } else if (SubMenu_Soal == 3) {
                    playAudioSoal2();
                }
            }
        });

        JawabanSilang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab_contoh == 1) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoalContoh();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 1) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoalLatihan();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 1) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextSoalSoal();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }

            }
        });

        JawabanCeklis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    if (user_jawab_contoh == 0) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoalContoh();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 0) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoalLatihan();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 0) {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextSoalSoal();
                    } else {
                        Toast.makeText(Activity_Long_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Long_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }
            }
        });

    }

    public void nextSoalContoh() {
        currentIndex++;
        user_jawab_contoh = jawaban_contoh[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextSoalLatihan() {
        currentIndex++;
        user_jawab_latihan = jawaban_latihan[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextSoalSoal() {
        currentIndex++;
        user_jawab_soal = jawaban_soal[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    private void playAudioSoal1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_soal_1[currentIndex]);
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

    private void playAudioSoal2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_soal_2[currentIndex]);
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

    private void playAudioContoh1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_contoh_1[currentIndex]);
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

    private void playAudioContoh2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_contoh_2[currentIndex]);
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

    private void playAudioLatihan1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_latihan_1[currentIndex]);
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

    private void playAudioLatihan2() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_latihan_2[currentIndex]);
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