package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class AddCommand implements Command {
    private Dictionary storage;
    private String key;
    private String value;

    public AddCommand(Dictionary storage, String key, String value) {
        this.storage = storage;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        storage.addElement(key, value);
    }
}
