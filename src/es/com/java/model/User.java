package es.com.java.model;

public class User {
    private AuthorizationSystem authorizationSystem;

    public User(AuthorizationSystem authorizationSystem) {
        this.authorizationSystem = authorizationSystem;
    }
    
    public User register(String name, String login, String password) {
        User user = authorizationSystem.createUser(name, login, password);
        if (user != null) {
            System.out.println("Аккаунт " + login + " успешно зарегистрирован");
        } else {
            System.out.println("Ошибка регистрации. Попробуйте еще раз...");
        }
        return user;
    }

    public AuthorizationSystem getAuthorizationSystem() {
        return authorizationSystem;
    }

    public void setAuthorizationSystem(AuthorizationSystem authorizationSystem) {
        this.authorizationSystem = authorizationSystem;
    }
}
