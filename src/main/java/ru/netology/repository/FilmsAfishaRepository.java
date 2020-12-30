package ru.netology.repository;


import ru.netology.domain.FilmsAfishaItem;

public class FilmsAfishaRepository {
    private FilmsAfishaItem[] items = new FilmsAfishaItem[0];

    public FilmsAfishaItem[] findAll(){
        return items;
    }

    public void save(FilmsAfishaItem item){
            int length = items.length + 1;
            FilmsAfishaItem[] tmp = new FilmsAfishaItem[length];
            System.arraycopy(items, 0, tmp, 0, items.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
    }

    public FilmsAfishaItem findById(int id){
        for (FilmsAfishaItem item: items) {
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }

    public void removeById(int id){
        int length = items.length - 1;
        FilmsAfishaItem[] tmp = new FilmsAfishaItem[length];
        int index = 0;
        for (FilmsAfishaItem item: items) {
            if (item.getId() !=id){
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new FilmsAfishaItem[0];
    }


}
