package com.example.apirickymorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apirickymorty.API.MapearAPI.PersonajesRespuesta;
import com.example.apirickymorty.MutableLiveDataPersonajes.PersonajesViewModel;

public class PaginaDetalle extends AppCompatActivity {
    ImageView SImage;
    TextView SName, SStatus, SSpecies, SGender, SLoUrl, SLoName, SDebut;
    PersonajesViewModel vm;
    LiveData<PersonajesRespuesta> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_detalle);
        SImage = findViewById(R.id.SImage);
        SName = findViewById(R.id.SName);
        SStatus = findViewById(R.id.SStatus);
        SSpecies = findViewById(R.id.SSpecies);
        SGender = findViewById(R.id.SGender);
        SLoName = findViewById(R.id.SLoName);
        SLoUrl = findViewById(R.id.SLoUrl);
        SDebut = findViewById(R.id.SCreado);
        String id=getIntent().getStringExtra("id");
        //Cosas del viewmodel
        vm=new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data= vm.getPersonajesRespuestaLiveData();
        //Se hace la nueva petición
        vm.buscarPersonaje(id);
        data.observe(this, (data)->{
            //Se asignan los valores
            SName.setText(data.getName());
            SStatus.setText(data.getStatus());
            SSpecies.setText(data.getSpecies());
            SGender.setText(data.getGender());
            SLoName.setText(data.getName());
            SLoUrl.setText(data.getUrl());
            SDebut.setText(data.getCreated());
            //Se comprueba el contenido de la imagen
            if(data.getImagelink()!=null){
                String urlImg=data.getImagelink();
                Glide.with(this).load(urlImg).into(SImage);
            }
        });
    }
}