package org.aparc.productsystem.service;

import org.aparc.productsystem.dao.ProducerDao;
import org.aparc.productsystem.model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerDao producerDao;

    @Transactional
    public void createProducer(Producer producer) {
        producerDao.createProducer(producer);
    }

    @Transactional
    public List<Producer> getAllProducers() {
        return producerDao.getAllProducers();
    }

    @Transactional
    public Producer findProducerById(int id) {
        return producerDao.findProducerById(id);
    }

    @Transactional
    public void updateProducer(Producer producer) {
        producerDao.updateProducer(producer);
    }

    @Transactional
    public void removeProducer(int id) {
        producerDao.removeProducer(id);
    }
}
