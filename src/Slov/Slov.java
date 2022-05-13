package Slov;

import java.util.HashMap;
import java.util.Map;

public class Slov {
    Map<String, String> Slovar = new HashMap<>();

    public Slov() {
    }

    public String dobav(String a, String b) {// Добавление элемента
            return Slovar.put(a, b);
    }
    public String vivod(String a){
        return Slovar.get(a);
    }// вывод заданного элемента
    public String udal(String a){
        return Slovar.remove(a);
    }// Удаление заданного элемента
    public void poisk(String a){// Поиск по ключу
        if(Slovar.containsKey(a))
            System.out.println("Такой элемент есть!");
        else
            System.out.println("Такого элемента нет");
    }
    public void vse_elementi(){// Вывод всех элементов
        System.out.println("Все слова выведенны: ");
        System.out.println();
        for (Map.Entry<String, String> pair : Slovar.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("");
    }
}
