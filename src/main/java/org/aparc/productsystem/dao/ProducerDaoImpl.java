package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.Producer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducerDaoImpl implements ProducerDao {

    private SessionFactory factory;

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public void createProducer(Producer producer) {
        factory.getCurrentSession().persist(producer);
    }

    public List<Producer> getAllProducers() {
        return factory.getCurrentSession().createQuery("from Producer ").list();
    }

    public Producer findProducerById(int id) {
        return factory.getCurrentSession().find(Producer.class, id);
    }

    public void updateProducer(Producer producer) {
        factory.getCurrentSession().update(producer);
    }

    public void removeProducer(int id) {
        factory.getCurrentSession().createQuery("delete from Producer where producerId = :producerId")
                .setParameter("producerId", id)
                .executeUpdate();
    }
}
