package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import ru.netology.domain.FilmsAfishaItem;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.repository.FilmsAfishaRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
    private FilmsAfishaRepository repository;

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


    @Test
    void shouldAdd() {
        doNothing().when(repository).save(any(FilmsAfishaItem.class));
        manager = new AfishaManager(repository);
        manager.add(item1);
        manager.add(item2);
        verify(repository, times(1)).save(item2);
        verify(repository, times(1)).save(item1);
    }

    @Test
    void shouldShowLastEqualZeroItemsCount() {
        FilmsAfishaItem[] mockCover = new FilmsAfishaItem[]{item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11};
        doReturn(mockCover).when(repository).findAll();
        manager = new AfishaManager(repository, 0);
        FilmsAfishaItem[] expected = new FilmsAfishaItem[0];
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastEqualItemsCount() {
        FilmsAfishaItem[] mockCover = new FilmsAfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();
        manager = new AfishaManager(repository, 5);
        FilmsAfishaItem[] allItems = manager.getAllFilms();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[allItems.length];
        for (int i = 0; i < allItems.length; i++) {
            expected[i] = allItems[allItems.length - i - 1];
        }
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
        verify(repository, times(2)).findAll();
    }

    @Test
    void shouldShowLastLessThenItemsCount() {
        FilmsAfishaItem[] mockCover = new FilmsAfishaItem[]{item1, item2, item3};
        doReturn(mockCover).when(repository).findAll();
        manager = new AfishaManager(repository);
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item3, item2, item1};
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldShowLastMoreThenItemsCount() {
        FilmsAfishaItem[] mockCover = new FilmsAfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();
        manager = new AfishaManager(repository, 4);
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item5, item4, item3, item2};
        FilmsAfishaItem[] actual = manager.getLastItems();
        assertArrayEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }


}
