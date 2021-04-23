package com.example.animequote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnimeActivity3 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private String quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime3);

        if(getIntent().hasExtra("quote")){

            quote = getIntent().getStringExtra("quote");
        }


        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        String url2 = "https://images.unsplash.com/photo-1542144612-1b3641ec3459?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=334&q=80";
        String url = "https://images.unsplash.com/photo-1618105965240-9aa565e73a0a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";

        Glide.with(this)
                .load(url2)
                .into(imageView);

        textView.setText(quote);




    }
}