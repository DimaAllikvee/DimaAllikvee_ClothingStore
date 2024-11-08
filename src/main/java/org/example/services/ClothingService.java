package org.example.services;



import org.example.interfaces.AppHelper;
import org.example.interfaces.FileRepository;
import org.example.interfaces.Service;
import org.example.model.Clothes;

import java.util.List;

public class ClothingService implements Service<Clothes> {

    private final AppHelper<Clothes> clothingAppHelper;
    private final FileRepository<Clothes> storage;
    private final String fileName = "clothes.dat";

    public ClothingService(AppHelper<Clothes> clothingAppHelper, FileRepository<Clothes> storage) {
        this.clothingAppHelper = clothingAppHelper;
        this.storage = storage;
    }

    /**
     * Метод для добавления одежды.
     */
    @Override
    public boolean add() {
        Clothes clothes = clothingAppHelper.create();
        if (clothes != null) {
            storage.save(clothes, fileName);
            System.out.println("Одежда успешно добавлена.");
            return true;
        }
        System.out.println("Ошибка при добавлении одежды.");
        return false;
    }

    /**
     * Метод для редактирования одежды.
     */
    @Override
    public boolean edit(Clothes clothes) {
        List<Clothes> clothesList = storage.load(fileName);
        for (int i = 0; i < clothesList.size(); i++) {
            if (clothesList.get(i).getName().equals(clothes.getName())) {
                System.out.println("Введите новые данные для одежды:");
                Clothes updatedClothes = clothingAppHelper.create();
                if (updatedClothes != null) {
                    clothesList.set(i, updatedClothes);
                    storage.saveAll(clothesList, fileName);
                    System.out.println("Одежда успешно обновлена.");
                    return true;
                }
                System.out.println("Ошибка при создании новой одежды.");
                return false;
            }
        }
        System.out.println("Одежда не найдена.");
        return false;
    }

    /**
     * Метод для удаления одежды.
     */
    @Override
    public boolean remove(Clothes clothes) {
        List<Clothes> clothesList = storage.load(fileName);
        boolean removed = clothesList.removeIf(c -> c.getName().equals(clothes.getName()));
        if (removed) {
            storage.saveAll(clothesList, fileName);
            System.out.println("Одежда успешно удалена.");
            return true;
        }
        System.out.println("Одежда не найдена для удаления.");
        return false;
    }

    /**
     * Метод для отображения списка одежды.
     */
    @Override
    public boolean print() {
        List<Clothes> clothesList = this.list();
        if (clothesList.isEmpty()) {
            System.out.println("Список одежды пуст.");
            return false;
        }

        System.out.println("----- Список одежды -----");
        return clothingAppHelper.printList(clothesList);
    }

    /**
     * Метод для загрузки списка одежды из файла.
     */
    @Override
    public List<Clothes> list() {
        List<Clothes> clothesList = storage.load(fileName);
        if (clothesList == null) {
            System.out.println("Ошибка при загрузке списка одежды.");
            return List.of();
        }
        return clothesList;
    }
}
