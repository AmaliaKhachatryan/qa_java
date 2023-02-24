package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class FelineTest {
    public static class felineUnitTest {
        @Test
        public void eatMeatTest() throws Exception {
            com.example.Feline feline = new com.example.Feline();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, feline.eatMeat());
        }

        @Test
        public void getFamilyTest() {
            com.example.Feline feline = new com.example.Feline();
            String expected = "Кошачьи";
            assertEquals(expected, feline.getFamily());
        }

        @Test
        public void getKittensOneTest() {
            com.example.Feline feline = new com.example.Feline();
            assertEquals(1, feline.getKittens());
        }
    }
    @RunWith(MockitoJUnitRunner.class)
    public static class FelineSingleTest {
        @Spy
        com.example.Feline feline;

        @Test
        public void eatMeatSpyTest() throws Exception {
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, feline.eatMeat());
        }

        @Test
        public void getFamilySpyTest() {
            String expected = "Кошачьи";
            assertEquals(expected, feline.getFamily());
        }

        @Test
        public void getKittensOneSpyTest() {
            assertEquals(1, feline.getKittens());

        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedTest {
        int kittensCount;
        int expected;

        @Before
        public void SetUp() {
            MockitoAnnotations.openMocks(this);

        }

        public ParameterizedTest(int kittensCount, int expected) {
            this.kittensCount = kittensCount;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getParameters() {
            return new Object[][]{{-2, -2}, {15, 15}, {0, 0}, {8, 8}};
        }

        @Test
        public void getKittensTest() {
            com.example.Feline feline = new Feline();
            assertEquals(expected, feline.getKittens(kittensCount));
        }
    }
}

