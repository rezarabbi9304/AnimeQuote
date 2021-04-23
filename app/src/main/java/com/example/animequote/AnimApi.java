package com.example.animequote;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnimApi {

    @GET("quotes")
    Call<List<AnimModel>>getanimModel();

   // https://animechan.vercel.app/api/quotes/anime?title=Bleach
    //@GET("group/{id}/users")
   //Call<List<User>> groupList(@Path("id") int groupId);
    @GET("anime")
    Call<List<AnimModel>>getTitle(@Query("title") String title);
}
