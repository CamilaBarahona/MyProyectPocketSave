package com.example.myproyectpocketsave.Entidades;
//POJO
public class Consolidado {
    private String movimiento;
    private String fecha;
    private String categoría;
    private String valor;
    private int imageId;

    public Consolidado() {

    }

    public Consolidado(String movimiento, String fecha,String categoría, String valor, int imageId) {
        this.movimiento = movimiento;
        this.fecha = fecha;
        this.categoría = categoría;
        this.valor = valor;
        this.imageId = imageId;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
