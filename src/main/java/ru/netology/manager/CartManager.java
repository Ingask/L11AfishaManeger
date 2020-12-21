package ru.netology.manager;
import ru.netology.domain.PurchaseItem;
//import ru.netology.ru.netology.repository.CartRepository;
//import static org.junit.jupiter.api.Assertions.*;

public class CartManager {
    //    public CartManager(CartRepository repository) {this.repository = repository};
    private PurchaseItem[] items = new PurchaseItem[0];
    //int length = items.length + 1;  //массив размером больше на 1
    //PurchaseItem[] tmp = new PurchaseItem[length];
//tar+tab
    //поэлементно копируем
    //for (int i=0; i<items.length; i++){
    // tmp[i] = items[i];
    // }

    public void add(PurchaseItem item) {

        //   repository.save(item);}
        int length = items.length + 1;  //массив размером больше на 1
        PurchaseItem[] tmp = new PurchaseItem[length];
//tar+tab
        //поэлементно копируем
        //перебор элементов массива. выполнение блока кодаБ пока условие тру
        //инициализируется переменная i (счетчик цикла), проверяется  в i<items.length (тру - идем дальше, фалс - заканчиваем)
        //for (int i=0; i<items.length; i++){
        // tmp[i] = items[i];
        // }
        //native - реализация кода написана не на джаве
        System.arraycopy(items, 0, tmp, 0, items.length);
        //носим последний элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

        //repository.save(item);
    }

    public PurchaseItem[] getAll() {
        //   PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[items.length];
        //перебираем массив в прямом порядке, но кладем результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = result.length - 1 - i;
            result[i] = items[index];
        }
        return result;
    }

    //наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        //меняем наши элементы
        //repository.removeById(id);
        items = tmp;
    }
}


