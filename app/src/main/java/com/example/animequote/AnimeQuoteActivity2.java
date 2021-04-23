package com.example.animequote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeQuoteActivity2 extends AppCompatActivity {

    private RecyclerView recyclerViewTwo;
    private List<AnimModel> animModelListTwo;
    private AnimApi animApi;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_quote2);

        recyclerViewTwo = findViewById(R.id.Recyclerview_activity_two);
        animModelListTwo = new ArrayList<>();

        if (getIntent().hasExtra("anime")){
            name = getIntent().getStringExtra("anime");
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/quotes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        animApi = retrofit.create(AnimApi.class);
       Call<List<AnimModel>> call = animApi.getTitle(name);

       call.enqueue(new Callback<List<AnimModel>>() {
           @Override
           public void onResponse(Call<List<AnimModel>> call, Response<List<AnimModel>> response) {

               animModelListTwo = response.body();
               putIntoAdaper(animModelListTwo);
           }

           @Override
           public void onFailure(Call<List<AnimModel>> call, Throwable t) {

           }
       });


    }

    private void putIntoAdaper(List<AnimModel> animModelListTwo) {

        AnimQuoteAdapterTwo adapterTwo = new AnimQuoteAdapterTwo(this,animModelListTwo);
        recyclerViewTwo.setAdapter(adapterTwo);
        recyclerViewTwo.setLayoutManager(new LinearLayoutManager(this));

    }
}