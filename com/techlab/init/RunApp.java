package com.techlab.init;

import com.techlab.model.*;
import com.techlab.service.ClientService;
import com.techlab.service.InventoryService;
import com.techlab.service.OrderService;
import com.techlab.service.ProductService;
import com.techlab.util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

class RunApp {
    InventoryService inventoryService = new InventoryService();
    Inventory inventory = inventoryService.getInventory();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    ClientService clienteService = new ClientService();


    public  void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println();
            System.out.println("=".repeat(35));
            System.out.println("   SISTEMA DE GESTION - TECHLAB  ");
            System.out.println("=".repeat(35));
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear una orden");
            System.out.println("6) Listar ordenes");
            System.out.println("7) Salir");

            opcion = Utils.leerEntero(sc, "Elija una opción: ");
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarProducto();
                case 4 -> eliminarProducto();
                case 5 -> crearOrden();
                case 6 -> listarOrdenes();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion inválida.");
            }
        } while (opcion != 7);
    }

    private void listarOrdenes() {
        System.out.println(orderService.getOrders());
    }

    private void crearOrden() {
        System.out.println("Crear orden");
        orderService.createOrder(clienteService.generateClient("pepe","damian@gmail.com"),
                null);
    }

    private void buscarProducto() {
        System.out.println("Buscar producto");
        System.out.println(productService.getProductById(inventory,1));
    }

    private void eliminarProducto() {
        System.out.println("Eliminar producto");
        System.out.println(productService.removeProductById(inventory,1));
    }

    private void listarProductos() {
        System.out.println("Listar productos");
        System.out.println(inventoryService.getInventory().toString());
    }

    private void agregarProducto() {
        System.out.println("Agregar producto");

        Product product = new Cafe(12,"Cafe2",8500,"Colombia");
        productService.addProduct(inventory, product);
        System.out.println("Producto creado: " + product.toString());

    }
}