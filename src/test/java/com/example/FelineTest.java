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

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class FelineTest {
    public static class felineUnitTest {
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
    }
    @RunWith(MockitoJUnitRunner.class)
    public static class FelineSingleTest {
        @Spy
        Feline feline;

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
    public static class ParametrizedTest {
        int kittensCount;
        int expected;

        @Before
        public void SetUp() {
            MockitoAnnotations.openMocks(this);

        }

        public ParametrizedTest(int kittensCount, int expected) {
            this.kittensCount = kittensCount;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getParameters() {
            return new Object[][]{{-2, -2}, {15, 15}, {0, 0}, {8, 8}};
        }

        @Test
        public void getKittensTest() {
            Feline feline = new Feline();
            assertEquals(expected, feline.getKittens(kittensCount));
        }
    }
}

