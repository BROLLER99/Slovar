package dictionary.workConsole;

/**
 * Класс предназначен для проверки вводимого слова
 */
public class CheckWord {
    /**
     * Метод проверяет вводимое слово на соответствие условиям в зависимости от выбранного словаря
     *
     * @param num аргумент, который показывает какой словарь выбран
     * @param pat аргумент, по которому происходить проверка введенного слова
     */
    public String check(int num, String pat) {
        CheckConsole checkConsole = new CheckConsole();
        String inputWord;
        while (true) {
            System.out.println("Ключ слово: ");
            inputWord = checkConsole.check();
            System.out.println();
            if (num == 1 && inputWord.matches(pat)) {
                break;
            } else if (num == 2 && inputWord.matches(pat)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
            }
        }
        return inputWord;
    }
}
