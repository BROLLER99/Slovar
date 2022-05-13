package Main;

import Slov.Slov;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Proverka pr = new Proverka();
        //Заполнение первого словоря
        Slov slovar1 = new Slov();
        slovar1.dobav("keyA","ключA");
        slovar1.dobav("keyB","ключB");
        slovar1.dobav("keyC","ключC");
        slovar1.dobav("keyD","ключD");

        //Заполнение второго словаря
        Slov slovar2 = new Slov();
        slovar2.dobav("11111","ключ1");
        slovar2.dobav("22222","ключ2");
        slovar2.dobav("33333","ключ3");
        slovar2.dobav("44444","ключ4");

        while (true)
        {
            menu.mainmenu();
            Scanner sc = new Scanner(System.in);
            int mm = sc.nextInt();
            switch (mm){
                case 1:
                    //sc.close();
                    while (true) {
                    menu.pervi_slovar();
                    menu.slovmenu();
                    //Scanner sca = new Scanner(System.in);
                    int sm1 = sc.nextInt();
                        switch (sm1) {
                            case 1:
                                slovar1.vse_elementi();
                                break;
                            case 2:
                                System.out.println("Введите новый ключ и слово перевод");
                                String key_slovo = pr.proverka_word();
                                System.out.println("Слово перевод");
                                Scanner scan_value = new Scanner(System.in);
                                String value_slovo = scan_value.nextLine();
                                slovar1.dobav(key_slovo, value_slovo);
                                System.out.println("Добавлена запись: " + key_slovo + " : " + value_slovo);
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Введите ключ удаляемого слова:");
                                String udal = pr.proverka_word();
                                slovar1.udal(udal);
                                System.out.println("Слово с ключем " + udal + " удалено");
                                System.out.println();
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
                                //break;

                        }
                        //sca.close();
                        //break;
                    }
                    //break;
                case 2:
                   // sc.close();
                    while (true) {
                    menu.vtoroi_slovar();
                    menu.slovmenu();
                    //Scanner scan = new Scanner(System.in);
                    int sm2 = sc.nextInt();

                        switch (sm2) {
                            case 1:
                                slovar2.vse_elementi();
                                break;
                            case 2:
                                System.out.println("Введите новый ключ и слово перевод");
                                String key_slovo=pr.proverka_number();
                                System.out.println("Слово перевод");
                                Scanner scan_value = new Scanner(System.in);
                                String value_slovo = scan_value.nextLine();
                                slovar2.dobav(key_slovo, value_slovo);
                                System.out.println("Добавлена запись: " + key_slovo + " : " + value_slovo);
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Введите ключ удаляемого слова:");
                                String udal1=pr.proverka_number();
                                slovar2.udal(udal1);
                                System.out.println("Слово с ключем " + udal1 + " удалено");
                                System.out.println();
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
                       // scan.close();
                        //break;
                    }
                case 0:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункта меню не существует!");
                    System.out.println();
            }
            //break;
        }
    }
}