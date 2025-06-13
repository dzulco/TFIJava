package com.techlab.model;

import com.techlab.model.products.Product;

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
        StringBuffer buffer = new StringBuffer();
        for (Product product : products) {
            buffer.append(product.toString() + "\n");
        }
        return buffer.toString();
    }
}
