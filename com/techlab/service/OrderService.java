package com.techlab.service;

import com.techlab.exceptions.InsufficientStockException;
import com.techlab.model.Client;
import com.techlab.model.orders.Order;
import com.techlab.model.orders.OrderLine;
import com.techlab.model.orders.OrderState;
import com.techlab.model.products.Product;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class OrderService {

    ArrayList<Order> orders;
    ProductService productService;

    public OrderService(ProductService productService) {
         orders = new ArrayList<>();
         this.productService = productService;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order createOrder(Client client, Map<Integer, Integer> mapProductsOrder ) throws InsufficientStockException {

        Order order = new Order(OrderState.GENERADA,client);

        //Recorro el map de idproducto y cantidad solicitada
        //Sino existe el producto lanza error
        //sino hay cantidad lanza error
        mapProductsOrder.forEach((id, cantidad)->{
            Product product = productService.getProductById(id);
            if(product.getCantidadEnStock()<cantidad){
                throw new InsufficientStockException("No hay esa cantidad en stock ❌");
            }

        });

        //los recorro de nuevo y genero las order lines y decremento cantidad
        mapProductsOrder.forEach((id, cantidad)->{
            Product product = productService.getProductById(id);
            productService.decrementQuantity(product,cantidad);
            OrderLine orderLine = new OrderLine(product,cantidad);
            order.getOrderLines().add(orderLine);
        });

            //calculo el total
        double total = calculateTotal(order.getOrderLines());
        order.setTotal(total);

        //Cuando termino de generar toda la orden, recien la agrego a la lista de ordenes
        orders.add(order);
        //retorno la orden recien creada
        return order;
    }

    private double calculateTotal(ArrayList<OrderLine> orderLines) {
        double total = 0;
        for (OrderLine orderLine : orderLines) {
            total += orderLine.getQuantity() * orderLine.getProduct().getPrecio();
        }
        return total;
    }

    public Optional<Order> findOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }


}
