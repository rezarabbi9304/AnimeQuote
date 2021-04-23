package com.example.animequote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavRecyclerAdapter extends RecyclerView.Adapter<FavRecyclerAdapter.FavViewHolder> {

    private Context mContext;
    private List<AnimModel> modelList;

    public FavRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setModelList(List<AnimModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fav_layout_anim,null);
        FavViewHolder holder = new FavViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.favAnimName.setText("" + modelList.get(position).getAnime());
        holder.favAnimQuote.setText("" + modelList.get(position).getQuote());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class FavViewHolder extends RecyclerView.ViewHolder{

        private TextView favAnimName;
        private TextView favAnimQuote;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);

            favAnimName = itemView.findViewById(R.id.textFavName);
            favAnimQuote = itemView.findViewById(R.id.textFavQuote);
        }
    }
}
