package org.example.model;

import java.util.UUID;
import java.util.Objects;

public class Clothes {
    private UUID id;
    private String name;
    private String type;
    private String size;
    private String color;

    public Clothes() {
        this.id = UUID.randomUUID();
    }

    public Clothes(String name, String type, String size, String color) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return id.equals(clothes.id) &&
                name.equals(clothes.name) &&
                type.equals(clothes.type) &&
                size.equals(clothes.size) &&
                color.equals(clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, size, color);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
