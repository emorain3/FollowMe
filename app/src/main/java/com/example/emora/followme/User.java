package com.example.emora.followme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvict on 1/27/2018.
 */

public class User {
    private String name;
    private String number;
    //String address;
    private String height;
    private String weight;
    private String eyeColor;
    private String hairColor;
    private String race;
    private String addtnInfo;
    private boolean isWatcher = false;
    private List<Watcher> watchlist = new ArrayList<>();
    private User currentUser;


    public User(String name, String number, String height, String weight,
                String eyeColor, String hairColor, String race, String addtnInfo) {

        this.name = name;
        this.number = number;
        //this.address = address;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.race = race;
        this.addtnInfo = addtnInfo;
        //this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    /*public String getAddress() {
        return address;
    }*/

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getRace() {
        return race;
    }

    public String getAddtnInfo() {
        return addtnInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;

    }
    /*
    public void setAddress(String address) {
        this.address = address;
    }*/

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setRace() {
        this.race = race;
    }

    public void setAddtnInfo() {
        this.addtnInfo = addtnInfo;
    }
}
