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

public class ShortItemImitationActivity extends AppCompatActivity {

    private Integer[] sound_contoh = {R.raw.si_teh_tanya};
    private Integer[] sound_latihan = {R.raw.si_madu};
    private Integer[] sound_soal = {R.raw.si_susu, R.raw.si_permen_tanya, R.raw.si_wortel, R.raw.si_keripik_datar, R.raw.si_pisang_tanya, R.raw.si_coklat_suka, R.raw.si_tomat_suka, R.raw.si_teh, R.raw.si_roti_tanya, R.raw.si_puding_datar, R.raw.si_keju, R.raw.si_jeruk_tanya, R.raw.si_apel_datar, R.raw.si_madu_suka, R.raw.si_air_suka, R.raw.si_kacang_datar};

    private ImageButton ImBtnGambar;
    private Button btnNext;
    private TextView soal;

    private int currentIndex = 0;

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
        setContentView(R.layout.activity_short_item_imitation);

        ImBtnGambar = findViewById(R.id.ImBtnGambar);
        btnNext = findViewById(R.id.btnNext_FE);

        soal = findViewById(R.id.soal);

        Integer nomor_soal = currentIndex + 1;
        String tampilSoal = "Soal " + nomor_soal.toString();
        soal.setText(tampilSoal);

        terima_SubMenu_Soal = getIntent().getStringExtra(key_SubMenu_Soal);
        Integer SubMenu_Soal = Integer.parseInt(terima_SubMenu_Soal);

        ImBtnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        Toast.makeText(ShortItemImitationActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 2) {
                    if (currentIndex < 1) {
                        nextSoal();
                    } else {
                        Toast.makeText(ShortItemImitationActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);
                    }

                } else if (SubMenu_Soal == 3) {
                    if (currentIndex < 15) {
                        nextSoal();
                    } else {
                        Toast.makeText(ShortItemImitationActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
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