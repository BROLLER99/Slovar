package programm;
public class Main {
    public static int argsCommandLine;
    public static void main(String[] args) {
        if(args.length>0) {
            argsCommandLine = 1;
        }
        else argsCommandLine=0;

        Start start = new Start();
        start.chooseDictionary();
        start.chooseAction();

    }
}