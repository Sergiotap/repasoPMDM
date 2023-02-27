package com.example.apirickymorty.API.MapearAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//Primera clase creada (Obtiene los datos del JSON recibido)
public class PersonajesRespuesta {
    //Fecha de debut del personaje
    @SerializedName("created")
    @Expose
    private String created;
    //Devuelve url del personaje creado a partir de su id
    @SerializedName("url")
    @Expose
    private String url;
    //Obtiene la lista de episodios en que aparece el personaje
    @SerializedName("episode")
    @Expose
    List<String> episode;
    //Obtiene la url de la imagen (A veces necesario un objeto)
    @SerializedName("image")
    @Expose
    private String imagelink;
    //Obtiene la location, se requiere la clase necesaria para el objeto
    @SerializedName("location")
    @Expose
    Location location;
    //Obtiene el origen, se requiere la clase necesaria para el objeto
    @SerializedName("origin")
    @Expose
    Origin origin;
    //Obtiene el género del personaje
    @SerializedName("gender")
    @Expose
    private String gender;
    //Obtiene el type (en la mayoría de los personajes es null)
    @SerializedName("type")
    @Expose
    private String type;
    //Obtiene la especie
    @SerializedName("species")
    @Expose
    private String species;
    //Obtiene el estado
    @SerializedName("status")
    @Expose
    private String status;
    //Obtiene el nombre
    @SerializedName("name")
    @Expose
    private String name;
    //Obtiene el id
    @SerializedName("id")
    @Expose
    private String id;

    public List<String> getEpisode() {
        return episode;
    }

    public Location getLocation() {
        return location;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getCreated() {
        return created;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getImagelink() {
        return imagelink;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
