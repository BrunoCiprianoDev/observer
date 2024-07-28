package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void deveNotificarUmSeguidor() {
        User user = new User("John");
        Follower follower = new Follower("Bob");
        follower.follow(user);
        user.post("Hello, world!");
        assertEquals("Bob, new post from John: Hello, world!", follower.getLatestNotification());
    }

    @Test
    void deveNotificarSeguidores() {
        User user = new User("John");
        Follower follower1 = new Follower("Bob");
        Follower follower2 = new Follower("Carol");
        follower1.follow(user);
        follower2.follow(user);
        user.post("Hello, world!");
        assertEquals("Bob, new post from John: Hello, world!", follower1.getLatestNotification());
        assertEquals("Carol, new post from John: Hello, world!", follower2.getLatestNotification());
    }

    @Test
    void naoDeveNotificarSeguidor() {
        User user = new User("John");
        Follower follower = new Follower("Bob");
        user.post("Hello, world!");
        assertNull(follower.getLatestNotification());
    }

    @Test
    void deveNotificarSeguidorEspecifico() {
        User user1 = new User("John");
        User user2 = new User("Alice");
        Follower follower1 = new Follower("Bob");
        Follower follower2 = new Follower("Carol");
        follower1.follow(user1);
        follower2.follow(user2);
        user1.post("John's post!");
        assertEquals("Bob, new post from John: John's post!", follower1.getLatestNotification());
        assertNull(follower2.getLatestNotification());
    }
}