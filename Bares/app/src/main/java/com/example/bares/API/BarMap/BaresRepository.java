package com.example.bares.API.BarMap;

import androidx.lifecycle.MutableLiveData;

import com.example.bares.API.BarService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
public class BaresRepository {
    private static final String API_URL = "http://192.168.1.130:8000/";
    private static BaresRepository instance;
    private BarService barService;
    private MutableLiveData<List<ReseñasResponse>> baresLiveData;

    public BaresRepository() {
        baresLiveData=new MutableLiveData<>();
        barService=new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BarService.class);
    }
    public static BaresRepository getInstance(){
        if (instance==null){
            instance=new BaresRepository();
        }
        return instance;
    }
    public void filtradoBares(int estrellas){
        barService.filtrarBares(estrellas)
                .enqueue(new Callback<List<ReseñasResponse>>() {
                    @Override
                    public void onResponse(Call<List<ReseñasResponse>> call, Response<List<ReseñasResponse>> response) {
                        if (response.body()!=null){
                            List<ReseñasResponse> listaBares=response.body();
                            baresLiveData.postValue(listaBares);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ReseñasResponse>> call, Throwable t) {
                        List<ReseñasResponse> listaBares=new ArrayList<>();
                        baresLiveData.postValue(listaBares);
                    }
                });
    }
    public void getBares(){
        barService.getBares()
                .enqueue(new Callback<List<ReseñasResponse>>() {
                    @Override
                    public void onResponse(Call<List<ReseñasResponse>> call, Response<List<ReseñasResponse>> response) {
                        if (response.body()!=null){
                            List<ReseñasResponse> listaBares=response.body();
                            baresLiveData.postValue(listaBares);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ReseñasResponse>> call, Throwable t) {
                        List<ReseñasResponse> listaBares=new ArrayList<>();
                        baresLiveData.postValue(listaBares);
                    }
                });
    }

    public MutableLiveData<List<ReseñasResponse>> getBaresLiveData() {
        return baresLiveData;
    }
}
