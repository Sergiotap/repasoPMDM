package com.example.bares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lista;
    private EditText param;
    private Button filtrar;
    private BaresAdapter adapter;
    private BaresViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new BaresAdapter();
        lista=findViewById(R.id.baresLista);
        param=findViewById(R.id.baresFiltro);
        filtrar=findViewById(R.id.bareBoton);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
        vm=new ViewModelProvider(this).get(BaresViewModel.class);
        vm.init();
        vm.getBaresResponse().observe(this, (dato)->{
            adapter.setResults(dato);
        });
        filtrar.setOnClickListener(view->{
            int estrellas=Integer.parseInt(String.valueOf(param.getText().toString()));
            //Toast.makeText(this,param.getText().toString(), Toast.LENGTH_LONG).show();
            vm.filtradoBares(estrellas);
        });
        vm.getBares();
    }
}