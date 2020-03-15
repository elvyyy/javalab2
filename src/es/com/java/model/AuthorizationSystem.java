package es.com.java.model;

import java.util.ArrayList;

public class AuthorizationSystem {
    private ArrayList<UserInfo> userInfos;

    public AuthorizationSystem() {
        userInfos = new ArrayList<>();
    }

    public User createUser(String name, String login, String password) {
        UserInfo userInfo = new UserInfo(name, login, password);
        if (userInfos.add(userInfo)) {
            return new RegisteredUser(this, userInfo);
        }
        return null;
    }

    public boolean checkUser(UserInfo userInfo) {
        for (UserInfo info : userInfos) {
            if (info.equals(userInfo)) {
                return true;
            }
        }
        return false;
    }
}
