package dictionary.work.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предназначен для работы с коллекцией Map
 */
public class Dictionary {
    /**
     * Объект Dictionary1.Dictionary1.WorkConsole.WorkConsole.dictionary который будет хранить коллекцию Map
     */
    private static final Map<String, String> dictionary = new HashMap<>();// static чтоб можно было читать map в файл

    /**
     * Метод добавление элемента в Map
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    public void addElement(String key, String value) {
        dictionary.put(key, value);
    }

    /**
     * Метод вывода элемента из Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо вывести
     */
    public String outputElement(String key) {
        return dictionary.get(key);
    }

    /**
     * Метод удаления элемента из Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public void deleteElement(String key) {
        dictionary.remove(key);
    }

    /**
     * Метод поиска элемента в Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     */
    public boolean searchElement(String key) {
        return dictionary.containsKey(key);
    }

    /**
     * Метод для вывода всех элементов из Map
     */
    public StringBuilder outputAllElements() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : dictionary.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            sb.append(key).append(":").append(value).append("\n");
        }
        return sb;
    }

    /**
     * Метод получения содержимого Map
     */
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
