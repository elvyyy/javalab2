package es.com.java.model;

import java.util.Optional;

public class RegisteredUser extends TemplateUser {
    private Optional<String> name;

    public RegisteredUser(String login, String email, String password) {
        super(login, email, password);
        name = Optional.empty();
    }

    public RegisteredUser(TemplateUser user) {
        super(user.getLogin().get(), user.getEmail().get(), user.getPassword());
        name = Optional.empty();
    }

    public void changeName(String name) {
        this.name = Optional.of(name);
    }

    public Optional<String> getName() {
        return this.name;
    }

    public void printInfo() {
        if (name.isPresent()) {
            System.out.println("Name: " + name.get());
        }
    }
}
