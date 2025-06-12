package com.techlab.service;

import com.techlab.model.Inventory;
import com.techlab.model.Product;

import java.util.Optional;

public class ProductService {

    public void addProduct (Inventory inventory, Product product) {
        inventory.getProducts().add(product);
    }

    public boolean removeProductById (Inventory inventory, int id) {
        Optional<Product> optionalProduct = this.getProductById(inventory, id);
        boolean flag = false;
        if (optionalProduct.isPresent()) {
            inventory.getProducts().remove(optionalProduct.get());
            flag = true;
        }
        return flag;
    }

    public Optional<Product> getProductById (Inventory inventory, int id) {
       return inventory.getProducts().stream().filter(product -> product.getId() == id).findFirst();
    }

    public boolean updateProduct (Inventory inventory, Product product) {
        Optional<Product> optionalProduct = this.getProductById(inventory, product.getId());
        boolean flag = false;
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setNombre(product.getNombre());
            optionalProduct.get().setPrecio(product.getPrecio());
            optionalProduct.get().setCantidadEnStock(product.getCantidadEnStock());
            flag = true;
        }
        return flag;
    }

}
