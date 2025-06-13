package com.techlab.model.orders;

import com.techlab.model.Client;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines;
    private Client client;
    private OrderState state;
    private int id;
    private static int cont = 0;
    private double total;

    public Order( OrderState state, Client client) {
        this.orderLines = new ArrayList<>();
        this.id = cont ++;
        this.state = state;
        this.client = client;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden #" + id +
                ", total=$" + total +
                ", estado=" + state +
                "," + client +
                " " + orderLines.toString() +
                '\n';
    }
}
