package dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final Map<String, String> dictionary = new HashMap<>();// static чтоб можно было читать map в файл

    public String addElement(String key, String value) {// Добавление элемента
            return dictionary.put(key, value);
    }
    public String outputElement(String key){
        return dictionary.get(key);
    }
    public void deleteElement(String key){
        dictionary.remove(key);
    }
    public void searchElement(String key){
        if(dictionary.containsKey(key))
            System.out.println("Такой элемент есть!");
        else
            System.out.println("Такого элемента нет");
    }
    public void outputAllElements() {
        System.out.println("Все слова выведенны: ");
        System.out.println();
        for (Map.Entry<String, String> pair : dictionary.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("");
    }
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
