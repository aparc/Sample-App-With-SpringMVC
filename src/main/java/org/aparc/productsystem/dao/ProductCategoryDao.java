package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    void createCategory(ProductCategory category);

    List<ProductCategory> getAllCategories();

    ProductCategory findById(int id);

    void update(ProductCategory category);

    void remove(int id);
}
