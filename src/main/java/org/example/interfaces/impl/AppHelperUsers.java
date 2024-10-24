package org.example.interfaces.impl;

import org.example.interfaces.Input;
import org.example.interfaces.UserProvider;
import org.example.model.User;

public class AppHelperUsers implements UserProvider {

    @Override
    public User create(Input input) {
        try {
            User user = new User();
            System.out.print("Имя: ");
            user.setFirstname(input.getString());
            System.out.print("Фамилия: ");
            user.setLastname(input.getString());
            System.out.print("Телефон: ");
            user.setPhone(input.getString());
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getList(User[] users) {
        StringBuilder sbUsers = new StringBuilder();
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (user == null) {
                continue;
            }
            sbUsers.append(String.format("%d. %s %s. Телефон: %s%n",
                    i + 1,
                    user.getFirstname(),
                    user.getLastname(),
                    user.getPhone()
            ));
        }
        return sbUsers.toString();
    }
}
