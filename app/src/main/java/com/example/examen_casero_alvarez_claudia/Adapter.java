package com.example.examen_casero_alvarez_claudia;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<Segundos> segundos;
    Context context;


    public Adapter(Context context, List<Segundos> modelList){
        this.context = context;
        segundos = modelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.segundos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(segundos.get(position));
    }

    @Override
    public int getItemCount() {
        return segundos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "MyViewHolder";
        private final TextView texto;


        ViewHolder(@NonNull View v){
            super(v);
            texto = v.findViewById(R.id.texto);



        }



        public void bind(Segundos s){
            String t = s.getSegundos() + "SEGUNDOS";
            texto.setText(t);

        }
    }


}
