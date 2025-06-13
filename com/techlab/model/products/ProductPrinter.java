package com.techlab.model.products;

import com.techlab.model.Inventory;

public class ProductPrinter {
    public static void inventoryPrinter(Inventory inventory) {
        System.out.println();
        System.out.printf("%-5s %-20s %-10s %-10s %-20s%n", "ID", "Nombre", "Precio", "Stock", "Detalle");
        System.out.println("----------------------------------------------------------------------");

        for (Product p : inventory.getProducts()) {
            System.out.printf("%-5d %-20s $%-9.2f %-10d %-20s%n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getCantidadEnStock(), p.getDetalle());
        }
    }

    public static void productPrinter(Product p) {
        System.out.println();
        System.out.printf("%-5s %-20s %-10s %-10s %-20s%n", "ID", "Nombre", "Precio", "Stock", "Detalle");
        System.out.println("----------------------------------------------------------------------");

        System.out.printf("%-5d %-20s $%-9.2f %-10d %-20s%n",
                p.getId(), p.getNombre(), p.getPrecio(), p.getCantidadEnStock(), p.getDetalle());
    }

}
