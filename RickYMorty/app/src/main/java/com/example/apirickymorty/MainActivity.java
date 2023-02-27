package com.example.apirickymorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.apirickymorty.API.MapearAPI.PaginaRespuesta;
import com.example.apirickymorty.MutableLiveDataPersonajes.PersonajeAdapter;
import com.example.apirickymorty.MutableLiveDataPersonajes.PersonajesViewModel;

public class MainActivity extends AppCompatActivity implements PersonajeAdapter.OnItemClickListener {
    Button BSiguiente, BVolver;
    RecyclerView personajeRecycler;
    PersonajesViewModel vm;
    LiveData<PaginaRespuesta> data;
    private static String PAGINA_INICIAL="1";
    private static String siguientePagina;
    private static String volverPagina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BSiguiente=findViewById(R.id.BSiguiente);
        BVolver=findViewById(R.id.BVolver);
        personajeRecycler=findViewById(R.id.PersonajesRecycler);
        //Cosas del Recycler y el adapter
        PersonajeAdapter adapter=new PersonajeAdapter(this);
        personajeRecycler.setLayoutManager(new LinearLayoutManager(this));
        personajeRecycler.setAdapter(adapter);
        //Metodo onClick
        adapter.setOnItemClickListener(this);
        //Cosas del ViewModel
        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data=vm.getPaginaRespuestaLiveData();
        //Observador MutableLiveData
        data.observe(this, (data)->{
            adapter.setResults(data.getPersonajesRespuestas());
            //Obtiene la siguiente página
            siguientePagina=data.getInfoPage().getNext();
            Log.d("Hola", String.valueOf(siguientePagina));
            //Obtiene la página anterior
            volverPagina=data.getInfoPage().getPrev();
        });
        //Invoca la primera página al cargar
        vm.buscarPagina(PAGINA_INICIAL);
        //Página siguiente
        BSiguiente.setOnClickListener(view->{
            if(siguientePagina!=null){
                //Hace una nueva petición
                vm.siguientePagina(siguientePagina);
            }
            else{
                Toast.makeText(this, "No hay página siguiente", Toast.LENGTH_SHORT).show();
            }
        });
        //Ir a página anterior
        BVolver.setOnClickListener(view->{
            //Se hace una nueva petición a la api
            if (volverPagina!=null){
                vm.volverPagina(volverPagina);
            }
            else{
                Toast.makeText(this, "No hay página previa", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemClick(int position){

    }
}