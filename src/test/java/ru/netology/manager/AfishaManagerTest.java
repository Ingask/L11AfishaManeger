package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import ru.netology.domain.FilmsAfishaItem;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaManager manager;
    private FilmsAfishaItem item1 = new FilmsAfishaItem(1, "film1", "http://film1", "genre");
    private FilmsAfishaItem item2 = new FilmsAfishaItem(2, "film2", "http://film2", "genre");
    private FilmsAfishaItem item3 = new FilmsAfishaItem(3, "film3", "http://film3", "genre");
    private FilmsAfishaItem item4 = new FilmsAfishaItem(4, "film4", "http://film4", "genre");
    private FilmsAfishaItem item5 = new FilmsAfishaItem(5, "film5", "http://film5", "genre");
    private FilmsAfishaItem item6 = new FilmsAfishaItem(6, "film6", "http://film6", "genre");
    private FilmsAfishaItem item7 = new FilmsAfishaItem(7, "film7", "http://film7", "genre");
    private FilmsAfishaItem item8 = new FilmsAfishaItem(8, "film8", "http://film8", "genre");
    private FilmsAfishaItem item9 = new FilmsAfishaItem(9, "film9", "http://film9", "genre");
    private FilmsAfishaItem item10 = new FilmsAfishaItem(10, "film10", "http://film10", "genre");
    private FilmsAfishaItem item11 = new FilmsAfishaItem(11, "film11", "http://film11", "genre");


    private void showFirst() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
    }

    @Test
    void shouldAdd() {
        manager = new AfishaManager(5);
        showFirst();
        FilmsAfishaItem[] actual = manager.getAllFilms();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastEqualZeroItemsCount() {
        manager = new AfishaManager(0);
        showFirst();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[0];
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastEqualItemsCount() {
        manager = new AfishaManager(11);
        showFirst();
        FilmsAfishaItem[] allItems = manager.getAllFilms();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[allItems.length];
        for (int i = 0; i < allItems.length; i++) {
            expected[i] = allItems[allItems.length - i - 1];
        }
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastLessThenItemsCount() {
        manager = new AfishaManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item5, item4, item3, item2, item1};
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastMoreThenItemsCount() {
        manager = new AfishaManager(2);
        showFirst();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item11, item10};
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
    }


}
