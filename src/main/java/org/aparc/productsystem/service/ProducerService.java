package org.aparc.productsystem.service;

import org.aparc.productsystem.model.Producer;

import java.util.List;

public interface ProducerService {

    void createProducer(Producer producer);

    List<Producer> getAllProducers();

    Producer findProducerById(int id);

    void updateProducer(Producer producer);

    void removeProducer(int id);
}
