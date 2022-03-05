package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Tentang_Aplikasi_Activity extends AppCompatActivity {

    TextView tvTentangAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_aplikasi);

        tvTentangAplikasi = findViewById(R.id.tvTentangAplikasi);
        String Formattedtext = "<i>PEPS-C (Profiling Elements of Prosody in Speech Communication)</i> versi Indonesia merupakan tes yang diadaptasi dari <i>PEPS-C 2015</i> oleh Sue Peppe untuk mengukur kemampuan prosodi reseptif dan ekspresif pada populasi dewasa dan anak-anak pada dua level yang berbeda yaitu, formal dan fungsional. Pada versi Indonesia tes ini dibuat berbasis aplikasi  dengan tujuan penelitian skripsi oleh Fani Hanifah.<br></br><br></br>\n" +
                "\n" +
                "    <b>Apa itu Prosodi?</b><br></br><br></br>\n" +
                "\n" +
                "    Prosodi merupakan variasi nada, intensitas, jeda, penekanan dan ritme bicara. Prosodi memegang peranan penting dalam menyampai makna bahasa. Dimana <i>‘chunking’</i> dan <i>‘intonation’</i> berpengaruh terhadap makna bahasa lisan, dimana kata-kata dalam suatu ujaran dikelompokan. <i>‘Stress’</i> menunjukan fokus dari pembicara dalam suatu percakapan.<i>‘Intonation’</i> dan <i>‘tone’</i> menunjukan sikap dan emosi pembicara terhadap apa yang mereka katakan.<br></br><br></br>\n" +
                "\n" +
                "    Gangguan prosodi sering kali ditemukan pada populasi dengan <i>Autism Spectrum Disorder, disartria, down syndrome, William syndrome, Parkinson disease dan hearing impairment.</i><br></br><br></br><br></br>\n" +
                "        <b>Aplikasi : </b>                    <br></br>PEPS-C versi Indonesia <br></br><br></br>\n" +
                "        <b>Adaptasi , desain gambar : </b>    <br></br>Fani Hanifah<br></br>(ig: @hnffanii)<br></br>(Email: fanihnf.tw13@gmail.com)<br></br><br></br>\n" +
                "        <b>Aplikasi desain : </b>             <br></br>Luky Rafi Anuggilarso<br></br>(ig: @luckyrafi13)<br></br>(Email: luckyrafi13@gmail.com)<br></br><br></br>\n" +
                "        <b>Tahun : </b>                       <br></br>2021<br></br><br></br>\n";
        tvTentangAplikasi.setText(Html.fromHtml(Formattedtext));
    }
}