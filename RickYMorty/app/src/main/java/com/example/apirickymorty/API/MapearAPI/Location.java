package com.example.apirickymorty.API.MapearAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    //Obtiene la url de aquellos que comparten página
    @SerializedName("url")
    @Expose
    private String urlLocation;
    //Obtiene el nombre en que nos encontramos
    @SerializedName("name")
    @Expose
    private String nameLocation;
    //Getters
    public String getNameLocation() {
        return nameLocation;
    }

    public String getUrlLocation() {
        return urlLocation;
    }
}
