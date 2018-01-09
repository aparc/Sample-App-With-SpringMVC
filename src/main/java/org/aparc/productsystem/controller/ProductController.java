package org.aparc.productsystem.controller;

import org.aparc.productsystem.model.Product;
import org.aparc.productsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
//    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAll());

        return "products";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if(product.getProductId() == 0) {
            productService.createProduct(product);
        } else {
            productService.update(product);
        }

        return "redirect:/products";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id) {
        productService.remove(id);

        return "redirect:/products";
    }

    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("listProducts", productService.getAll());

        return "products";
    }

}
