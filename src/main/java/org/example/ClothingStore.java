package org.example;

import org.example.interfaces.impl.AppHelperUsers;
import org.example.interfaces.UserProvider;
import org.example.interfaces.impl.AppHelperClothing;
import org.example.interfaces.ClothingProvider;
import org.example.interfaces.impl.ConsoleInput;
import org.example.interfaces.Input;
import org.example.services.ClothingService;
import org.example.services.UserService;

public class ClothingStore {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        ClothingProvider clothingProvider = new AppHelperClothing();
        ClothingService clothingService = new ClothingService(clothingProvider);
        UserProvider userProvider = new AppHelperUsers();
        UserService userService = new UserService(userProvider);
        App app = new App(input, clothingService, userService);
        app.run();
    }
}