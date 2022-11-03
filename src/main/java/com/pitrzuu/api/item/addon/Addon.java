package com.pitrzuu.api.item.addon;

import com.pitrzuu.api.detail.Detail;
import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;

@Table(name = "addons")
@Entity
public class Addon {
    public Addon() {
    }
    public Addon(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Addon(String name, String description, String imagePath, Double price) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addon_id", nullable = false)
    private Long id;

    @Column(name = "addon_name", nullable = false, unique = true, length = 64)
    private String name;

    @Column(name = "addon_description", nullable = false, length = 128)
    private String description;

    @Column(name = "addon_image-path", length = 64)
    private String imagePath;

    @Column(name = "addon_price", nullable = false)
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.CURRENCY)
    private Double price;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "order_id", referencedColumnName = "order_id"),
            @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    })
    private Detail detail;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImagePath() {
        return imagePath;
    }
    public Double getPrice() {
        return price;
    }
    public Detail getDetail() {
        return detail;
    }

    public Addon setName(String name) {
        this.name = name;
        return this;
    }
    public Addon setDescription(String description) {
        this.description = description;
        return this;
    }
    public Addon setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
    public Addon setPrice(Double price) {
        this.price = price;
        return this;
    }
    public Addon setDetail(Detail details) {
        this.detail = details;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Addon addon)) return false;
        return getId().equals(addon.getId()) && getName().equals(addon.getName()) && Objects.equals(getDescription(), addon.getDescription()) && Objects.equals(getImagePath(), addon.getImagePath()) && getPrice().equals(addon.getPrice()) && getDetail().equals(addon.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getImagePath(), getPrice(), getDetail());
    }
}
