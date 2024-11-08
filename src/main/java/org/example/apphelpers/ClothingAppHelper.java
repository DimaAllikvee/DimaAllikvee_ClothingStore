package org.example.apphelpers;


import org.example.interfaces.AppHelper;
import org.example.interfaces.Input;
import org.example.model.Clothes;

import java.util.List;

public class ClothingAppHelper implements AppHelper<Clothes>, Input {

    /**
     * Метод для создания нового объекта одежды.
     */
    @Override
    public Clothes create() {
        try {
            System.out.print("Введите название одежды: ");
            String name = getString();
            System.out.print("Введите тип одежды (например, футболка, куртка): ");
            String type = getString();
            System.out.print("Введите размер одежды (например, S, M, L, XL): ");
            String size = getString();
            System.out.print("Введите цвет одежды: ");
            String color = getString();
            System.out.print("Введите цену одежды: ");
            double price = Double.parseDouble(getString());

            // Создаем и возвращаем объект Clothes
            return new Clothes(name, type, size, color, price);
        } catch (Exception e) {
            System.out.println("Ошибка при создании одежды: " + e.getMessage());
            return null;
        }
    }

    /**
     * Метод для отображения списка одежды.
     */
    @Override
    public boolean printList(List<Clothes> clothesList) {
        if (clothesList == null || clothesList.isEmpty()) {
            System.out.println("Список одежды пуст.");
            return false;
        }

        System.out.println("----- Список одежды -----");
        for (int i = 0; i < clothesList.size(); i++) {
            Clothes clothes = clothesList.get(i);
            System.out.printf("%d. Название: %s, Тип: %s, Размер: %s, Цвет: %s, Цена: $%.2f%n",
                    i + 1,
                    clothes.getName(),
                    clothes.getType(),
                    clothes.getSize(),
                    clothes.getColor(),
                    clothes.getPrice());
        }
        return true;
    }
}
