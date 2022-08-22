package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class Invoker {
    private Dictionary storage;

    public Invoker(Dictionary storage) {
        this.storage = storage;
    }

    public void addElement(String key, String value) {
        Command addCommand = new AddCommand(storage,key, value);
        addCommand.execute();
    }
    public void deleteElement(String key) {
        Command deleteCommand = new DeleteCommand(storage,key);
        deleteCommand.execute();
    }
    public void searchElement(String key){
        Command searchCommand = new SearchCommand(storage, key);
        searchCommand.execute();
    }
    public void outputAllElements(){
        Command outputAllCommand = new OutputAllCommand(storage);
        outputAllCommand.execute();
    }
    public void setNumberOfDictionary(int numberOfDictionary){
        Command setNumberOfDictionaryCommand = new SetNumberOfDictionaryCommand(storage,numberOfDictionary);
        setNumberOfDictionaryCommand.execute();
    }
}
