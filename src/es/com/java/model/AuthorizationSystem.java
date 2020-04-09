package es.com.java.model;

import es.com.java.dao.DataBase;
import es.com.java.dao.UserAuthorizationDAO;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Optional;

public class AuthorizationSystem {
    private static AuthorizationSystem instance;
    private UserAuthorizationDAO userAuthorization;
    private EmailValidator emailValidator;

    protected AuthorizationSystem() {
        userAuthorization = new DataBase();
        emailValidator = EmailValidator.getInstance();
    };

    public static synchronized AuthorizationSystem getInstance() {
        if (instance == null) {
            instance = new AuthorizationSystem();
        }
        return instance;
    }

    public void setUserAuthorization(UserAuthorizationDAO userAuthorization) {
        this.userAuthorization = userAuthorization;
    }

    public Optional<RegisteredUser> authorize(TemplateUser user) {
        if (user.getEmail().isPresent()) {
            if (emailValidator.isValid(user.getEmail().get())) {
                return userAuthorization.authorize(user);
            }
        }
        return Optional.empty();
    }
    
    public boolean register(TemplateUser user) {
        Optional<String> email = user.getEmail();
        Optional<String> login = user.getLogin();

        if (email.isPresent() && emailValidator.isValid(email.get()))
            return userAuthorization.addUser(user);
        if (login.isPresent() && !email.isPresent())
            return userAuthorization.addUser(user);
        if (login.isPresent() && emailValidator.isValid(email.get()))
            return userAuthorization.addUser(user);
        return false;
    }
}
