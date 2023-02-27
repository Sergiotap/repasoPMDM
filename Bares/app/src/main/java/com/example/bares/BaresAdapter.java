package com.example.bares;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bares.API.BarMap.ReseñasResponse;

import java.util.ArrayList;
import java.util.List;

public class BaresAdapter extends RecyclerView.Adapter<BaresAdapter.BaresViewHolder>{
    private List<ReseñasResponse> data=new ArrayList<>();

    @NonNull
    @Override
    public BaresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_bares, parent, false);
        return new BaresViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaresViewHolder holder, int position) {
        holder.getNombre().setText(data.get(position).getNombre());
        holder.getDescripcion().setText(data.get(position).getDescripcion());
        holder.getCierre().setText(data.get(position).getCierre());
        holder.getApertura().setText(data.get(position).getApertura());
        holder.getEstrellas().setText(String.valueOf(data.get(position).getEstrellas()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setResults(List<ReseñasResponse> data){
        this.data=data;
        notifyDataSetChanged();
    }

    class BaresViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,descripcion,cierre,apertura,estrellas;

        public BaresViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.baresNombre);
            descripcion=itemView.findViewById(R.id.baresDesc);
            cierre=itemView.findViewById(R.id.baresCierre);
            apertura=itemView.findViewById(R.id.baresApertura);
            estrellas=itemView.findViewById(R.id.baresEstrellas);
        }

        public TextView getApertura() {
            return apertura;
        }

        public TextView getCierre() {
            return cierre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public TextView getEstrellas() {
            return estrellas;
        }

        public TextView getNombre() {
            return nombre;
        }
    }
}
