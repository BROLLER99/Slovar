package dictionary.work.map;

import dictionary.work.exeption.FileException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        try {
            dictionary.put(key, value);
        } catch (IllegalArgumentException | NullPointerException | ClassCastException |
                 UnsupportedOperationException e) {
            throw new FileException("Ошибка добавления элемента");
        }
    }

    @Override
    public void deleteElement(String key) {
        try {
            dictionary.remove(key);
        } catch (NullPointerException | ClassCastException | UnsupportedOperationException e) {
            throw new FileException("Ошибка удаления элемента");
        }
    }

    @Override
    public boolean searchElement(String key) {
        try {
            return dictionary.containsKey(key);
        } catch (ClassCastException | NullPointerException e) {
            throw new FileException("Ошибка поиска элемента");
        }
    }

    @Override
    public StringBuilder outputAllElements() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> pair : dictionary.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                stringBuilder.append(key).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
            }
            return stringBuilder;
        } catch (IllegalStateException | NullPointerException e) {
            throw new FileException("Ошибка вывода всех элементов");
        }
    }
}
