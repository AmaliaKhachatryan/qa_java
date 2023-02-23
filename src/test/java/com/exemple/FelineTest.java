package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void getKittensOneTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    int kittensCount;

    public FelineTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{{-2}, {15}, {0}, {8}};
    }

    @Test
    public void getKittensTest() {
        Feline feline1 = new Feline();
        int expected = kittensCount;
        assertEquals(expected, feline1.getKittens(kittensCount));
    }
}

