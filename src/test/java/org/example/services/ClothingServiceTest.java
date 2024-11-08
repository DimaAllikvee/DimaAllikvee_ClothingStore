package org.example.services;

import org.example.interfaces.Input;
import org.example.model.Clothes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClothingServiceTest {

    private ClothingService clothingService;
    private ClothingProvider clothingProviderMock;
    private Input inputMock;
    private Clothes[] clothesArray;

    @BeforeEach
    void setUp() {
        clothingProviderMock = mock(ClothingProvider.class);
        inputMock = mock(Input.class);
        clothingService = new ClothingService(clothingProviderMock);
        clothesArray = new Clothes[10];
    }
    //Zara, куртка, L, черный
    @Test
    void testAddClothingSuccessfully() {
        Clothes clothes = new Clothes("Zara", "Куртка", "L", "Черный");
        when(clothingProviderMock.create(inputMock)).thenReturn(clothes);

        boolean result = clothingService.add(inputMock, clothesArray);

        assertTrue(result);
        assertEquals(clothes, clothesArray[0]);
        verify(clothingProviderMock, times(1)).create(inputMock);
    }

    @Test
    void testEditClothingSuccessfully() {
        Clothes oldClothes = new Clothes("Zara", "Куртка", "L", "Черный");
        Clothes newClothes = new Clothes("NEW", "NEW", "NEW", "NEW");
        clothesArray[1] = oldClothes;

        when(inputMock.getInt()).thenReturn(1);
        when(clothingProviderMock.create(inputMock)).thenReturn(newClothes);

        boolean result = clothingService.editClothing(inputMock, clothesArray);

        assertTrue(result);
        assertEquals(newClothes, clothesArray[1]);
        verify(clothingProviderMock, times(1)).create(inputMock);
    }

    @Test
    void testEditClothingInvalidIndex() {
        when(inputMock.getInt()).thenReturn(-1);

        boolean result = clothingService.editClothing(inputMock, clothesArray);

        assertFalse(result);
        verify(clothingProviderMock, never()).create(inputMock);
    }

    @Test
    void testDeleteClothingSuccessfully() {
        Clothes clothes = new Clothes("Zara", "Куртка", "L", "Черный");
        clothesArray[2] = clothes;

        when(inputMock.getInt()).thenReturn(2);

        boolean result = clothingService.deleteClothing(inputMock, clothesArray);

        assertTrue(result);
        assertNull(clothesArray[2]);
    }

    @Test
    void testDeleteClothingInvalidIndex() {
        when(inputMock.getInt()).thenReturn(10);

        boolean result = clothingService.deleteClothing(inputMock, clothesArray);

        assertFalse(result);
    }

    @Test
    void testDeleteClothingEmptyArray() {
        when(inputMock.getInt()).thenReturn(0);

        boolean result = clothingService.deleteClothing(inputMock, clothesArray);

        assertFalse(result);
    }
}



