package dictionary.work.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует методы интерфейса InterfaceDictionary
 */
public class Dictionary implements InterfaceDictionary {
    private static final String KEY_VALUE_SEPARATOR = ":";
    /**
     * Объект dictionary который будет хранить коллекцию Map
     */
    private static final Map<String, String> dictionary = new HashMap<>();// static чтоб можно было читать map в файл
    @Override
    public void addElement(String key, String value) {
        dictionary.put(key, value);
    }
    @Override
    public String outputElement(String key) {
        return dictionary.get(key);
    }
    @Override
    public void deleteElement(String key) {
        dictionary.remove(key);
    }
    @Override
    public boolean searchElement(String key) {
        return dictionary.containsKey(key);
    }
    @Override
    public StringBuilder outputAllElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> pair : dictionary.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            stringBuilder.append(key).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
        }
        return stringBuilder;
    }
    @Override
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
