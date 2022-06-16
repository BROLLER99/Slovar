package dictionary.work.console;


/**
 * Класс предназначен для проверки вводимого слова
 */
public class CheckWord {
    /**
     * Метод проверяет вводимое слово на соответствие условиям
     *
     * @param patternOfDictionary аргумент, по которому происходить проверка введенного слова
     * @param keyWord аргумент, проверяемое ключ-слово
     * @return возвращает true, если слово прошло проверку и false, если не прошло
     */
    public boolean check(String patternOfDictionary, String keyWord) {
        if (keyWord.matches(patternOfDictionary)) {
            return true;
        } else {
            return false;
        }
    }
}
