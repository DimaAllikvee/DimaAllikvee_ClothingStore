package org.example.apphelpers;

import org.example.interfaces.ClothingProvider;
import org.example.interfaces.Input;
import org.example.model.Clothes;

public class ClothingAppHelper implements ClothingProvider {

    @Override
    public Clothes create(Input input) {
        Clothes clothes = new Clothes();
        System.out.print("Название одежды: ");
        clothes.setName(input.getString());
        System.out.print("Тип одежды (например, куртка, футболка): ");
        clothes.setType(input.getString());
        System.out.print("Размер одежды: ");
        clothes.setSize(input.getString());
        System.out.print("Цвет одежды: ");
        clothes.setColor(input.getString());
        return clothes;
    }

    @Override
    public String getList(Clothes[] clothesArray) {
        StringBuilder sbClothes = new StringBuilder();
        for (int i = 0; i < clothesArray.length; i++) {
            Clothes clothes = clothesArray[i];
            if (clothes == null) {
                continue;
            }
            sbClothes.append(String.format("%d. Название: %s. Тип: %s. Размер: %s. Цвет: %s%n",
                    i + 1,
                    clothes.getName(),
                    clothes.getType(),
                    clothes.getSize(),
                    clothes.getColor()
            ));
        }
        return sbClothes.toString();
    }
}
