package com.techlab.model;

public class OrderLine {
    Product product;
    int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item de orden {" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
