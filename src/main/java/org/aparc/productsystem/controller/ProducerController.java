package org.aparc.productsystem.controller;

import org.aparc.productsystem.model.Producer;
import org.aparc.productsystem.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "producers", method = RequestMethod.GET)
    public String listProducers(Model model) {
        model.addAttribute("listProducers", producerService.getAllProducers());
        model.addAttribute("producer", new Producer());
        return "producers";
    }

    @RequestMapping(value = "/producers/add", method = RequestMethod.POST)
    public String addProducer(@ModelAttribute("producer") Producer producer) {
        if(producer.getProducerId() == 0) {
            producerService.createProducer(producer);
        } else {
            producerService.updateProducer(producer);
        }
        return "redirect:/producers";
    }

    @RequestMapping("producers/remove/{id}")
    public String removeProducer(@PathVariable("id") int id) {
        producerService.removeProducer(id);
        return "redirect:/producers";
    }

    @RequestMapping("producers/edit/{id}")
    public String editProducer(@PathVariable("id") int id, Model model) {
        model.addAttribute("producer",producerService.findProducerById(id));
        model.addAttribute("listProducers", producerService.getAllProducers());
        return "producers";
    }
}
