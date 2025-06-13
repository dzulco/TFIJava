package com.techlab.model.orders;

import com.techlab.model.Client;
import com.techlab.model.products.Cafe;
import com.techlab.model.products.Product;

public class OrderPrinter {

    public static void printOrder(Order order) {
        System.out.println("══════════════════════════════════════════════════════════════════════");
        System.out.printf("🧾 ORDEN #%d | Estado: %s | Total: $%.2f\n",
                order.getId(), order.getState(), order.getTotal());

        Client c = order.getClient();
        System.out.printf("👤 Cliente: %s | ✉️ %s\n", c.getNombre(), c.getEmail());
        System.out.println("══════════════════════════════════════════════════════════════════════");

        System.out.printf("| %-2s | %-8s | %-9s | %-5s | %-15s | %-5s | %-8s |\n",
                "ID", "Producto", "Precio", "Stock", "Tipo", "Cant.", "Subtotal");
        System.out.println("|----|----------|-----------|--------|-----------------|-------|----------|");

        for (OrderLine item : order.getOrderLines()) {
            Product p = item.getProduct();
            String tipo = "General";


            System.out.printf("| %-2d | %-8s | $%-8.2f | %-6d | %-15s | %-5d | $%-7.2f |\n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getCantidadEnStock(),
                    p.getDetalle(), item.getQuantity(), item.getSubTotal());
        }

        System.out.println("══════════════════════════════════════════════════════════════════════");
    }
}
