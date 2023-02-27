package com.example.apirickymorty.API.MapearAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginaRespuesta {
    //Devuelve información de las páginas
    @SerializedName("info")
    @Expose
    InfoPage infoPage;
    //Devuelve los personajes de la pagina actual
    @SerializedName("results")
    @Expose
    List<PersonajesRespuesta> personajesRespuestas;

    public InfoPage getInfoPage() {
        return infoPage;
    }

    public List<PersonajesRespuesta> getPersonajesRespuestas() {
        return personajesRespuestas;
    }
}
