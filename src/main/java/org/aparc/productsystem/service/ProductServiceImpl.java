package org.aparc.productsystem.service;

import org.aparc.productsystem.dao.ProductDao;
import org.aparc.productsystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    @Transactional
    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    @Transactional
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Transactional
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    @Transactional
    public void remove(int id) {
        productDao.remove(id);
    }
}
