package es.com.java.model.DAO;

import es.com.java.model.RegisteredUser;
import es.com.java.model.TemplateUser;

import java.util.Optional;

public interface UserAuthorizationDAO {

    boolean isPresent(TemplateUser user);

    Optional<RegisteredUser> authorize(TemplateUser user);

    boolean addUser(TemplateUser user);

}
