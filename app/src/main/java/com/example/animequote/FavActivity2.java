package com.example.animequote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.lang.UCharacter;
import android.os.Bundle;

import com.example.animequote.db.AppDataBase;

import java.util.List;

public class FavActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav2);

        recyclerView = findViewById(R.id.FavRecyclerView);




        loadAnimQuote();
    }

    private void loadAnimQuote() {
        AppDataBase db = AppDataBase.getINSTANCE(this.getApplicationContext());
        List<AnimModel> model = db.animDao().getAllAnim();

       FavRecyclerAdapter adapter = new FavRecyclerAdapter(this);
       adapter.setModelList(model);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
       recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(adapter);




    }
}