package dictionary.work.console;

/**
 * Перечисление команд для работы со словарем
 */
public enum Commands {
    outputAllElements, addElement, deleteElement, searchElement, exit;
    private final static int ONE_TO_START_SERIAL_NUMBER_FROM_ONE = 1;
    /**
     * Метод геттер возвращает номер выбранной команды
     *
     * @return number - номер выбранной команды
     */
    public int getSerialNumberOfCommand() {
        return ordinal()+ONE_TO_START_SERIAL_NUMBER_FROM_ONE;
    }
}

