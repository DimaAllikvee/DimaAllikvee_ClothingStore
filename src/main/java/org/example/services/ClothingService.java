package org.example.services;

import org.example.interfaces.ClothingProvider;
import org.example.interfaces.Input;
import org.example.model.Clothes;

public class ClothingService {

    private final ClothingProvider clothingProvider;

    public ClothingService(ClothingProvider clothingProvider) {
        this.clothingProvider = clothingProvider;
    }

    public boolean add(Input input, Clothes[] clothesArray) {
        try {
            Clothes clothes = clothingProvider.create(input);
            if (clothes == null) return false;
            for (int i = 0; i < clothesArray.length; i++) {
                if (clothesArray[i] == null) {
                    clothesArray[i] = clothes;
                    System.out.println("Одежда добавлена");
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String printList(Clothes[] clothes) {return clothingProvider.getList(clothes);}
}
