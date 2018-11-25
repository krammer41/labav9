package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        formulationOfTheProblem();

        testMenu();
/*
        Notation n = new Notation();
        System.out.println("_________________________");
        System.out.println(n.getNameOfTheSubscriber());
        n.setNameOfSubscriber("");
        System.out.println(n.getNameOfTheSubscriber());

        System.out.println("_________________________");
        System.out.println(n.getPhoneNumber());
        n.setPhoneNumber("+380665285745");
        System.out.println(n.getPhoneNumber());

        System.out.println("_________________________");


        System.out.println(n.subscriberAddress.getSubscriberAddress());
        n.subscriberAddress.setSubscriberAddress("Odessa", "Dovga", "11");
        System.out.println(n.subscriberAddress.getSubscriberAddress());

        Notation n2=new Notation();
        n2.setNameOfSubscriber("Li Hack");
        n2.setPhoneNumber("+380665285999");
        n2.subscriberAddress.setSubscriberAddress("Odessa", "Dovga", "21");


        Base base = new Base();
        base.add(n);
        base.add(n2);
       // base.searchByNumber("+380997630991");
       // base.lisOfFreeNumbers();
        //base.searchByName("Li Hack");
        //base.changeOwner("+380665285999");
        base.toFile();

       // Base base = new Base();

        base.fromFile();
        //base.changeOwner("+380665285999");

*/

    }

    private static void testMenu() throws Exception {
        int action = 0;
        Base base = new Base();
        String temp;
        Scanner scn = new Scanner(System.in);
        boolean flag=false;

        while (true) {
            System.out.println("read database...");
            base.fromFile();
            flag=false;
            System.out.println("1.Add Notation\n" +
                    "2.Search By Number\n" +
                    "3.Search By Name\n" +
                    "4.Assigning a given phone number to another owner\n" +
                    "5.Issuing a list of free telephone numbers.");
            action=scn.nextInt();


            switch (action) {
                case 1:
                    base.add();
                    flag=true;
                    break;
                case 2:
                    System.out.println("Input search number:");
                    temp = scn.next();
                    base.searchByNumber(temp);
                    break;
                case 3:
                    System.out.println("Input search Name:");
                    temp=scn.next();
                    base.searchByName(temp);
                    break;
                case 4:
                    System.out.println("Input search number:");
                    temp = scn.next();
                    base.changeOwner(temp);
                    flag=true;
                    break;
                case 5:
                    base.lisOfFreeNumbers();
                    break;

                default:

                    break;
            }
            if (flag)
            base.toFile();
        }
    }

    public static void formulationOfTheProblem() {
        System.out.println("Создать базу данных - телефонный справочник некоторой АТС города. Каждая запись содержит следующие сведения:\n" +
                "\uF02D\tномер телефона;\n" +
                "\uF02D\tФИО абонента ;\n" +
                "\uF02D\tадрес абонента.\n" +
                "Предусмотреть:\n" +
                "а) выдачу сведений об абоненте по его телефонному номеру;\n" +
                "б) выдачу телефонного номера по фамилии абонента;\n" +
                "в) назначение заданного телефонного номера другому владельцу;\n" +
                "г) выдачу списка свободных телефонных номеров.\n");
    }


}
