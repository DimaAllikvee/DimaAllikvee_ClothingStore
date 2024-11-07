package org.example;

import org.example.apphelpers.UserAppHelper;
import org.example.interfaces.UserProvider;
import org.example.apphelpers.ClothingAppHelper;
import org.example.interfaces.ClothingProvider;
import org.example.apphelpers.ConsoleInput;
import org.example.interfaces.Input;
import org.example.services.ClothingService;
import org.example.services.UserService;

public class ClothingStore {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        ClothingProvider clothingProvider = new ClothingAppHelper();
        ClothingService clothingService = new ClothingService(clothingProvider);
        UserProvider userProvider = new UserAppHelper();
        UserService userService = new UserService(userProvider);
        App app = new App(input, clothingService, userService);
        app.run();
    }
}