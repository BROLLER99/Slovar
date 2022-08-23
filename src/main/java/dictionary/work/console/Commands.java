package dictionary.work.console;

/**
 * Перечисление команд для работы со словарем
 */
public enum Commands {
    OutputAll(1), Add(2), Delete(3), Search(4), Exit(5);
    private final int numberOfCommand;
    /**
     * Конструктор задает состояние объекта commands
     *
     * @param numberOfCommand - вызываемой команды номер команды
     */
    Commands(int numberOfCommand) {
        this.numberOfCommand = numberOfCommand;
    }

    /**
     * Метод геттер возвращает номер выбранной команды
     *
     * @return number - номер выбранной команды
     */
    public int getNumberOfCommand() {
        return numberOfCommand;
    }

}

