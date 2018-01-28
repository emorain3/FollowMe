package com.example.emora.followme;

/**
 * Created by kvict on 1/27/2018.
 */

public class Watcher {
    String name;
    String number;
    boolean restrictView;
    boolean isActive;
    User stroller;

    public Watcher(String name, String number, boolean restrictView, boolean isActive, User stroller) {
        this.name = name;
        this.number = number;
        this.restrictView = restrictView;
        this.isActive = isActive;
        this.stroller = stroller;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public void setActiveStatus(boolean status) {
        this.isActive = isActive;
    }
    public void setWatcherView(boolean restrictView) {
        this.restrictView = restrictView;
    }
}
