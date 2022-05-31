package dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static Map<String, String> Dictionary = new HashMap<>();

    public String add(String a, String b) {// Добавление элемента
            return Dictionary.put(a, b);
    }
    public String out(String a){
        return Dictionary.get(a);
    }
    public String delete(String a){
        return Dictionary.remove(a);
    }
    public void search(String a){
        if(Dictionary.containsKey(a))
            System.out.println("Такой элемент есть!");
        else
            System.out.println("Такого элемента нет");
    }
    public void allElements() {
        System.out.println("Все слова выведенны: ");
        System.out.println();
        for (Map.Entry<String, String> pair : Dictionary.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("");
    }
    public Map<String, String> getDictionary() {
        return Dictionary;
    }
}
