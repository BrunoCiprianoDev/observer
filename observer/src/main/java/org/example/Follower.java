package org.example;

import java.util.Observable;
import java.util.Observer;

public class Follower implements Observer {

    private String name;
    private String latestNotification;

    public Follower(String name) {
        this.name = name;
    }

    public String getLatestNotification() {
        return latestNotification;
    }

    public void follow(User user) {
        user.addObserver(this);
    }

    @Override
    public void update(Observable user, Object post) {
        this.latestNotification = this.name + ", new post from " + ((User)user).getName() + ": " + post;
        // System.out.println(this.latestNotification);
    }
}