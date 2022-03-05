package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HasilNilaiActivity extends AppCompatActivity {

    private TextView txtnilai, txtNama, watermark;
    private ListView listData;

    private String key = "KEY_NILAI";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_nilai);

        txtnilai = findViewById(R.id.Nilai);
        txtNama = findViewById(R.id.nama);
        watermark = findViewById(R.id.watermark);
        listData = findViewById(R.id.listData);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        txtNama.setText(sharedPreferences.getString("nama", null));

        txtnilai.setText(getIntent().getStringExtra(key));

        String[] array = getIntent().getExtras().getStringArray("jawaban");

        Adapter_Review_Soal adapter_review_soal = new Adapter_Review_Soal(this, array);
        listData.setAdapter(adapter_review_soal);
        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HasilNilaiActivity.this, "Ini nomer" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }


}