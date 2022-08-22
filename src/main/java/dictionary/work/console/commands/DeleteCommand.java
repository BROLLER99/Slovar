package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class DeleteCommand implements Command {
    private Dictionary storage;
    private String key;
    public DeleteCommand(Dictionary storage, String key) {
        this.storage = storage;
        this.key=key;
    }
    @Override
    public void execute(){
        storage.deleteElement(key);
    }
}
