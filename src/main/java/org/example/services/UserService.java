package org.example.services;

import org.example.interfaces.Input;
import org.example.interfaces.UserProvider;
import org.example.model.User;

public class UserService {

    private final UserProvider userProvider;

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public boolean add(Input input, User[] users) {
        try {
            User user = userProvider.create(input);
            if (user == null) return false;
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    System.out.println("Пользователь добавлен");
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String printList(User[] users) {
        return userProvider.getList(users);
    }
}
