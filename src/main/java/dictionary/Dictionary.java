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
    public boolean searchElement(String key){
        return dictionary.containsKey(key);
    }
    public StringBuilder outputAllElements() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : dictionary.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            sb.append(key).append(":").append(value).append("\n");
        }
        return sb;
    }
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
