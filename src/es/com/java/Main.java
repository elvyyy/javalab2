package es.com.java;

import es.com.java.model.AuthorizationSystem;
import es.com.java.model.RegisteredUser;
import es.com.java.model.User;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        AuthorizationSystem authorizationSystem = new AuthorizationSystem();

        User user1 = new User(authorizationSystem);
        RegisteredUser registeredUser1 = (RegisteredUser)user1.register("Влад", "elvy", "123456");
        registeredUser1.signIn();

        User user2 = new User(authorizationSystem);
        RegisteredUser registeredUser2 = (RegisteredUser)user2.register("Сергей", "abc", "345");
        registeredUser2.signIn();

        registeredUser1.signIn();

    }
}
