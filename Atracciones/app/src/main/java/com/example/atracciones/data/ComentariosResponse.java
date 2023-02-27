package com.example.atracciones.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComentariosResponse {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("texto")
    @Expose
    private String texto;
    @SerializedName("atraccion")
    @Expose
    private String atraccion;

    public String getUrl() {
        return url;
    }

    public String getAtraccion() {
        return atraccion;
    }

    public String getTexto() {
        return texto;
    }
}
