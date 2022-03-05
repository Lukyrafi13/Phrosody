package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Review_Soal extends ArrayAdapter {

    private String[] jawaban;
    private Context context;

    Adapter_Review_Soal(@NonNull Context context, String[] jawaban) {
        super(context, R.layout.item_list_review_soal, jawaban);
        this.jawaban = jawaban;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_list_review_soal, null, true);

        TextView tvjawaban_review = view.findViewById(R.id.tvjawaban_review);
        TextView tvnojawaban_review = view.findViewById(R.id.tvnojawaban_review);


        tvnojawaban_review.setText(String.valueOf(position + 1));
        tvjawaban_review.setText(jawaban[position]);
        return view;
    }
}
