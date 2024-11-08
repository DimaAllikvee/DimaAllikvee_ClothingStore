package org.example.main;

import org.example.apphelpers.ClothingAppHelper;
import org.example.apphelpers.CustomerAppHelper;
import org.example.apphelpers.OrderAppHelper;
import org.example.interfaces.AppHelper;
import org.example.interfaces.FileRepository;
import org.example.interfaces.Service;
import org.example.model.Clothes;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.services.ClothingService;
import org.example.services.CustomerService;
import org.example.services.OrderService;
import org.example.storage.Storage;
import org.example.App;

public class Main {

    public static void main(String[] args) {


        AppHelper<Clothes> clothingAppHelper = new ClothingAppHelper();
        AppHelper<Customer> customerAppHelper = new CustomerAppHelper();


        FileRepository<Clothes> clothingStorage = new Storage<>();
        FileRepository<Customer> customerStorage = new Storage<>();
        FileRepository<Order> orderStorage = new Storage<>();


        Service<Clothes> clothingService = new ClothingService(clothingAppHelper, clothingStorage);
        Service<Customer> customerService = new CustomerService(customerAppHelper, customerStorage);


        AppHelper<Order> orderAppHelper = new OrderAppHelper(clothingService, customerService);

        Service<Order> orderService = new OrderService(orderAppHelper, clothingService, customerService, orderStorage);


        App app = new App(clothingService, customerService, orderService);
        app.run();
    }
}
