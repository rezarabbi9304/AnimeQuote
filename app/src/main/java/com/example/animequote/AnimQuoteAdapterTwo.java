package com.example.animequote;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequote.db.AppDataBase;

import java.util.List;

public class AnimQuoteAdapterTwo extends RecyclerView.Adapter<AnimQuoteAdapterTwo.MyViewHolderTwo>{

    private Context Mcontext;
    private List<AnimModel> animModelListTwo;

    public AnimQuoteAdapterTwo(Context mcontext, List<AnimModel> animModelListTwo) {
        Mcontext = mcontext;
        this.animModelListTwo = animModelListTwo;
    }

    @NonNull
    @Override
    public MyViewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Mcontext).inflate(R.layout.anim_quote_two,parent,false);
        AnimQuoteAdapterTwo.MyViewHolderTwo holder = new AnimQuoteAdapterTwo.MyViewHolderTwo(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTwo holder, int position) {
        holder.animQuoteTwo.setText("" +animModelListTwo.get(position).getQuote());
        holder.textAnimNameTwo.setText("" + animModelListTwo.get(position).getAnime());


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mcontext,AnimeActivity3.class);
                intent.putExtra("quote",animModelListTwo.get(position).getQuote());
                Mcontext.startActivity(intent);
            }
        });


        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SaveData(animModelListTwo.get(position));
               /* SaveAnimData(animModelListTwo.get(position).getAnime().toString() ,animModelListTwo.get(position).getQuote().toString());*/


                Toast.makeText(Mcontext, "Add to Favorite", Toast.LENGTH_SHORT).show();
            }
        });


        holder.button_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mcontext, "copied", Toast.LENGTH_SHORT).show();

                ClipboardManager clipboardManager = (ClipboardManager) Mcontext.getSystemService(Mcontext.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text",animModelListTwo.get(position).getQuote());
                clipboardManager.setPrimaryClip(clipData);
            }
        });

        holder.button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent  = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Quote = animModelListTwo.get(position).getQuote();
                intent.putExtra(intent.EXTRA_TEXT,Quote);
                Mcontext.startActivity(Intent.createChooser(intent,"share with"));

            }
        });



    }

   /* public void SaveAnimData(String anim , String quote){
        AppDataBase db = AppDataBase.getINSTANCE(Mcontext.getApplicationContext());
        AnimModel animModel = new AnimModel(anim,"test",quote,1);
        db.animDao().insetAnim(animModel);

    }*/
    public void SaveData(AnimModel model){
        AppDataBase db = AppDataBase.getINSTANCE(Mcontext.getApplicationContext());
        db.animDao().insetAnim(model);

    }

    @Override
    public int getItemCount() {
        return animModelListTwo.size();
    }

    public static class MyViewHolderTwo extends RecyclerView.ViewHolder{

        private TextView animQuoteTwo;
        private TextView textAnimNameTwo;

        private Button button_copy;
        private Button button_share;
        private Button fav;

        private TextView parent;

        public MyViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            animQuoteTwo = itemView.findViewById(R.id.textanimQuoteTwo);
            textAnimNameTwo = itemView.findViewById(R.id.textAnimNameTwo);

            button_copy = itemView.findViewById(R.id.button_copy);
            button_share = itemView.findViewById(R.id.button_share);
            fav = itemView.findViewById(R.id.button3);

            parent = itemView.findViewById(R.id.textanimQuoteTwo);

        }
    }
}
