package org.aparc.productsystem.model;


import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq_gen")
    @SequenceGenerator(name = "product_id_seq_gen", sequenceName = "product_id_seq")
    private int productId;

    @Column(name = "NAME")
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Column(name = "WEIGHT")
    private double weight;

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
}
