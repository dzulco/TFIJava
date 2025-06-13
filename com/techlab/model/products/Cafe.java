package com.techlab.model.products;

import com.techlab.model.Descontable;

public class Cafe extends Product implements Descontable {

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
        return super.toString() + ", Café de " + origen;
    }

    @Override
    public String getDetalle() {
        return "Origen: " + origen;
    }
}
