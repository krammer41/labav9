package com.company;

import java.io.Serializable;

public class SubscriberAddress implements Serializable {

    String city;
    String street;
    String house;

    public String getSubscriberAddress() {
        String address = "";
        address = this.city + "," + this.street + "," + this.house;
        return address;

    }

    public boolean setSubscriberAddress(String city, String street, String house) {
        City[] cities = City.values();
        boolean itsTrue = false;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].toString().equals(city)) {
                this.city = city;
                itsTrue = true;

                break;
            }
        }
        if (!itsTrue) return false;

        if (Character.isLetter(street.charAt(0)) && Character.isLetter(street.charAt(1)))
            this.street = street;
        else
            return false;
        if (Character.isDigit(house.charAt(0)))
            this.house = house;
        else
            return false;

        return true;
    }

    enum City {
        Kiev,
        Odessa,
        Kharkov,
        Lviv,
        Nikolaev,
        Kherson,
        Zaporizhia,
        Dnieper,
        Kropyvnytskyi,
        Ternopil,
        Uman,
        IvanoFrankivsk,
        Uzhgorod
    }
}
