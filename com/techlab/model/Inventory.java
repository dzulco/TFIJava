package com.techlab.model;

import java.util.ArrayList;


public class Inventory {

    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {}

    @Override
    public String toString() {
        return "Listado de productos: {" + products +
                '}';
    }
}
