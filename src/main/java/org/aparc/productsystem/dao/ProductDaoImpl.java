package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory factory;

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public void createProduct(Product product) {
        Session session = factory.getCurrentSession();
        session.persist(product);
        
    }

    @SuppressWarnings("uncheked")
    public List<Product> getAll() {
        Session session = factory.openSession();
        List<Product> list = session.createQuery("from Product").list();
        
        return list;
    }

    public Product findById(int id) {
        Session session = factory.getCurrentSession();
        Product product = session.find(Product.class, id);
        
        return product;
    }

    public void update(Product product) {
        Session session = factory.getCurrentSession();
        session.update(product);
    }

    public void remove(int id) {
        Session session = factory.getCurrentSession();
        session.createQuery("delete from Product where productId = :productId")
                .setParameter("productId", id)
                .executeUpdate();
    }


}
