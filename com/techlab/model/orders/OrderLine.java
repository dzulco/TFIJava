package com.techlab.model.orders;

import com.techlab.model.products.Product;

public class OrderLine {
    Product product;
    int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

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
        return "Item de orden ->" +
                " "+ product.toString() +
                ", cantidad=" + quantity + '\n';
    }
}
