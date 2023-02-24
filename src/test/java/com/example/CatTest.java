package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundTest() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, cat.getFood());
    }

    @Mock
    Cat cat;

    @Test
    public void getFoodTest2() throws Exception {
        cat.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
    }

    @Test
    public void getFoodNullTest2() throws Exception {
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
    public void getFood2MockTest() throws Exception {
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
    public void getSoundHelloMockTest() throws Exception {
        Mockito.when(cat.getSound()).thenReturn("Hello"); // вызвали метод с аргументом
        assertEquals("Hello", cat.getSound());
    }

    @Test
    public void getSound3MockTest() throws Exception {
        cat.getSound();
        cat.getSound();
        cat.getSound();
        Mockito.verify(cat, Mockito.times(3)).getSound();
    }
}