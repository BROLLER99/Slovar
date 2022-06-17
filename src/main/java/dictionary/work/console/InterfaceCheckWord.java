package dictionary.work.console;
/**
 * Интерфейс определяет метод для проверки вводимого слова
 */
public interface InterfaceCheckWord {
    /**
     * Метод проверяет вводимое слово на соответствие условиям
     *
     * @param patternOfDictionary аргумент, по которому происходить проверка введенного слова
     * @param keyWord аргумент, проверяемое ключ-слово
     * @return возвращает true, если слово прошло проверку и false, если не прошло
     */
    boolean check(String patternOfDictionary, String keyWord);
}