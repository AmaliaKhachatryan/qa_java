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
public class AlexTest {

    @Test
    public void getFriendsTest() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLiving() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }

    public AlexTest() throws Exception {
    }

    @Spy
    Alex alexSpy = new Alex(null);

    @Test
    public void getFriendsSpyTest() throws Exception {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alexSpy.getFriends());
    }
    @Test
    public void getPlaceOfLivingSpyTest() throws Exception {
        assertEquals("Нью-Йоркский зоопарк", alexSpy.getPlaceOfLiving());
    }

    @Test
    public void getKittensSpyTest() throws Exception {
        assertEquals(0, alex.getKittens());
    }

    @Mock
    Alex alex;

    @Test
    public void getFriends2MockTest() {
        alex.getFriends();
        alex.getFriends();
        Mockito.verify(alex, Mockito.times(2)).getFriends();
    }

    @Test
    public void getFriendsNullMockTest() {
        assertEquals(List.of(), alex.getFriends());
    }

    @Test
    public void getFriendAnyTextMockTest() {
        Mockito.when(alex.getFriends()).thenReturn(List.of("One", "Two"));
        assertEquals(List.of("One", "Two"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingNullMockTest() {
        assertEquals(null, alex.getPlaceOfLiving());
    }

    @Test
    public void getPlaceOfLivingAnyTextMockTest() {
        Mockito.when(alex.getPlaceOfLiving()).thenReturn("Home");
        assertEquals("Home", alex.getPlaceOfLiving());
    }

    @Test
    public void getPlaceOfLiving2MockTest() {
        alex.getPlaceOfLiving();
        alex.getPlaceOfLiving();
        Mockito.verify(alex, Mockito.times(2)).getPlaceOfLiving();
    }

    @Test
    public void getKittensMockTest() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void getKittensTwoMockTest() {
        Mockito.when(alex.getKittens()).thenReturn(5);
        assertEquals(5, alex.getKittens());
    }
}