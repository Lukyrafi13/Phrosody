package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fungsi();

    }

    //ini untuk pindah screen
    private void fungsi() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000); // set Waktu Pending selama 2 detik
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    startActivity(new Intent(MainActivity.this, menuutama.class));
                    finish(); // Menutup Activity
                }
            }
        };
        thread.start();
    }
}