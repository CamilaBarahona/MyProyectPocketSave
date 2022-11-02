package com.example.myproyectpocketsave.menuHome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproyectpocketsave.AdapterHome.AdapterHome;
import com.example.myproyectpocketsave.Entidades.ResumenMensual;
import com.example.myproyectpocketsave.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private final static int rView = R.layout.fragment_home;

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(rView, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<ResumenMensual> data = dataInitialize();
        RecyclerView recyclerview = view.findViewById(R.id.recyclerViewHome);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterHome adapterHome = new AdapterHome(getContext(), data);
        recyclerview.setAdapter(adapterHome);
        adapterHome.notifyDataSetChanged();
    }

    // Simula la BDD
    private ArrayList<ResumenMensual> dataInitialize() {
        ArrayList<ResumenMensual> resumenMensualArrayList = new ArrayList<>();
        resumenMensualArrayList.add(new ResumenMensual("JUNIO 2022", "$640.000", "270.000", R.drawable.gasto));
        resumenMensualArrayList.add(new ResumenMensual(" JULIO 2022", "645.000", "325.000", R.drawable.gasto));
        resumenMensualArrayList.add(new ResumenMensual("AGOSTO 2022", "650.0000", "400.000", R.drawable.gasto));
        resumenMensualArrayList.add(new ResumenMensual(" SEPTIEMBRE 2022", "655.000", "330.000", R.drawable.gasto));
        resumenMensualArrayList.add(new ResumenMensual(" OCTUBRE 2022", "660.000", "290.000", R.drawable.gasto));
        return  resumenMensualArrayList;
    }
}