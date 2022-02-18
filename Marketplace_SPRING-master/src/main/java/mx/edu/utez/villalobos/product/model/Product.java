package mx.edu.utez.villalobos.product.model;

import mx.edu.utez.villalobos.status.model.Status;
import mx.edu.utez.villalobos.subcategories.model.Subcategory;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

}
