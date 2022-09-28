package com.example.myproyectpocketsave.Adapter;

public class DataModel {
    String tipoMovimiento;
    String fechaMovimiento;
    String descripcionMovimiento;
    int montoMovimiento;
    int id_;
    int image;

    public DataModel(String tipoMovimiento, int montoMovimiento, String fechaMovimiento, String descripcionMovimiento,  int id_) {
        this.tipoMovimiento = tipoMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.descripcionMovimiento = descripcionMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.id_ = id_;
        this.image = image;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public int getMontoMovimiento() {
        return montoMovimiento;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}
