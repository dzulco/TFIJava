package com.techlab.model;

public class Cafe extends Product implements Descontable{

    String origen;

    public Cafe(int cantidadEnStock, String nombre, double precio, String origen) {
        super(cantidadEnStock, nombre, precio);
        this.origen = origen;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        return getPrecio() * porcentaje;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 0.80;
    }

    @Override
    public String toString() {
        return super.toString() + "Cafe [origen=" + origen + "]\n";
    }

    public void someMethod(int i) {
    }
}
