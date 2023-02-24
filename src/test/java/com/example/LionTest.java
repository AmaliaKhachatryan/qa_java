package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class LionTest {

    public static class lionThrowExceptionTest {
        @Test(expected = Exception.class)
        public void getHasManeSexTest() throws Exception {
            com.example.Feline feline = new com.example.Feline();
            com.example.Lion lion = new com.example.Lion(feline, "Sex");
        }

        @Test
        public void throwsExceptionTest() throws Exception {
            Exception exception = assertThrows(Exception.class, () -> {
                com.example.Feline feline = new com.example.Feline();
                com.example.Lion lion = new com.example.Lion(feline, "Sex");
            });
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            String actual = exception.getMessage();
            assertTrue(expected.contains(actual));
        }
    }
    @RunWith(Parameterized.class)
    public static class LoinTestParameterized {
        String sex;
        boolean hashMane;
        List<String> listOfFood;
        int kittens;
        @Before
        public void SetUp() {
            MockitoAnnotations.openMocks(this);

        }
        public LoinTestParameterized(String sex, boolean hashMane,List<String> listOfFood,int kittens) {
            this.sex = sex;
            this.hashMane = hashMane;
            this.listOfFood =listOfFood;
            this.kittens=kittens;
        }
        @Parameterized.Parameters
        public static Object[][] getParameters() {
            return new Object[][]{{"Самец",true,List.of("Животные", "Птицы", "Рыба"),1},
                    {"Самка",false,List.of("Животные", "Птицы", "Рыба"),1}};
        }
        @Test
        public void LoinParameterizedTest() throws Exception {
            com.example.Feline feline = new Feline();
            com.example.Lion lion = new com.example.Lion(feline, sex);
            assertEquals(hashMane, lion.getHasMane());
            assertEquals(listOfFood,lion.getFood());
            assertEquals(kittens,lion.getKittens());
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LoinTestMock {
        @Mock
        Lion lion;

        @Test
        public void getFoodMockTest() throws Exception {
            Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        }

        @Test
        public void getFoodCountMockTest() throws Exception {
            lion.getFood();
            lion.getFood();
            lion.getFood();
            Mockito.verify(lion, Mockito.times(3)).getFood();
        }

        @Test
        public void getKittensFeMaleTestMock() {
            assertEquals(0, lion.getKittens());
        }

        @Test
        public void getHasManeMaleMockTest() {
            Mockito.when(lion.getHasMane()).thenReturn(true);
            assertEquals(true, lion.getHasMane());
        }

        @Test
        public void getHasManeFemaleMockTest() throws Exception {
            assertEquals(false, lion.getHasMane());
        }

        @Test(expected = Exception.class)
        public void throwExceptionMock() throws Exception {
            Mockito.when(lion.getHasMane()).thenThrow
                    (new Exception("Используйте допустимые значения пола животного - самец или самка"));

        }
    }
}
