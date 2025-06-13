package com.techlab.service;

import com.techlab.exceptions.ProductNotFoundException;
import com.techlab.model.Inventory;
import com.techlab.model.products.Product;

import java.util.ArrayList;
import java.util.Optional;

public class ProductService {

    InventoryService inventoryService;

    public ProductService() {
        inventoryService = new InventoryService();
    }

    public ArrayList<Product> getProducts() {
        return inventoryService.getInventory().getProducts();
    }

    public void addProduct (Product product) {
        inventoryService.getInventory().getProducts().add(product);
    }

    public void removeProductById (int id) throws ProductNotFoundException {
        Product product = this.getProductById(id);
        getProducts().remove(product);
    }


    public Product getProductById (int id) throws ProductNotFoundException
    {
       Optional<Product> productFound = getProducts().stream().filter(product -> product.getId() == id).findFirst();
       if(productFound.isEmpty()) {
           throw new ProductNotFoundException("El producto no existe ❌");
       }
       return productFound.get();

    }

    public void updateProduct (Product product) throws ProductNotFoundException {
        Product productUpdate = this.getProductById(product.getId());
        productUpdate.setNombre(product.getNombre());
        productUpdate.setPrecio(product.getPrecio());
        productUpdate.setCantidadEnStock(product.getCantidadEnStock());
    }

    public void decrementQuantity(Product product, Integer quantity) {
        product.descontarStock(quantity);
    }

    public Inventory getInventory() {
        return inventoryService.getInventory();
    }
}
