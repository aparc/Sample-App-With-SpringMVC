package org.aparc.productsystem.model.productcategory;


import org.aparc.productsystem.model.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "productCategory")
public class ProductCategory {

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "category",
            targetEntity = Product.class,
            fetch = FetchType.LAZY
    )
    private Set<Product> products;

        public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
