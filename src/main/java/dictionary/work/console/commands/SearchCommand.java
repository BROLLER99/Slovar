package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class SearchCommand implements Command {
    private Dictionary storage;
    private String key;

    public SearchCommand(Dictionary storage, String key) {
        this.storage = storage;
        this.key = key;

    }

    @Override
    public void execute() {
        if(storage.searchElement(key)){
            System.out.println("yes element");
        }
        else {
            System.out.println("no element");
        }
    }
}

