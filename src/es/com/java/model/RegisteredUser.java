package es.com.java.model;

public class RegisteredUser extends User {
    protected UserInfo userInfo;

    public RegisteredUser(AuthorizationSystem authorizationSystem, UserInfo userInfo) {
        super(authorizationSystem);
        this.userInfo = userInfo;
    }

    public boolean signIn() {
        boolean status = authorizationSystem.checkUser(userInfo);
        if (status) {
            System.out.println("Welcome, " + userInfo.getName());
        } else {
            System.out.println("Пользователя с такими данными не существует");
        }
        return status;
    }
}
