package com.example.animequote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeUiActivity extends AppCompatActivity {

    private TextView apicall;
    private TextView favcall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);

        apicall = findViewById(R.id.Apicall);
        favcall = findViewById(R.id.favcall);

        apicall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent(HomeUiActivity.this,MainActivity.class));

                Toast.makeText(HomeUiActivity.this, "Anim Api Called", Toast.LENGTH_SHORT).show();
            }
        });

        favcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeUiActivity.this,FavActivity2.class));
                Toast.makeText(HomeUiActivity.this, "Favorite called", Toast.LENGTH_SHORT).show();
            }
        });
    }
}