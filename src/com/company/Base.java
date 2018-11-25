package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Base {
    ArrayList<Notation> ATCBase = new ArrayList<Notation>();


    public boolean toFile() throws Exception {


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Base.dat"))) {
            objectOutputStream.writeObject(ATCBase);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void fromFile(){
        ArrayList<Notation> tmp;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Base.dat")))
        {
            tmp=(ArrayList) ois.readObject();
            ATCBase=tmp;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }

    public void add(Notation notation) {
        this.ATCBase.add(notation);
    }

    public void add(){
        System.out.println("create new notation.");
        Notation newNotation=new Notation();
        Scanner scn=new Scanner(System.in);
        String temp;
        String tempAddres[]=new String[3];

        boolean flag =false;
        boolean isFree=false;
        do {
            System.out.println("Input phone number:");
            temp = scn.next();
           flag= newNotation.setPhoneNumber(temp);
        }while (!flag);

        do{
            System.out.println("Input Name Of The Subscriber:(input [.] if number is free");
            temp=scn.next();
            if(temp.equals(".")){
                isFree=true;
                newNotation.setNameOfSubscriber("");
            }
            else
            flag=newNotation.setNameOfSubscriber(temp);
        }while (!flag);
        if(!isFree) {
            do {

                System.out.println("Input Subscriber City:");
                tempAddres[0] = scn.next();
                System.out.println("Input Subscriber Street:");
                tempAddres[1] = scn.next();
                System.out.println("Input Subscriber Address House:");
                tempAddres[2] = scn.next();

                flag = newNotation.subscriberAddress.setSubscriberAddress(tempAddres[0], tempAddres[1], tempAddres[2]);
            } while (!flag);
        }

        add(newNotation);
    }

    public void searchByNumber(String search) {
        int searchI = -1;
        boolean searchB = false;
        for (int i = 0; i < ATCBase.size(); i++) {
            if (ATCBase.get(i).getPhoneNumber().equals(search)) {
                searchB = true;
                searchI = i;
                break;
            }

        }
        if (searchB) {
            System.out.println("number found!");
            if (ATCBase.get(searchI).getNameOfTheSubscriber().equals(""))
                System.out.println("phone number is free!");
            else {
                System.out.println("Name Of The Subscriber:" + ATCBase.get(searchI).getNameOfTheSubscriber());
                System.out.println("Subscriber Address:" + ATCBase.get(searchI).subscriberAddress.getSubscriberAddress());
            }
        } else
            System.out.println("number not found!");


    }

    public void lisOfFreeNumbers() {
        boolean flag = false;
        for (int i = 0; i < ATCBase.size(); i++) {
            if (ATCBase.get(i).getNameOfTheSubscriber().equals("phone number is free")) {
                flag=true;
                System.out.println("phone number " + ATCBase.get(i).phoneNumber + "is free.");
            }
        }
        if (!flag)
            System.out.println("Not found");
    }

    public void searchByName(String search) {
        boolean flag = false;
        for (int i = 0; i < ATCBase.size(); i++) {
            if (ATCBase.get(i).NameOfTheSubscriber.equals(search)) {
                System.out.println("The object of the search is the owner of the phone number:" + ATCBase.get(i).phoneNumber);
                System.out.println("Subscriber Address:" + ATCBase.get(i).subscriberAddress.getSubscriberAddress());
                flag = true;

            }
        }
        if (!flag)
            System.out.println("The search has not given any results.");
    }

    public void changeOwner(String number) {
        boolean flag = false;
        for (int i = 0; i < ATCBase.size(); i++) {
            if (ATCBase.get(i).getPhoneNumber().equals(number)) {
                Scanner scn = new Scanner(System.in);
                String temp = "";
                if (ATCBase.get(i).getNameOfTheSubscriber().equals("phone number is free")) {
                    System.out.println("phone number is free. \nspecify new owner:");
                    temp = scn.next();
                    ATCBase.get(i).setNameOfSubscriber(temp);
                } else {
                    System.out.println("The owner is " + ATCBase.get(i).getNameOfTheSubscriber() + "\nspecify new owner:");
                    temp = scn.next();
                    ATCBase.get(i).setNameOfSubscriber(temp);
                }
            } else
                System.out.println("number not found!");

        }

    }
}
