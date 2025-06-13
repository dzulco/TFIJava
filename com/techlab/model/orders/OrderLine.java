package com.techlab.model.orders;

import com.techlab.model.products.Product;

public class OrderLine {
    Product product;
    int quantity;
    double subTotal;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = product.getPrecio() * quantity;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "Item de orden ->" +
                " "+ product.toString() +
                ", cantidad=" + quantity +
                ", subtotal=$" + '\n';
    }
}
