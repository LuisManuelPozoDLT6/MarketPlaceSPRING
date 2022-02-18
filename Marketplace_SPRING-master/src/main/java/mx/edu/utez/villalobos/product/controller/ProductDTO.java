package mx.edu.utez.villalobos.product.controller;

import mx.edu.utez.villalobos.status.model.Status;
import mx.edu.utez.villalobos.subcategories.model.Subcategory;

import java.util.List;

public class ProductDTO {
    private long id;
    private String name;
    private String descrition;
    private double price;
    private int quantity;
    private String brand;
    private Status status;
    private Subcategory subcategory;
    private List<ProductImageDTO> images;



    public ProductDTO() {
    }

    public ProductDTO(String name, String descrition, double price, int quantity, String brand, Status status, Subcategory subcategory, List<ProductImageDTO> images) {
        this.name = name;
        this.descrition = descrition;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.status = status;
        this.subcategory = subcategory;
        this.images = images;
    }

    public ProductDTO(long id, String name, String descrition, double price, int quantity, String brand, Status status, Subcategory subcategory, List<ProductImageDTO> images) {
        this.id = id;
        this.name = name;
        this.descrition = descrition;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.status = status;
        this.subcategory = subcategory;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDTO> images) {
        this.images = images;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

}


