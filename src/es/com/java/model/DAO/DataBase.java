package es.com.java.model.DAO;

import es.com.java.model.RegisteredUser;
import es.com.java.model.TemplateUser;

import java.util.ArrayList;
import java.util.Optional;

public class DataBase implements UserAuthorizationDAO {

    ArrayList<RegisteredUser> registeredUsers;

    public DataBase() {
        registeredUsers = new ArrayList<>();
    }

    @Override
    public boolean isPresent(TemplateUser user) {
        for (var o : registeredUsers) {
            if (user.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<RegisteredUser> authorize(TemplateUser user) {
        if (user.getEmail().isPresent()) {
            for (var o : registeredUsers) {
                if (user.compareToExceptLogin(o)) {
                    return Optional.of(o);
                }
            }
        } else {
            for (var o : registeredUsers) {
                if (user.compareToExceptEmail(o)) {
                    return Optional.of(o);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean addUser(TemplateUser user) {
        if (!isPresent(user)) {
            return registeredUsers.add(new RegisteredUser(user));
        }
        return false;
    }

}
