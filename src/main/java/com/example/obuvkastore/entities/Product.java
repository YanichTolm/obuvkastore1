package com.example.obuvkastore.entities;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producer", nullable = false)
    private Producer producer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Column(name = "name_of_product")
    private String nameProduct;
    private Float price;
    private boolean male_female;
    private String sizes;

    //TODO
    private byte[] image;

    public Product(Producer producer, Category category, String nameProduct, Float price, boolean male_female, String sizes, byte[] image) {
        this.producer = producer;
        this.category = category;
        this.nameProduct = nameProduct;
        this.price = price;
        this.male_female = male_female;
        this.sizes = sizes;
        this.image = image;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public boolean isMale_female() {
        return male_female;
    }

    public void setMale_female(boolean male_female) {
        this.male_female = male_female;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
