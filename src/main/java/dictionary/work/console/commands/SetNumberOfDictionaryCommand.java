package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class SetNumberOfDictionaryCommand implements Command{
    private Dictionary storage;
    private int numberOfDictionary;

    public SetNumberOfDictionaryCommand(Dictionary storage, int numberOfDictionary) {
        this.storage = storage;
        this.numberOfDictionary=numberOfDictionary;
    }

    @Override
    public void execute() {
        storage.setNumberOfDictionary(numberOfDictionary);
    }
}
