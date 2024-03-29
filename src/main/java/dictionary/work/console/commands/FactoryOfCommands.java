package dictionary.work.console.commands;

import dictionary.work.DAO.Storage;
import dictionary.work.Model.ModelOfCommand;
import dictionary.work.console.Commands;
import dictionary.work.exeption.CustomException;

/**
 * Класс предназначен для создания и определения объекта выбранной команды
 */
public class FactoryOfCommands {
    private final static String COMMAND_EXCEPTION = "Выбран неверный пункт";
    Storage typeOfStorage;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для определения объекта команды
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     */
    public FactoryOfCommands(Storage typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }

    /**
     * Метод определения объекта команды по выбранному пункту
     *
     * @param command        - передаваемое имя команды
     * @param modelOfCommand - модель команды с параметрами для её выполнения
     * @return возвращает новый объект команды с определенными параметрами
     */
    public Command<?> nameOfCommand(Commands command, ModelOfCommand modelOfCommand) {
        switch (command) {
            case ADD_ELEMENT:
                return new AddCommand(typeOfStorage, modelOfCommand.getKey(), modelOfCommand.getValue(), modelOfCommand.getPattern());
            case OUTPUT_ALL_ELEMENTS:
                return new OutputAllCommand(typeOfStorage);
            case DELETE_ELEMENT:
                return new DeleteCommand(typeOfStorage, modelOfCommand.getKey());
            case SEARCH_ELEMENT:
                return new SearchCommand(typeOfStorage, modelOfCommand.getKey());
            case EXIT:
                return new ExitCommand();
            default:
                throw new CustomException(COMMAND_EXCEPTION);
        }
    }
}
