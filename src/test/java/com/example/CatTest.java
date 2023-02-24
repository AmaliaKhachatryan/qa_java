package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundTest() {
        com.example.Feline feline = new com.example.Feline();
        com.example.Cat cat = new com.example.Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        com.example.Feline feline = new Feline();
        com.example.Cat cat = new com.example.Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, cat.getFood());
    }

    @Mock
    Cat cat;

    @Test
    public void getFoodMockTest() throws Exception {
        cat.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
    }

    @Test
    public void getFoodNullTest() throws Exception {
        assertEquals(List.of(), cat.getFood());
    }

    @Test
    public void getSoundTestMock() throws Exception {
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, cat.getFood());
    }

    @Test
    public void getFoodAnyTextMockTest() throws Exception {
        Mockito.when(cat.getFood()).thenReturn(List.of("Food"));
        assertEquals(List.of("Food"), cat.getFood());

    }

    @Test
    public void getFoodsAmountMockTest() throws Exception {
        cat.getFood();
        cat.getFood();
        Mockito.verify(cat, Mockito.times(2)).getFood();
    }

    @Test
    public void getSoundMockTest() throws Exception {
        Mockito.when(cat.getSound()).thenReturn("Мяу"); // вызвали метод с аргументом
        assertEquals("Мяу", cat.getSound());

    }

    @Test
    public void getSoundNullMockTest() throws Exception {
        assertEquals(null, cat.getSound());

    }

    @Test
    public void getSoundHelloTest() throws Exception {
        Mockito.when(cat.getSound()).thenReturn("Hello"); // вызвали метод с аргументом
        assertEquals("Hello", cat.getSound());
    }

    @Test
    public void getSoundAmountMockTest() throws Exception {
        cat.getSound();
        cat.getSound();
        cat.getSound();
        Mockito.verify(cat, Mockito.times(3)).getSound();
    }
}