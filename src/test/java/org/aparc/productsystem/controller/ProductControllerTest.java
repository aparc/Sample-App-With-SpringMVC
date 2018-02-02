package org.aparc.productsystem.controller;

import org.aparc.productsystem.model.Product;
import org.aparc.productsystem.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/spring_config.xml")
public class ProductControllerTest {

    private ProductService productService = mock(ProductService.class);

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).dispatchOptions(true).setViewResolvers(viewResolver).build();
    }

    @Test
    public void listProductsTest() throws Exception {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product());
        productList.add(new Product());

        Mockito.when(productService.getAll()).thenReturn((List)productList);

        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("product", notNullValue()))
                .andExpect(view().name("products"))
                .andExpect(model().attribute("listProducts",hasSize(2)));
    }

    @Test
    public void addProductTest_updateProduct() throws Exception {
        Product product = new Product();
        product.setProductId(23);

        mockMvc.perform(post("/products/add")
                .param("productId", "2")
                .flashAttr("product", new Product()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

//        verify(productService).createProduct(Matchers.any(Product.class));
        verify(productService).update(Matchers.any(Product.class));
    }
}

