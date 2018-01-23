package org.aparc.productsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producer")
public class Producer {

    @Id
    @Column(name = "producerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producerId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToMany(mappedBy = "producers")
    private Set<Product> products;

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "producerId=" + producerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
