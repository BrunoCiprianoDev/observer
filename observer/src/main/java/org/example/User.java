package org.example;

import java.util.Observable;

public class User extends Observable {

    private String name;
    private String latestPost;

    public User(String name) {
        this.name = name;
    }

    public void post(String content) {
        this.latestPost = content;
        setChanged();
        notifyObservers(content);
    }

    public String getName() {
        return name;
    }

    public String getLatestPost() {
        return latestPost;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", latestPost='" + latestPost + '\'' +
                '}';
    }
}
