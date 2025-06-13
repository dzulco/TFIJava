package com.techlab.model.products;

import com.techlab.model.Descontable;

public class Te extends Product implements Descontable {

    private String variedad;

    public Te(int cantidadEnStock, String nombre, double precio, String variedad) {
        super(cantidadEnStock, nombre, precio);
        this.variedad = variedad;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        return getPrecio() * porcentaje;
    }

    @Override
    public String getDetalle() {
        return "Variedad: " + variedad;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 0.95;
    }

    @Override
    public String toString() {
        return super.toString() + " Té variedad " + variedad;
    }

}
