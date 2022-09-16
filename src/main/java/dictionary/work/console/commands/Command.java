package dictionary.work.console.commands;

/**
 * Интерфейс для выполнения операции
 */
public interface Command <T>{
    String COMPLETE = "Операция выполнена";
    /**
     * Метод выполнения команды
     */
    T execute();
}
