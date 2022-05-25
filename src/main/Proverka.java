package main;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Proverka {
    public String proverka_word() {
        String a;
        while (true) {
            System.out.println("Ключ слово: ");
//            Console console = System.console();
//            if(console==null) {
//                Scanner scan_value = new Scanner(System.in, "windows-1251");
//                a = scan_value.nextLine();
//            }
//            else {
//                a = console.readLine();
//            }
           a = proverka_consol();
            System.out.println();
            if (Pattern.matches("[a-zA-Z]{4}", a)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
                System.out.println("Длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки");
            }
        }
        return a;
    }
    public String proverka_number() {
        String a;
        while (true) {
            System.out.println("Ключ слово: ");
            a = proverka_consol();
            if (Pattern.matches("[0-9]{5}", a)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
                System.out.println("Длинна слов может быть только 5 символа и эти символы только цифры.");
            }
        }
        return a;
    }
    public String proverka_consol(){
        Console console = System.console();
        String a=null;
        if(console==null) {
            Scanner scan_value = new Scanner(System.in);
            a = scan_value.nextLine();
        }
        else {
            a = console.readLine();
        }
        return a;
    }

}
