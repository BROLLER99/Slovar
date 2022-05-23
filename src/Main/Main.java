package Main;

import Slov.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int arg;
        if(args.length>0) {
            arg = 1;
        }
        else arg=0;
        Menu menu = new Menu();
        Proverka pr = new Proverka();
        Slov slovar1 = new Slov();
        Slov slovar2 = new Slov();
        WorkFile wf = new WorkFile();
        while (true)
        {
            menu.mainmenu();
            Scanner sc = new Scanner(System.in);
            int mm = sc.nextInt();
            switch (mm){
                case 1:
                    if(arg==1) {
                        wf.read("words.txt");
                    }
                    while (true) {
                    menu.pervi_slovar();
                    menu.slovmenu();
                    int sm1 = sc.nextInt();
                        switch (sm1) {
                            case 1:
                                slovar1.vse_elementi();
                                break;
                            case 2:
                                System.out.println("Введите новый ключ и слово перевод");
                                String key_slovo = pr.proverka_word();
                                System.out.println("Слово перевод");
                                Scanner scan_value = new Scanner(System.in,"windows-1251");
                                String value_slovo = scan_value.nextLine();
                                slovar1.dobav(key_slovo, value_slovo);
                                System.out.println("Добавлена запись: " + key_slovo + " : " + value_slovo);
                                System.out.println();
                                if(arg==1) {
                                    wf.write("words.txt");
                                }
                                System.out.println(arg);
                                break;
                            case 3:
                                System.out.println("Введите ключ удаляемого слова:");
                                String udal = pr.proverka_word();
                                slovar1.udal(udal);
                                System.out.println("Слово с ключем " + udal + " удалено");
                                System.out.println();
                                if(arg==1) {
                                    wf.write("words.txt");
                                }
                                break;
                            case 4:
                                System.out.println("Введите ключ слова, которое нужно найти");
                                String p = pr.proverka_word();
                                slovar1.poisk(p);
                                System.out.print("Ключ: " + p + " Cлово: ");
                                System.out.println(slovar1.vivod(p));
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Выход из программы");
                                System.exit(0);
                            default:
                                System.out.println("Такого пункта меню не существует!");
                                System.out.println();
                        }
                    }
                case 2:
                    if(arg==1) {
                        wf.read("chisla.txt");
                    }
                    while (true) {
                    menu.vtoroi_slovar();
                    menu.slovmenu();
                    int sm2 = sc.nextInt();

                        switch (sm2) {
                            case 1:
                                slovar2.vse_elementi();
                                break;
                            case 2:
                                System.out.println("Введите новый ключ и слово перевод");
                                String key_slovo=pr.proverka_number();
                                System.out.println("Слово перевод");
                                Scanner scan_value = new Scanner(System.in, "windows-1251");
                                String value_slovo = scan_value.nextLine();
                                slovar2.dobav(key_slovo, value_slovo);
                                System.out.println("Добавлена запись: " + key_slovo + " : " + value_slovo);
                                System.out.println();
                                if(arg==1) {
                                    wf.write("chisla.txt");
                                }
                                break;
                            case 3:
                                System.out.println("Введите ключ удаляемого слова:");
                                String udal1=pr.proverka_number();
                                slovar2.udal(udal1);
                                System.out.println("Слово с ключем " + udal1 + " удалено");
                                System.out.println();
                                if(arg==1) {
                                    wf.write("chisla.txt");
                                }
                                break;
                            case 4:
                                System.out.println("Введите ключ слова, которое нужно найти");
                                String p=pr.proverka_number();
                                slovar2.poisk(p);
                                System.out.print("Ключ: " + p + " Cлово: ");
                                System.out.println(slovar2.vivod(p));
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Выход из программы");
                                System.exit(0);
                            default:
                                System.out.println("Такого пункта меню не существует!");
                                System.out.println();
                        }
                    }
                case 0:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункта меню не существует!");
                    System.out.println();
            }
        }
    }
}