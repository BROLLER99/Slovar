package dictionary.work.console;

/**
 * Класс реализует методы интерфейса InterfaceCheckWord
 */
public class CheckWord implements InterfaceCheckWord {
    @Override
    public boolean check(String patternOfDictionary, String keyWord) {
        return keyWord.matches(patternOfDictionary);
    }
}
