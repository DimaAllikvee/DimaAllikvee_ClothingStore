package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private Clothes clothes;
    private Customer customer;
    private LocalDate orderDate;


    public Order(Clothes clothes, Customer customer, LocalDate orderDate) {
        this.clothes = clothes;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public Order() {

    }


    // Геттеры и сеттеры
    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
