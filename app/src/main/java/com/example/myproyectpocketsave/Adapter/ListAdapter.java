package com.example.myproyectpocketsave.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myproyectpocketsave.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<DataModel> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(ArrayList<DataModel> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_home, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(ArrayList<DataModel> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tipoMovimiento, fechaMovimiento, descripcionMovimiento, montoMovimiento;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.IEImageView);
            tipoMovimiento = itemView.findViewById(R.id.textViewTipoMovimiento);
            fechaMovimiento = itemView.findViewById(R.id.textViewDataFechaMovimiento);
            descripcionMovimiento = itemView.findViewById(R.id.textViewDataDescripción);
            montoMovimiento = itemView.findViewById(R.id.textViewDataMontoMovimiento);
        }

        void bindData(final DataModel item ){
            image.setImageResource(item.getImage());
            tipoMovimiento.setText(item.getTipoMovimiento());
            fechaMovimiento.setText(item.getFechaMovimiento());
            descripcionMovimiento.setText(item.getFechaMovimiento());
            montoMovimiento.setText(item.getMontoMovimiento());
        }
    }
}
