package com.example.bares;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bares.API.BarMap.BaresRepository;
import com.example.bares.API.BarMap.ReseñasResponse;

import java.util.List;

public class BaresViewModel extends ViewModel {
    private MutableLiveData<List<ReseñasResponse>> data;
    private BaresRepository baresRepository;
    public void init(){
        baresRepository=BaresRepository.getInstance();
        data=baresRepository.getBaresLiveData();
    }
    public void filtradoBares(int estrellas){
        baresRepository.filtradoBares(estrellas);
    }
    public void getBares(){
        baresRepository.getBares();
    }
    public LiveData<List<ReseñasResponse>> getBaresResponse(){
        return data;
    }
}
