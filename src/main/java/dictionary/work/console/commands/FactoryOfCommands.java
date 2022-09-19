package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
import dictionary.work.console.Commands;

import java.util.Objects;

import static dictionary.work.console.View.getInputWord;
import static dictionary.work.console.View.getPattern;

public class FactoryOfCommands {
    private static final String KEY_WORD = "Ключ слово:";
    private static final String BAD_WORD = "Неправильно ввели слово";
    private static final int ZERO_FOR_EXIT = 0;
    Dictionary typeOfStorage;

    public FactoryOfCommands(Dictionary typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }

    public Command nameOfCommand(Commands nameCommand) {
        if(Objects.equals(nameCommand.toString(), "AddElement")){
            return new AddCommand(typeOfStorage, checkWordCycle(), getInputWord());
        } else if (Objects.equals(nameCommand.toString(), "OutputAllElements")) {
            return new OutputAllCommand(typeOfStorage);
        }else if(Objects.equals(nameCommand.toString(), "DeleteElement")){
            return new DeleteCommand(typeOfStorage, checkWordCycle());
        }else if(Objects.equals(nameCommand.toString(), "SearchElement")){
            return new SearchCommand(typeOfStorage, checkWordCycle());
        }
//        else if(nameCommand.toString() == "Exit"){
//            return System.exit(ZERO_FOR_EXIT);
//        }
    return null;
    }
    private String checkWordCycle() {
        String keyWord;
        while (true) {
            System.out.println(KEY_WORD);
            keyWord = getInputWord();
            if (keyWord.matches(getPattern())) {
                return keyWord;
            } else {
                System.out.println(BAD_WORD);
            }
        }
    }
}
