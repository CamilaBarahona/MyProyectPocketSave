package com.example.myproyectpocketsave.AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproyectpocketsave.Entidades.ResumenMensual;
import com.example.myproyectpocketsave.R;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    Context context;
    ArrayList<ResumenMensual> resumenMensualArrayList;

    //Listener
    private View.OnClickListener listener;

    public AdapterHome(Context context, ArrayList<ResumenMensual> data) {
        this.context = context;
        this.resumenMensualArrayList = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_home, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResumenMensual resumenMensual = resumenMensualArrayList.get(position);
        holder.meses.setText(resumenMensual.getMes());
        holder.montosIngreso.setText(resumenMensual.getMontoIngreso());
        holder.montosEgreso.setText(resumenMensual.getMontoEgreso());
        holder.imagen.setImageResource(resumenMensual.getImagenId());
        /*String mes = model.get(position).getMes();
        String montoIngreso = model.get(position).getMontoIngreso();
        String montoEgreso = model.get(position).getMontoEgreso();
        int imagen = model.get(position).getImagenId();
        holder.meses.setText(mes);
        holder.montosIngreso.setText(montoIngreso);
        holder.montosEgreso.setText(montoEgreso);
        holder.imagen.setImageResource(imagen);*/
    }

    @Override
    public int getItemCount() {
        return resumenMensualArrayList.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView meses, montosIngreso, montosEgreso;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meses = itemView.findViewById(R.id.tvMes);
            montosIngreso = itemView.findViewById(R.id.tvTotalIngresos);
            montosEgreso = itemView.findViewById(R.id.tvTotalEgresos);
            imagen = itemView.findViewById(R.id.imagenResumen);
        }
    }
}
