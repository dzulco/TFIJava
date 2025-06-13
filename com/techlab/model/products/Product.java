package com.techlab.model.products;

public abstract class Product {
    private int id=0;
    private String nombre;
    private double precio;
    private int cantidadEnStock;
    private static int cont = 0;

    public Product(int cantidadEnStock, String nombre, double precio) {
        this.cantidadEnStock = cantidadEnStock;
        this.nombre = nombre;
        this.precio = precio;
        this.id= cont++; // autoincrement hardcode
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    // Método abstracto para obtener detalle específico
    public abstract String getDetalle();

    public abstract double calcularPrecioFinal();

    public void descontarStock(int cantidad){
        cantidadEnStock -= cantidad;
    }

    public static double calcularImpuesto(double precio){
        return precio * 0.21;
    }

    @Override
    public String toString() {
        return "Producto #" + id +
                ", nombre='" + nombre + '\'' +
                ", precio= $" + precio +
                ", stock=" + cantidadEnStock;
    }
}
