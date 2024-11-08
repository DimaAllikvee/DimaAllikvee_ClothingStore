package org.example.services;


import org.example.interfaces.AppHelper;
import org.example.interfaces.FileRepository;
import org.example.interfaces.Service;
import org.example.model.Clothes;
import org.example.model.Customer;
import org.example.model.Order;

import java.util.List;

public class OrderService implements Service<Order> {

    private final AppHelper<Order> orderAppHelper;
    private final Service<Clothes> clothingService;
    private final Service<Customer> customerService;
    private final FileRepository<Order> storage;
    private final String fileName = "orders.dat";

    public OrderService(AppHelper<Order> orderAppHelper, Service<Clothes> clothingService, Service<Customer> customerService, FileRepository<Order> storage) {
        this.orderAppHelper = orderAppHelper;
        this.clothingService = clothingService;
        this.customerService = customerService;
        this.storage = storage;
    }

    /**
     * Метод для добавления заказа.
     */
    @Override
    public boolean add() {
        // Создаем новый заказ через AppHelper
        Order order = orderAppHelper.create();
        if (order != null) {
            storage.save(order, fileName);
            System.out.println("Заказ успешно добавлен.");
            return true;
        }
        System.out.println("Ошибка при создании заказа.");
        return false;
    }

    @Override
    public boolean edit(Order order) {
        return false;
    }

    @Override
    public boolean remove(Order order) {
        return false;
    }

    @Override
    public boolean print() {
        return orderAppHelper.printList(this.list());
    }

    @Override
    public List<Order> list() {
        return storage.load(fileName);
    }
}