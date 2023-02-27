package com.example.apirickymorty.API.MapearAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin {
    //Obtiene la url de los personajes origen en este planeta
    @SerializedName("url")
    @Expose
    private String urlOrigen;
    //Obtiene el nombre del planeta origen
    @SerializedName("name")
    @Expose
    private String nameOrigen;
    //Getters

    public String getUrlOrigen() {
        return urlOrigen;
    }

    public String getNameOrigen() {
        return nameOrigen;
    }
}
