package org.aparc.productsystem.controller;

import org.aparc.productsystem.model.productcategory.ProductCategory;
import org.aparc.productsystem.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    public void setCategoryService(ProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(name = "categories", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("category", new ProductCategory());
        model.addAttribute("listCategories", categoryService.getAllCategories());
        return "categories";
    }

    @RequestMapping(name = "/categories/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") ProductCategory category) {
        if(category.getCategoryId() == 0) {
            categoryService.createCategory(category);
        } else {
            categoryService.update(category);
        }
        return "redirect:/categories";
    }

    @RequestMapping("categories/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("listCategories", categoryService.getAllCategories());
        return "categories";
    }

    @RequestMapping(name = "/remove/{id}")
    public String removeCategory(@PathVariable("id") int id) {
        categoryService.remove(id);
        return "redirect:/categories";
    }

}
