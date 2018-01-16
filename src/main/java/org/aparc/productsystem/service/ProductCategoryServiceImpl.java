package org.aparc.productsystem.service;

import org.aparc.productsystem.dao.ProductCategoryDao;
import org.aparc.productsystem.model.productcategory.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao categoryDao;

    public ProductCategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void createCategory(ProductCategory category) {
        categoryDao.createCategory(category);
    }

    public List<ProductCategory> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public ProductCategory findById(int id) {
        return categoryDao.findById(id);
    }

    public void update(ProductCategory category) {
        categoryDao.update(category);
    }

    public void remove(int id) {
        categoryDao.remove(id);
    }
}
