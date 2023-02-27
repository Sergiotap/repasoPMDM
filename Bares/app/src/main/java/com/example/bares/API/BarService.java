package com.example.bares.API;

import com.example.bares.API.BarMap.ReseñasResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarService {
    @GET("pmdm/api/bares/")
    Call<List<ReseñasResponse>> getBares();
    @GET("pmdm/api/bares/")
    Call<List<ReseñasResponse>> filtrarBares(
            @Query("estrellas") int estrellas
    );
}
