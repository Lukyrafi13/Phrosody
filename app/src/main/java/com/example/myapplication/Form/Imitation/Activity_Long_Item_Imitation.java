package com.example.myapplication.Form.Imitation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.IOException;

public class Activity_Long_Item_Imitation extends AppCompatActivity {

    private Integer[] sound_contoh = {R.raw.li_contoh1, R.raw.li_contoh2};
    private Integer[] sound_latihan = {R.raw.li_latihan1, R.raw.li_latihan2};
    private Integer[] sound_soal = {R.raw.li_soal1, R.raw.li_soal2, R.raw.li_soal3, R.raw.li_soal4, R.raw.li_soal5, R.raw.li_soal6, R.raw.li_soal7, R.raw.li_soal8, R.raw.li_soal9, R.raw.li_soal10, R.raw.li_soal11, R.raw.li_soal12, R.raw.li_soal13, R.raw.li_soal14, R.raw.li_soal15, R.raw.li_soal16};

    private ImageButton ImBtnGambarSound;
    private Button btnNext;
    private TextView soal;

    private int currentIndex = 0;

    private MediaPlayer mediaPlayer;

    private String key_SubMenu_Soal = "SUBMENU_SOAL";
    private String terima_SubMenu_Soal;
    private String key_imitation = "IMITATION";
    private String terima_Imitation;

    /*
    Sub Menu Soal :
    Sub_Menu_Soal == 1 --> Contoh
    Sub_Menu_Soal == 2 --> Latihan
    Sub_Menu_Soal == 3 --> Soal
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_item_imitation);

        ImBtnGambarSound = findViewById(R.id.ImBtnGambarSound);
        btnNext = findViewById(R.id.btnNext_FE);

        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        terima_Imitation = getIntent().getStringExtra(key_imitation);


        ImBtnGambarSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SubMenu_Soal == 1) {
                    playAudio_Contoh();
                } else if (SubMenu_Soal == 2) {
                    playAudio_Latihan();
                } else if (SubMenu_Soal == 3) {
                    playAudio_Soal();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SubMenu_Soal == 1) {
                    if (currentIndex < 1) {
                        nextSoal();
                    } else {
                        Toast.makeText(Activity_Long_Item_Imitation.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 1) {
                        nextSoal();
                    } else {
                        Toast.makeText(Activity_Long_Item_Imitation.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextSoal();
                    } else {
                        Toast.makeText(Activity_Long_Item_Imitation.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                }
            }
        });

    }

    public void nextSoal() {
        currentIndex++;
        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);
        ;
    }

    private void playAudio_Soal() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_soal[currentIndex]);
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

    private void playAudio_Contoh() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_contoh[currentIndex]);
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

    private void playAudio_Latihan() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound_latihan[currentIndex]);
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