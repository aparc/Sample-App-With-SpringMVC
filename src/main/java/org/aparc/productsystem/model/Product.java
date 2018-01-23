package org.aparc.productsystem.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "weight")
    private double weight;

    @ManyToOne(targetEntity = ProductCategory.class)
    @JoinColumn(name = "categoryId_fk")
    private ProductCategory category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "productAndProducer",
            joinColumns = {@JoinColumn(name = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "producerId")})
    private Set<Producer> producers;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producer> producers) {
        this.producers = producers;
    }
}
