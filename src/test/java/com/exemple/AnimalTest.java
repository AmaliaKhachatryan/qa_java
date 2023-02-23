package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Test
    public void getGrassFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test
    public void getMeatFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void getFamily() throws Exception {
        Animal animal = new Animal();
        animal.getFood("X");
    }

    @Test
    public void throwsExceptionTextTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("X");
        });
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = exception.getMessage();
        assertTrue(expected.contains(actual));
    }

    @Test
    public void getFamilyTest() throws Exception {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
@Spy
Animal animal;

    @Test
    public void getGrassFoodSpyTest() throws Exception {
        animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected,animal.getFood("Травоядное") );
    }
    @Test
    public void getMeatFoodSpyTest() throws Exception {
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
    @Test
    public void getFamilySpyTest() throws Exception {
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}