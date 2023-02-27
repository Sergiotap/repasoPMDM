package com.example.apirickymorty.MutableLiveDataPersonajes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.apirickymorty.API.MapearAPI.PaginaRespuesta;
import com.example.apirickymorty.API.MapearAPI.PersonajesRespuesta;
import com.example.apirickymorty.API.PersonajeRepository;

public class PersonajesViewModel extends AndroidViewModel {
    private PersonajeRepository personajeRepository;
    private LiveData<PaginaRespuesta> paginaRespuestaLiveData;
    private LiveData<PersonajesRespuesta> personajesRespuestaLiveData;
    //Constructir obligatorio
    public PersonajesViewModel(@NonNull Application application){
        super(application);
    }
    public void init(){
        personajeRepository=new PersonajeRepository();
        paginaRespuestaLiveData= personajeRepository.getPaginasRespuestaLiveData();
        personajesRespuestaLiveData=personajeRepository.getPersonajeRespuestaLiveData();
    }
    //Métodos del mutable
    public void buscarPagina(String page){
        personajeRepository.buscarPagina(page);
    }
    //Métodos del mutable
    public void buscarPersonaje(String id) {
        personajeRepository.buscarPersonaje(id);
    }
    //Ir a siguiente página mediante otra petición a la API
    public void siguientePagina(String peticionSiguiente){
        personajeRepository.siguientePagina(peticionSiguiente);
    }
    //Ir a página anterior mediante otra petición a la API
    public void volverPagina(String peticionVolver){
        personajeRepository.volverPagina(peticionVolver);
    }
    //Getters
    public LiveData<PaginaRespuesta> getPaginaRespuestaLiveData(){
        return paginaRespuestaLiveData;
    }

    public LiveData<PersonajesRespuesta> getPersonajesRespuestaLiveData() {
        return personajesRespuestaLiveData;
    }
}
