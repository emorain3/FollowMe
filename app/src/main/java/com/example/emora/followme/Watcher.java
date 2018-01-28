package com.example.emora.followme;

/**
 * Created by kvict on 1/27/2018.
 */

public class Watcher {
    String name;
    String number;
    boolean restrictView = false;
    boolean active = false;
    User stroller;

    public Watcher(String name, String number, boolean restrictView, User stroller) {
        this.name = name;
        this.number = number;
        this.restrictView = restrictView;
        this.stroller = stroller;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public void setActiveStatus(boolean status) {
        this.active = active;
    }
    public void setWatcherView(boolean restrictView) {
        this.restrictView = restrictView;
    }
}
