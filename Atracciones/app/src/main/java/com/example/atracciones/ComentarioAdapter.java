package com.example.atracciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atracciones.data.ComentariosResponse;

import java.util.ArrayList;
import java.util.List;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder> {
    List<ComentariosResponse> data=new ArrayList<>();
    @NonNull
    @Override
    public ComentarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_comentarios, parent, false);
        return new ComentarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioViewHolder holder, int position) {
        holder.getTexto().setText(data.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setResults(List<ComentariosResponse> data){
        this.data=data;
        notifyDataSetChanged();
    }

    class ComentarioViewHolder extends RecyclerView.ViewHolder{
        private TextView texto;
        public ComentarioViewHolder(@NonNull View itemView) {
            super(itemView);
            texto=itemView.findViewById(R.id.comentarioTexto);
        }

        public TextView getTexto() {
            return texto;
        }
    }
}
