package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.productcategory.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private SessionFactory factory;

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public void createCategory(ProductCategory category) {
        Session session = factory.getCurrentSession();
        session.persist(category);
    }

    public List<ProductCategory> getAllCategories() {
        Session session = factory.getCurrentSession();
        return session.createQuery("from ProductCategory").list();
    }

    public ProductCategory findById(int id) {
        Session session = factory.getCurrentSession();
        return session.find(ProductCategory.class, id);
    }

    public void update(ProductCategory category) {
        Session session = factory.getCurrentSession();
        session.update(category);
    }

    public void remove(int id) {
        Session session = factory.getCurrentSession();
        session.createQuery("delete from ProductCategory where  categoryId = :categoryId").
                setParameter("categoryId", id).
                executeUpdate();
    }
}
