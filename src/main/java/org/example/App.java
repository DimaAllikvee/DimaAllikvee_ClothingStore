package org.example;

import org.example.interfaces.Input;
import org.example.model.Clothes;
import org.example.model.User;
import org.example.services.ClothingService;
import org.example.services.UserService;

public class App {
    public Clothes[] clothes;
    public User[] users;

    private final ClothingService clothingService;
    private final UserService userService;
    private final Input input;

    public App(Input input, ClothingService clothingService, UserService userService) {
        this.users = new User[100];
        this.clothes = new Clothes[100];
        this.clothingService = clothingService;
        this.input = input;
        this.userService = userService;
    }

    public void run() {
        System.out.println("------ Магазин одежды ------");
        System.out.println("--------------------------------------");
        boolean repeat=true;
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить одежду");
            System.out.println("2. Список одежды");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(input.getString());
            switch (task) {
                case 0:
                    repeat=false;
                    break;
                case 1:
                    System.out.println("----- Добавление одежды -----");
                    if(clothingService.add(input, clothes)){
                        System.out.println("Одежда добавлена");
                    }else{
                        System.out.println("Одежду добавить не удолось");
                    }
                    break;
                case 2:
                    System.out.println("----- Список одежды -----");
                    System.out.println(clothingService.printList(clothes));
                    break;
                case 3:
                    System.out.println("----- Добавление покупателя -----");
                    if(userService.add(input, users)){
                        System.out.println("Покупатель добавлен");
                    }else{
                        System.out.println("Покупателя добавить не удалось");
                    }
                    break;
                case 4:
                    System.out.println("----- Список покупателей -----");
                    System.out.println(userService.printList(users));
                    break;
                default:
                    System.out.println("Выберите задачу из списка");
            }
            System.out.println("--------------------------------------");
        } while (repeat);
        System.out.println("До свидания :)");
    }
    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Clothes[] getClothes() {
        return clothes;
    }

    public void setClothes(Clothes[] clothes) {
        this.clothes = clothes;
    }

}
