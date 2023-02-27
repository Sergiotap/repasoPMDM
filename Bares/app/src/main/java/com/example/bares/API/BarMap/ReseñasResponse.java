package com.example.bares.API.BarMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReseñasResponse {
    //Se define la url del bar
    @SerializedName("url")
    @Expose
    private String url;
    //Se define el nombre del bar
    @SerializedName("nombre")
    @Expose
    private String nombre;
    //Se define la descripción del bar
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    //Se define la fecha de cierre del bar
    @SerializedName("cierre")
    @Expose
    private String cierre;
    //Se define la fecha de apertura del bar
    @SerializedName("apertura")
    @Expose
    private String apertura;
    //Se define el número de estrellas del bar
    @SerializedName("estrellas")
    @Expose
    private  int estrellas;
    //Se definen los getter
    public String getApertura() {
        return apertura;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public String getCierre() {
        return cierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }
}
