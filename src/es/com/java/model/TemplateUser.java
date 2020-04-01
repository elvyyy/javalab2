package es.com.java.model;

import java.util.Objects;
import java.util.Optional;

public class TemplateUser {
    private Optional<String> login;
    private Optional<String> email;
    private String password;

    public TemplateUser(String login, String email, String password) {
        this.login = Optional.of(login);
        this.email = Optional.of(email);
        this.password = password;
    }

    public TemplateUser() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateUser)) return false;
        TemplateUser that = (TemplateUser) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    public boolean compareToExceptLogin(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateUser)) return false;
        TemplateUser that = (TemplateUser) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    public boolean compareToExceptEmail(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateUser)) return false;
        TemplateUser that = (TemplateUser) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password);
    }

    public Optional<String> getLogin() {
        return login;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
