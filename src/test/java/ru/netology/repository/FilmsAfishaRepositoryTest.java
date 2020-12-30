package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.domain.FilmsAfishaItem;
import ru.netology.manager.AfishaManager;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class FilmsAfishaRepositoryTest {
    private FilmsAfishaRepository repository = new FilmsAfishaRepository();

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


    @BeforeEach
    public void shouldSetUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
        repository.save(item9);
        repository.save(item10);
        repository.save(item11);
    }

    @Test
    void shouldSaveAndFindAllTest(){
        FilmsAfishaItem[] actual = repository.findAll();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldFindByIdFoundTest(){
        FilmsAfishaItem actual = repository.findById(8);
        FilmsAfishaItem expected = item8;
        assertEquals(expected,actual);
    }

    @Test
    void shouldFindByIdNotFoundTest() {
        FilmsAfishaItem actual = repository.findById(15);
        assertNull(actual);
    }

    @Test
    void shouldRemoveByIdTest(){
        repository.removeById(7);
        FilmsAfishaItem[] actual = repository.findAll();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[]{item1,item2,item3,item4,item5,item6,item8,item9,item10,item11};
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveAll(){
        repository.removeAll();
        FilmsAfishaItem[] actual = repository.findAll();
        FilmsAfishaItem[] expected = new FilmsAfishaItem[0];
        assertArrayEquals(expected,actual);
    }

}
