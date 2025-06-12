package com.techlab.service;

import com.techlab.model.Client;
import com.techlab.model.Order;
import com.techlab.model.OrderLine;
import com.techlab.model.OrderState;

import java.util.ArrayList;
import java.util.Optional;

public class OrderService {

    ArrayList<Order> orders;

    public OrderService() {
         orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void createOrder(Client client, ArrayList<OrderLine> orderLines) {
        Order order = new Order(orderLines, OrderState.GENERADA,client);
        double total = calculateTotal(orderLines);
        order.setTotal(total);
        orders.add(order);
    }

    private double calculateTotal(ArrayList<OrderLine> orderLines) {
        double total = 0;
        for (OrderLine orderLine : orderLines) {
            total = orderLine.getQuantity() * orderLine.getProduct().getPrecio();
        }
        return total;
    }

    public Optional<Order> findOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }


}
