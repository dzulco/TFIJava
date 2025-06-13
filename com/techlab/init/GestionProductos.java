package com.techlab.init;

import com.techlab.exceptions.InsufficientStockException;
import com.techlab.exceptions.ProductNotFoundException;
import com.techlab.model.orders.Order;
import com.techlab.model.products.Cafe;
import com.techlab.model.products.Product;
import com.techlab.model.products.Te;
import com.techlab.service.ClientService;
import com.techlab.service.OrderService;
import com.techlab.service.ProductService;
import com.techlab.util.Utils;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GestionProductos {

    ProductService productService = new ProductService();
    OrderService orderService = new OrderService(productService);
    ClientService clienteService = new ClientService();


    public GestionProductos() {
        inicializarProductos();
    }

    public void menu() {
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

            opcion = Utils.leerEntero("Elija una opción: ");
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
        System.out.println("=".repeat(35));
        System.out.println("--- ORDENES - TECHLAB ---");
        System.out.println("=".repeat(35));
        if(orderService.getOrders().isEmpty()) {
            System.out.println("No hay órdenes cargadas.");
        }else {
            System.out.println(orderService.getOrders());
        }
    }

    private void crearOrden() {
        System.out.println("Crear orden");

        System.out.println("DATOS DEL CLIENTE");
        String name = Utils.leerCadena("Nombre del cliente: ");
        String email = Utils.leerCadena("Email del cliente: ");

        System.out.println("DATOS DE LA ORDEN");
        Map<Integer,Integer> mapOrden = new HashMap<>();
        int idProducto, cantidadProducto;
        int cantidadItems = Utils.leerEntero("Ingrese cantidad de items de la orden: ");

        for (int i = 0; i < cantidadItems; i++) {
            idProducto = Utils.leerEntero("Ingrese ID del producto: ");
            cantidadProducto = Utils.leerEntero("Ingrese la cantidad de producto: ");
            mapOrden.put(idProducto, cantidadProducto);
        }
        try {
            Order order = orderService.createOrder(clienteService.generateClient(name, email), mapOrden);
            System.out.println("Orden #" + order.getId() + " agregada exitosamente. ✅");
        } catch (ProductNotFoundException | InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void buscarProducto() {
        System.out.println("Buscar producto");
        int id = Utils.leerEntero("Ingrese ID producto: ");

        try {
            Product product = productService.getProductById(id);
            System.out.println(product);
        }catch (ProductNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void eliminarProducto() {
        System.out.println("Eliminar producto");
        int id = Utils.leerEntero("Ingrese ID producto: ");
        try{
            productService.removeProductById(id);
            System.out.println("El producto fue eliminado ✅");
        }catch (ProductNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void listarProductos() {
        System.out.println();
        System.out.println("=".repeat(35));
        System.out.println("--- PRODUCTOS - TECHLAB ---");
        System.out.println("=".repeat(35));
        // Encabezado
        System.out.printf("%-5s %-20s %-10s %-10s %-20s%n", "ID", "Nombre", "Precio", "Stock", "Detalle");
        System.out.println("----------------------------------------------------------------------");

        for (Product p : productService.getProducts()) {
            System.out.printf("%-5d %-20s $%-9.2f %-10d %-20s%n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getCantidadEnStock(), p.getDetalle());
        }
    }

    private void agregarProducto() {

        System.out.println("=".repeat(20));
        System.out.println("INGRESE TIPO DE PRODUCTO");
        System.out.println("=".repeat(20));
        System.out.println("1) CAFÉ");
        System.out.println("2) TÉ");
        System.out.println("3) Salir");
        System.out.println();
        Product product=null;
        int opcion=Utils.leerEntero("Ingrese opcion: ");
        switch (opcion) {
            case 1 -> {
                datosProdComunes record = getDatosProdComunes();
                String origen = Utils.leerCadena("Ingrese origen del café: ");
                product = new Cafe(record.cantidad(), record.nombre(), record.precio(),origen);
            }
            case 2 -> {
                datosProdComunes record = getDatosProdComunes();
                String variedad = Utils.leerCadena("Ingrese variedad de té: ");
                product = new Te(record.cantidad(),record.nombre(),record.precio(),variedad);
            }
            case 3 -> {}
            default -> System.out.println("Opcion inválida.");
        }
        if(product!=null) {
            productService.addProduct(product);
            System.out.println("Producto agregado exitosamente. ✅");
        }
    }

    private static datosProdComunes getDatosProdComunes() {
        String nombre = Utils.leerCadena("Nombre del nuevo producto: ");
        double precio = Utils.leerDouble("Precio del producto: ");
        int cantidad = Utils.leerEntero("Cantidad del producto: ");
        datosProdComunes record = new datosProdComunes(nombre, precio, cantidad);
        return record;
    }

    private record datosProdComunes(String nombre, double precio, int cantidad) {
    }

    private void inicializarProductos(){
        productService.addProduct(new Cafe(122,"Cafe3",8500,"Brasil"));
        productService.addProduct(new Cafe(12,"Cafe2",8500,"Colombia"));
        productService.addProduct(new Te(1,"Te1",800,"Black"));
        productService.addProduct(new Te(56,"Te2",600,"Blend"));

    }
}