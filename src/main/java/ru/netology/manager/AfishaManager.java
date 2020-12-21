package ru.netology.manager;

import ru.netology.domain.FilmsAfishaItem;
import ru.netology.repository.FilmsAfishaRepository;

public class AfishaManager {
    private FilmsAfishaRepository repository;
    private int itemsCount = 10;

    public AfishaManager(FilmsAfishaRepository repository) {
        this.repository=repository;
    }

    public void add(FilmsAfishaItem item) {
        repository.save(item);
    }

    public AfishaManager(FilmsAfishaRepository repository, int itemsCount) {
        this.repository = repository;
        if (itemsCount >= 0) {
            this.itemsCount = itemsCount;
        }
    }

    public FilmsAfishaItem[] getLastItems() {
        FilmsAfishaItem[] items = repository.findAll();
        int count = items.length > itemsCount ? itemsCount : items.length;
        FilmsAfishaItem[] result = new FilmsAfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


    public FilmsAfishaItem[] getAllFilms() {
        return repository.findAll();
    }
}









