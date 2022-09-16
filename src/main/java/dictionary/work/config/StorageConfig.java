package dictionary.work.config;

import dictionary.work.Model.DictionaryType;

import java.util.HashMap;
import java.util.Map;

public class StorageConfig {
    private static final String FIRST_PATTERN = "[a-zA-Z]{4}";
    private static final String SECOND_PATTERN = "[0-9]{5}";
    private static final String FIRST_NUMBER_OF_DICTIONARY = "1";
    private static final String SECOND_NUMBER_OF_DICTIONARY = "2";
    private static final String FIRST_DICTIONARY_AND_TERMS = "Выбран словарь № 1. \nВ данном словаре длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки";
    private static final String SECOND_DICTIONARY_AND_TERMS = "Выбран словарь № 2. \nВ данном словаре длина слов может быть только 5 символа и эти символы только цифры.";

    Map<String, DictionaryType> map;

    public StorageConfig() {
        map = new HashMap<>();
        map.put(FIRST_NUMBER_OF_DICTIONARY, new DictionaryType(FIRST_PATTERN, FIRST_DICTIONARY_AND_TERMS));
        map.put(SECOND_NUMBER_OF_DICTIONARY, new DictionaryType(SECOND_PATTERN, SECOND_DICTIONARY_AND_TERMS));
    }

    public DictionaryType getMapEntry(String s) {
        return map.get(s);
    }
}
