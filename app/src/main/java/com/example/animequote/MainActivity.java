package com.example.animequote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.animequote.db.AppDataBase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<AnimModel> animModelList;
    private AnimApi animApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppDataBase db = AppDataBase.getINSTANCE(this);
        AnimModel animModel = new AnimModel("naruto","test","abcd",1);

        Long x = db.animDao().insetAnim(animModel);

        Log.d("Getting List", "onCreate: " +  db.animDao().getAllAnim().get(0).getQuote());

        recyclerView = findViewById(R.id.Recyclerview_launcher);
        animModelList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        animApi = retrofit.create(AnimApi.class);
        Call<List<AnimModel>> call = animApi.getanimModel();

        call.enqueue(new Callback<List<AnimModel>>() {
            @Override
            public void onResponse(Call<List<AnimModel>> call, Response<List<AnimModel>> response) {

                List<AnimModel> animModels = response.body();
                for (AnimModel anim:animModels
                     ) {
                    animModelList.add(anim);

                }

                putDataIntoAdapter(animModelList);


            }



            @Override
            public void onFailure(Call<List<AnimModel>> call, Throwable t) {

            }
        });





    }

    private void putDataIntoAdapter(List<AnimModel> animModelList) {

        AnimRecViewAdapter adapter = new AnimRecViewAdapter(this,animModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}