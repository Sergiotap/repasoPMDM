package com.example.apirickymorty.API.MapearAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoPage {
    //Página anterior
    @SerializedName("prev")
    @Expose
    private String prev;
    //Página siguiente
    @SerializedName("next")
    @Expose
    private String next;
    //Página actual
    @SerializedName("pagina")
    @Expose
    private int pagina;
    //posición del personaje
    @SerializedName("posicion")
    @Expose
    private int count;
    //Getters

    public int getCount() {
        return count;
    }

    public int getPagina() {
        return pagina;
    }

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }
}
