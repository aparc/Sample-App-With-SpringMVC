package org.aparc.productsystem.dao;

import org.aparc.productsystem.model.Producer;

import java.util.List;

public interface ProducerDao {

    void createProducer(Producer producer);

    List<Producer> getAllProducers();

    Producer findProducerById(int id);

    void updateProducer(Producer producer);

    void removeProducer(int id);


}
