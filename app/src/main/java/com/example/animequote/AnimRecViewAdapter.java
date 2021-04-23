package com.example.animequote;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;




public class AnimRecViewAdapter extends RecyclerView.Adapter<AnimRecViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<AnimModel> animModelList;


    public AnimRecViewAdapter(Context mContext, List<AnimModel> animModelList) {
        this.mContext = mContext;
        this.animModelList = animModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.anim_first_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.animQuote.setText("" +animModelList.get(position).getQuote());
        holder.textAnimName.setText("" + animModelList.get(position).getAnime());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,animModelList.get(position).getAnime(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext,AnimeQuoteActivity2.class);
                intent.putExtra("anime", animModelList.get(position).getAnime());
                mContext.startActivity(intent);
            }
        });

        holder.button_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(mContext.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("start",animModelList.get(position).getQuote());
                clipboard.setPrimaryClip(clipData);

                Toast.makeText(mContext, "copied", Toast.LENGTH_SHORT).show();
               
            }
        });

        holder.button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "sharing", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Quote = animModelList.get(position).getQuote();
                intent.putExtra(intent.EXTRA_TEXT,Quote);
                mContext.startActivity(Intent.createChooser(intent,"share using"));


            }
        });

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Add to Favorite", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return animModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView animQuote;
        private TextView textAnimName;
        private TextView parent;
        private Button button_copy;
        private Button button_share;
        private Button fav;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            animQuote = itemView.findViewById(R.id.textanimQuote);
            textAnimName = itemView.findViewById(R.id.textAnimName);
            parent =  itemView.findViewById(R.id.textanimQuote);

            button_copy = itemView.findViewById(R.id.button_copy);
            button_share = itemView.findViewById(R.id.button_share);
            fav = itemView.findViewById(R.id.button3);


        }
    }
}
