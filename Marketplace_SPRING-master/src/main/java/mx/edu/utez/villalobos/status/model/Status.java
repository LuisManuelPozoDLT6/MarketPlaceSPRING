package mx.edu.utez.villalobos.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.villalobos.categories.model.Category;
import mx.edu.utez.villalobos.product.model.Product;
import mx.edu.utez.villalobos.subcategories.model.Subcategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String description;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Category> categories;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Subcategory> subcategories;
    @OneToMany (mappedBy = "status")
    @JsonIgnore
    private List <Product> products;

    public Status() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
