package com.example.myproyectpocketsave.Entidades;

// POJO
public class ResumenMensual {
    private String mes;
    private String montoIngreso;
    private String montoEgreso;
    private int imagenId;

    public ResumenMensual() {

    }

    public ResumenMensual(String mes, String montoIngreso, String montoEgreso, int imagenId) {
        this.mes = mes;
        this.montoIngreso = montoIngreso;
        this.montoEgreso = montoEgreso;
        this.imagenId = imagenId;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMontoIngreso() {
        return montoIngreso;
    }

    public void setMontoIngreso(String montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    public String getMontoEgreso() {
        return montoEgreso;
    }

    public void setMontoEgreso(String montoEgreso) {
        this.montoEgreso = montoEgreso;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
