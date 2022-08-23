package dictionary.work.console;

public enum Commands {
    OutputAll(1), Add(2), Delete(3), Search(4), Exit(5);
    private final int number;

    Commands(int number) {
        this.number = number;
    }

    public int getNumberOfCommand() {
        return number;
    }

}

