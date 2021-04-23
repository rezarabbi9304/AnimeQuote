package com.example.animequote;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AnimModel {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "anime_table")
    private String anime;

    @ColumnInfo(name = "character_table")
    private String character;

    @ColumnInfo(name = "quote_table")
    private String quote;

    public AnimModel(String anime, String character, String quote, int uid) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
