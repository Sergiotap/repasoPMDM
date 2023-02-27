package com.example.atracciones;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atracciones.data.AtraccionesResponse;

public class ComentariosActivity extends AppCompatActivity {
    private TextView nombre, desc, ocupantes;
    private RecyclerView lista;
    private ComentarioAdapter adapter;
    private AtraccionesViewMOdel vm;
    private LiveData<AtraccionesResponse> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
        nombre = findViewById(R.id.comentarioNombre);
        desc = findViewById(R.id.comentarioDesc);
        ocupantes = findViewById(R.id.comentarioOcupantes);
        lista = findViewById(R.id.comentariosRV);
        adapter=new ComentarioAdapter();
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
        vm=new ViewModelProvider(this).get(AtraccionesViewMOdel.class);
        Intent intent=getIntent();
        String id=intent.getStringExtra(MainActivity.ID_DETALLE);
        vm.getDetalleData().observe(this,response->{
            adapter.setResults(response.getComentarios());
            nombre.setText(response.getNombre());
            desc.setText(response.getDescripcion());
            ocupantes.setText(String.valueOf(response.getOcupantes()));
        });
        vm.getDetalle(id);
    }
}
