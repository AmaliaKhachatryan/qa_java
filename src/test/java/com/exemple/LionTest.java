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
public class LionTest {


    @Test
    public void getHasManeTrueTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");
        assertEquals(true, lion.getHasMane());
    }

    @Test
    public void getHasManeFalseTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самка");
        assertEquals(false, lion.getHasMane());
    }

    @Test(expected = Exception.class)
    public void getHasManeSexTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Sex");
    }

    @Test
    public void throwsExceptionTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Feline feline = new Feline();
            Lion lion = new Lion(feline, "Sex");
        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = exception.getMessage();
        assertTrue(expected.contains(actual));
    }

    @Test
    public void getKittensMaleTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getKittensFemaleTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самка");
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodMaleTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getFoodFemaleTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самка");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Mock
    Lion lion;

    @Test
    public void getFoodMockTest() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getFood3MockTest() throws Exception {
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
    public void getHasManeMaleMockTest(){
        Mockito.when(lion.getHasMane()).thenReturn(true);
        assertEquals(true, lion.getHasMane());
    }

    @Test
    public void getHasManeFemaleMockTest() throws Exception {
        assertEquals(false, lion.getHasMane());
    }

    @Test(expected = Exception.class)
    public void throwsExceptionMock() throws Exception {
        Mockito.when(lion.getHasMane()).thenThrow
                (new Exception("Используйте допустимые значения пола животного - самец или самка"));

    }
}
