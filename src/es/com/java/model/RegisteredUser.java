package es.com.java.model;

public class RegisteredUser extends User {
    private UserInfo userInfo;

    public RegisteredUser(AuthorizationSystem authorizationSystem, UserInfo userInfo) {
        super(authorizationSystem);
        this.userInfo = userInfo;
    }

    public boolean signIn() {
        boolean status = getAuthorizationSystem().checkUser(userInfo);
        if (status) {
            System.out.println("Welcome, " + userInfo.getName());
        } else {
            System.out.println("Пользователя с такими данными не существует");
        }
        return status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
