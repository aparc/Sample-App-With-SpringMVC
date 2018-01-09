package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class ProductDaoImpl implements ProductDao {

    private final SessionFactory factory;

    public ProductDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public void createProduct(Product product) {
        Session session = factory.openSession();
        session.persist(product);
        session.close();
    }

    public List<Product> getAll() {
        Session session = factory.openSession();
        List<Product> list = session.createQuery("from Product").list();
        session.close();
        return list;
    }

    public Product findById(int id) {
        Session session = factory.openSession();
        Product product = session.find(Product.class, id);
        session.close();
        return product;
    }

    public void update(Product product) {
        Session session = factory.openSession();
        session.update(product);
        session.close();
    }

    public void remove(int id) {
        Session session = factory.openSession();
        session.createQuery("delete from PRODUCT where PRODUCT_ID = :productId")
                .setParameter("productId", id)
                .executeUpdate();
        session.close();
    }
}
