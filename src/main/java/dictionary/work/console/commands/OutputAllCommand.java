package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

public class OutputAllCommand implements Command{
    private Dictionary storage;


    public OutputAllCommand(Dictionary storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        System.out.println(storage.outputAllElements());
    }
}
