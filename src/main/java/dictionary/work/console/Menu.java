package dictionary.work.console;

/**
 * Класс отвечает за предоставление меню для консоли и описания словарей
 */
public class Menu {
    /**
     * Метод предоставляет главное меню для консоли
     */
    public void mainMenu() {
        System.out.println("Выберете действие:");
        System.out.println("1 - Словарь №1");
        System.out.println("2 - Словарь №2");
        System.out.println("0 - Выход из программы");
    }

    /**
     * Метод предоставляет меню словарей для консоли
     */
    public void dictionaryMenu() {
        System.out.println("Выберете действие:");
        System.out.println("1 - Просмотр всех пар слов");
        System.out.println("2 - Добавить элемент");
        System.out.println("3 - Удалить элемент");
        System.out.println("4 - Поиск по ключу");
        System.out.println("5 - Выйти из программы");
    }

    /**
     * Метод предоставляет описание первого словаря для консоли
     */
    public void firstDictionary() {
        System.out.println("Выбран словарь № 1.");
        System.out.println("В данном словаре длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки");
        System.out.println();
    }

    /**
     * Метод предоставляет описание второго словаря для консоли
     */
    public void secondDictionary() {
        System.out.println("Выбран словарь № 2.");
        System.out.println("В данном словаре длина слов может быть только 5 символа и эти символы только цифры.");
        System.out.println();
    }
}
