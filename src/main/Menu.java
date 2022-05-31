package main;

public class Menu {
    public void mainMenu() {
        System.out.println("Выберете действие:");
        System.out.println("1 - Словарь №1");
        System.out.println("2 - Словарь №2");
        System.out.println("0 - Выход из программы");
    }

    public void dictionaryMenu() {
        System.out.println("Выберете действие:");
        System.out.println("1 - Просмотр всех пар слов");
        System.out.println("2 - Добавить элемент");
        System.out.println("3 - Удалить элемент");
        System.out.println("4 - Поиск по ключу");
        System.out.println("5 - Выйти из программы");
    }

    public void firstDictionary() {
        System.out.println("Выбран словарь № 1.");
        System.out.println("В данном словаре длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки");
        System.out.println();
    }
    public void secondDictionary(){
        System.out.println("Выбран словарь № 2.");
        System.out.println("В данном словаре длина слов может быть только 5 символа и эти символы только цифры.");
        System.out.println();
    }
}
