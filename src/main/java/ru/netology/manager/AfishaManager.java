package ru.netology.manager;

import ru.netology.domain.FilmsAfishaItem;

public class AfishaManager {
    private FilmsAfishaItem[] items = new FilmsAfishaItem[0];
    private int itemsCount = 10;

    public AfishaManager() {
    }

    public void add(FilmsAfishaItem item) {
        int length = items.length + 1;
        FilmsAfishaItem[] tmp = new FilmsAfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaManager(int itemsCount) {
        if (itemsCount >= 0) {
            this.itemsCount = itemsCount;
        }
    }

    public FilmsAfishaItem[] getLastItems() {

        int count = items.length > itemsCount ? itemsCount : items.length;
        FilmsAfishaItem[] result = new FilmsAfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public FilmsAfishaItem[] getAllFilms() {
        return items;
    }
}









