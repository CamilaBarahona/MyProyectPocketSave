package com.example.myproyectpocketsave.menuHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproyectpocketsave.AdapterHome.AdapterConsolidado;
import com.example.myproyectpocketsave.Entidades.Consolidado;
import com.example.myproyectpocketsave.R;

import java.util.ArrayList;


public class GastosFragment extends Fragment {
    private final static int rView = R.layout.fragment_gastos;

    public GastosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(rView, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Consolidado> data = dataInitialize();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewGastos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        AdapterConsolidado adapterConsolidado = new AdapterConsolidado(getContext(), data);
        recyclerView.setAdapter(adapterConsolidado);
        adapterConsolidado.notifyDataSetChanged();
    }

    private ArrayList<Consolidado> dataInitialize() {
        ArrayList<Consolidado> consolidadoArrayList = new ArrayList<>();
        consolidadoArrayList.add(new Consolidado("INGRESO", "01/07/2022", "Sueldo", "$650.000", R.drawable.flechaverde));
        consolidadoArrayList.add(new Consolidado("INGRESO", "03/07/2022", "prestamo Juanita", "$60.000", R.drawable.flechaverde));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Luz", "$20.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Celular", "$15.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Agua", "$10.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Gas", "$21.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Internet", "$18.395", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Arriendo", "$250.000", R.drawable.red_arrow));
        return consolidadoArrayList;
    }
}