package com.pitrzuu.api.location;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "voivodeships")
public class Voivodeship {
    public Voivodeship() {}
    public Voivodeship(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "voivodeship", orphanRemoval = true)
    private Set<Location> locations = new java.util.LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<Location> getLocations() {
        return locations;
    }

    public Voivodeship setId(Integer id) {
        this.id = id;
        return this;
    }
    public Voivodeship setName(String name) {
        this.name = name;
        return this;
    }
    public Voivodeship setLocations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voivodeship that)) return false;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getLocations(), that.getLocations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocations());
    }
}
