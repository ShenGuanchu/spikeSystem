package cn.spike.po;

import java.math.BigDecimal;

public class Item {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer category;

    private Integer stock;

    private String origin;

    private Double weight;

    private Integer stores;

    private Integer discounttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStores() {
        return stores;
    }

    public void setStores(Integer stores) {
        this.stores = stores;
    }

    public Integer getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(Integer discounttype) {
        this.discounttype = discounttype;
    }
}