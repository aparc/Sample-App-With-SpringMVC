//package org.aparc.productsystem.controller;
//
//import org.aparc.productsystem.model.Product;
//import org.aparc.productsystem.service.ProductService;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//public class ProductControllerTest {
//
//    @Mock
//    private ProductService productService;
//
//    @InjectMocks
//    private ProductController productController;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @Test
//    public void listProductsTest() throws Exception {
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Product());
//        productList.add(new Product());
//
//        Mockito.when(productService.getAll()).thenReturn(productList);
//
//        mockMvc.perform(get("products"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("products"))
//                .andExpect(model().attribute("listProducts",hasSize(2)));
//    }
//}
