package org.aparc.productsystem.service;

import org.aparc.productsystem.dao.ProductCategoryDao;
import org.aparc.productsystem.model.productcategory.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao categoryDao;

    public ProductCategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Transactional
    public void createCategory(ProductCategory category) {
        categoryDao.createCategory(category);
    }

    @Transactional
    public List<ProductCategory> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Transactional
    public ProductCategory findById(int id) {
        return categoryDao.findById(id);
    }

    @Transactional
    public void update(ProductCategory category) {
        categoryDao.update(category);
    }

    @Transactional
    public void remove(int id) {
        categoryDao.remove(id);
    }
}
