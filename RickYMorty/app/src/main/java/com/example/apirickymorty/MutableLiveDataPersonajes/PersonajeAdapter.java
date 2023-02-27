package com.example.apirickymorty.MutableLiveDataPersonajes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apirickymorty.API.MapearAPI.PersonajesRespuesta;
import com.example.apirickymorty.MainActivity;
import com.example.apirickymorty.PaginaDetalle;
import com.example.apirickymorty.R;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;
import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter <PersonajeAdapter.PersonajeAdapterResultHolder> {
    private List<PersonajesRespuesta> results=new ArrayList<>();
    private OnItemClickListener mListener;
    private Context mContext;
    //Para los intent
    public PersonajeAdapter(Context context){
        mContext=context;
    }

    @NonNull
    @Override
    public PersonajeAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_personajes, parent, false);
        return new PersonajeAdapterResultHolder(itemview);
    }

    //Metodo para insertar los objetos
    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapterResultHolder holder, int position){
        //Recibe la página con la info
        PersonajesRespuesta personajesRespuesta=results.get(position);
        //Inserto al Recycler
        holder.EName.setText(personajesRespuesta.getName());
        holder.EStatus.setText(personajesRespuesta.getStatus());
        holder.Especies.setText(personajesRespuesta.getSpecies());
        holder.Egender.setText(personajesRespuesta.getGender());
        //Aquí se hace el intent
        holder.itemView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               if(mListener!=null){
                   //Extrae el id del objeto RecyclerPulsado
                   //Método que envía a otra actividad
                   Intent intent=new Intent(mContext, PaginaDetalle.class);
                   intent.putExtra("id", personajesRespuesta.getId());
                   mContext.startActivity(intent);
               }
           }
        });
        //En imágenes
        if (personajesRespuesta.getImagelink()!=null){
            //No es necesario replace ya que es HTTPS
            String imgURL=personajesRespuesta.getImagelink();
            Glide.with(holder.itemView)
                    .load(imgURL)
                    .into(holder.EImagenPersonaje);
        }
    }
    @Override
    public int getItemCount(){
        return results.size();
    }
    //Asigna el valor al results y reinicia el LiveData
    public void setResults(List<PersonajesRespuesta> results){
        this.results=results;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener=listener;
    }

    //Clase Holder (Es otra clase en el mismo documento) Así se hacía originalmente y funcionaba. Y como dice la norma, si funciona no se toca
    class PersonajeAdapterResultHolder extends RecyclerView.ViewHolder{
        //Se crean las variables para el Recycler
        private TextView EName, EStatus, Especies, Egender;
        private ImageView EImagenPersonaje;
        public PersonajeAdapterResultHolder(@NonNull View itemView){
            super(itemView);
            //Se asignan las ids
            EName=itemView.findViewById(R.id.Ename);
            EStatus=itemView.findViewById(R.id.Estatus);
            Especies=itemView.findViewById(R.id.Especies);
            Egender=itemView.findViewById(R.id.Egender);
            EImagenPersonaje=itemView.findViewById(R.id.EimagenPersonaje);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
