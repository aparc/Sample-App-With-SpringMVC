package org.aparc.productsystem.service;

import org.aparc.productsystem.model.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> getAll();

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
