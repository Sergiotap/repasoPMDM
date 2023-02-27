package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String ID_DETALLE="ID";
    private RecyclerView lista;
    private AtraccionesAdapter adapter;
    private AtraccionesViewMOdel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new AtraccionesAdapter();
        lista=findViewById(R.id.atraccionesRV);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
        vm=new ViewModelProvider(this).get(AtraccionesViewMOdel.class);
        vm.setCampoPrueba("Prueba");
        vm.getListaData().observe(this, (dato)->{
            adapter.setResults(dato);
        });
        adapter.setClickListener((view, v)->{
            String id=getId(v);
            Intent intent = new Intent(this, ComentariosActivity.class);
            intent.putExtra(ID_DETALLE, id);
            startActivity(intent);
        });
        vm.getAtracciones();
    }
    private String getId(String url){
        String[] partes=url.split("/");
        String id=partes[partes.length-1];
        return id;
    }
}