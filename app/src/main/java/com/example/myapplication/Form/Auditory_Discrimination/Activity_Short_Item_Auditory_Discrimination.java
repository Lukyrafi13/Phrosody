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

public class Activity_Short_Item_Auditory_Discrimination extends AppCompatActivity {

    private ImageButton gambar_sound1, gambar_sound2, Jawaban2lingkaran, Jawabanlingkarankotak;
    private TextView soal;
    private int currentIndex = 0;
    private int user_jawab_soal, user_jawab_contoh, user_jawab_latihan; // 1 untuk Sama 0 untuk Beda
    int nilai = 0;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";
    String Nama;

    private Integer[] sound_soal_1 = {R.raw.ad_soal1_a, R.raw.ad_soal2_a, R.raw.ad_soal3_a, R.raw.ad_soal4, R.raw.ad_soal5_a, R.raw.ad_soal6, R.raw.ad_soal7, R.raw.ad_soal8_a, R.raw.ad_soal9, R.raw.ad_soal10, R.raw.ad_soal11_a, R.raw.ad_soal12, R.raw.ad_soal13_a, R.raw.ad_soal14, R.raw.ad_soal15, R.raw.ad_soal16_a};
    private Integer[] sound_soal_2 = {R.raw.ad_soal1_b, R.raw.ad_soal2_b, R.raw.ad_soal3_b, R.raw.ad_soal4, R.raw.ad_soal5_b, R.raw.ad_soal6, R.raw.ad_soal7, R.raw.ad_soal8_b, R.raw.ad_soal9, R.raw.ad_soal10, R.raw.ad_soal11_b, R.raw.ad_soal12, R.raw.ad_soal13_b, R.raw.ad_soal14, R.raw.ad_soal15, R.raw.ad_soal16_b};
    private Integer[] jawaban_soal = {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0};

    private Integer[] sound_contoh_1 = {R.raw.ad_soalcontoh1};
    private Integer[] sound_contoh_2 = {R.raw.ad_soalcontoh1};
    private Integer[] jawaban_contoh = {1};

    private Integer[] sound_latihan_1 = {R.raw.ad_soallatihan1};
    private Integer[] sound_latihan_2 = {R.raw.ad_soallatihan1};
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
        setContentView(R.layout.activity_short_item_auditory_discrimination);

        gambar_sound1 = findViewById(R.id.gambar_sound1);
        gambar_sound2 = findViewById(R.id.gambar_sound2);
        Jawaban2lingkaran = findViewById(R.id.Jawaban2lingkaran);
        Jawabanlingkarankotak = findViewById(R.id.Jawabanlingkarankotak);
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
                    playAudio1_Contoh();
                } else if (SubMenu_Soal == 2) {
                    playAudio1_Latihan();
                } else if (SubMenu_Soal == 3) {
                    playAudio1_Soal();
                }
            }
        });

        gambar_sound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudio2_Contoh();
                } else if (SubMenu_Soal == 2) {
                    playAudio2_Latihan();
                } else if (SubMenu_Soal == 3) {
                    playAudio2_Soal();
                }
            }
        });


        Jawaban2lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab_contoh == 1) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoal_Contoh();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 1) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoal_Latihan();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 1) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 0) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextSoal_Soal();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }

            }
        });

        Jawabanlingkarankotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SubMenu_Soal == 1) {
                    if (user_jawab_contoh == 0) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_contoh == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoal_Contoh();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (user_jawab_latihan == 0) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_latihan == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 0) {
                        nextSoal_Latihan();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (user_jawab_soal == 0) {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                        nilai++;
                        kirimJawaban[currentIndex] = "benar";
                    } else if (user_jawab_soal == 1) {
                        kirimJawaban[currentIndex] = "salah";//ini
                    }

                    if (currentIndex < 15) {
                        nextSoal_Soal();
                    } else {
                        Toast.makeText(Activity_Short_Item_Auditory_Discrimination.this, "Selesai", Toast.LENGTH_SHORT).show();
                        String kirimnilai = String.valueOf(nilai);
                        Intent intent = new Intent(Activity_Short_Item_Auditory_Discrimination.this, HasilNilaiActivity.class);
                        intent.putExtra(key, kirimnilai);
                        intent.putExtra(key_nama, Nama);
                        intent.putExtra("jawaban", kirimJawaban);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    public void nextSoal_Soal() {
        currentIndex++;
        user_jawab_soal = jawaban_soal[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextSoal_Contoh() {
        currentIndex++;
        user_jawab_contoh = jawaban_contoh[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    public void nextSoal_Latihan() {
        currentIndex++;
        user_jawab_latihan = jawaban_latihan[currentIndex];
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
    }

    private void playAudio1_Soal() {
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

    private void playAudio1_Contoh() {
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

    private void playAudio1_Latihan() {
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

    private void playAudio2_Soal() {
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

    private void playAudio2_Contoh() {
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

    private void playAudio2_Latihan() {
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