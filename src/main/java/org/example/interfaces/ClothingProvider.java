package org.example.interfaces;

import org.example.model.Clothes;

public interface ClothingProvider {
    Clothes create(Input input);
    String getList(Clothes[] clothes);
}
