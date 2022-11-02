package com.example.myproyectpocketsave.AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproyectpocketsave.Entidades.Consolidado;
import com.example.myproyectpocketsave.R;

import java.util.ArrayList;

public class AdapterConsolidado  extends RecyclerView.Adapter<AdapterConsolidado.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    Context context;
    ArrayList<Consolidado> consolidadoArrayList;

    //Listener
    private View.OnClickListener listener;

    public AdapterConsolidado(Context context, ArrayList<Consolidado> data) {
        this.context = context;
        this.consolidadoArrayList = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.cards_gastos, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Consolidado consolidado = consolidadoArrayList.get(position);
        holder.movimiento.setText(consolidado.getMovimiento());
        holder.fecha.setText(consolidado.getFecha());
        holder.categoria.setText(consolidado.getCategoría());
        holder.valor.setText(consolidado.getValor());
        holder.image.setImageResource(consolidado.getImageId());

    }

    @Override
    public int getItemCount() {
        return consolidadoArrayList.size();
    }
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView movimiento, fecha, categoria, valor;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movimiento = itemView.findViewById(R.id.tvMovimiento);
            fecha = itemView.findViewById(R.id.tvFecha);
            categoria = itemView.findViewById(R.id.tvCategoria);
            valor = itemView.findViewById(R.id.tvValor);
            image = itemView.findViewById(R.id.imagenConsolidado);
        }
    }
}
