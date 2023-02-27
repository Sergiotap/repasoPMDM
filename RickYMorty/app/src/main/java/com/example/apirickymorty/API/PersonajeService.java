package com.example.apirickymorty.API;

import com.example.apirickymorty.API.MapearAPI.PaginaRespuesta;
import com.example.apirickymorty.API.MapearAPI.PersonajesRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PersonajeService {
    //Get que manda y recibe un personaje filtrado por id
    @GET("/api/character/{id}")
    Call<PersonajesRespuesta> buscarPersonaje(
            @Path("id") String id
    );
    //Get que devuelve 20 personajes, se filtra mediante page
    @GET("/api/character")
    Call<PaginaRespuesta> buscarPagina(
            @Query("page") String page
    );
    //Se podría utilizar un replace y usar solo buscarPagina pero esto se hace para estudiar
    @GET
    Call<PaginaRespuesta> siguientePagina(@Url String urlSiguiente);
    @GET
    Call<PaginaRespuesta> volverPagina(@Url String urlVolver);
}
