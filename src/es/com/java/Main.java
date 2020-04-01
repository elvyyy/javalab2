package es.com.java;

import es.com.java.model.AuthorizationSystem;
import es.com.java.model.RegisteredUser;
import es.com.java.model.TemplateUser;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        AuthorizationSystem authorizationSystem = AuthorizationSystem.getInstance();

        // Регистрация выполена успешно
        if (!authorizationSystem.register(new TemplateUser("smth", "smth@mail.ru", "123456"))) {
            System.out.println("Ошибка регистрации");
        } else {
            System.out.println("Регистрация выполнена успешно");
        }

        // Выведет на консоль:
        // "Name: John"
        Optional<RegisteredUser> user = authorizationSystem.authorize(new TemplateUser("smth", "smth@mail.ru", "123456"));
        if (!user.isPresent()) {
            System.out.println("Ошибка авторизации");
        } else {
            user.get().printInfo();
            user.get().changeName("John");
            user.get().printInfo();
        }

        // Выведет на консоль:
        // "Ошибка авторизации"
        user = authorizationSystem.authorize(new TemplateUser("smth", "smth@mailru", "123456"));
        if (!user.isPresent()) {
            System.out.println("Ошибка авторизации");
        } else {
            user.get().printInfo();
            user.get().changeName("John");
            user.get().printInfo();
        }

        // Выведет на консоль:
        // "Ошибка регистрации"   (Такой пользователь уже существует)
        if (!authorizationSystem.register(new TemplateUser("smth", "smth@mail.ru", "123456"))) {
            System.out.println("Ошибка регистрации");
        } else {
            System.out.println("Регистрация выполнена успешно");
        }

        // Выведет на консоль:
        // "Ошибка регистрации"   (Неверный email)
        if (!authorizationSystem.register(new TemplateUser("smth", "smthmail.ru", "123456"))) {
            System.out.println("Ошибка регистрации");
        } else {
            System.out.println("Регистрация выполнена успешно");
        }

        // Выведет на консоль:
        // "Регистрация прошла успешно"
        if (!authorizationSystem.register(new TemplateUser("ghv", "again@gmail.com", "123456"))) {
            System.out.println("Ошибка регистрации");
        } else {
            System.out.println("Регистрация выполнена успешно");
        }

        // Выведет на консоль:
        // "Ошибка авторизации"  (Неверный пароль)
        user = authorizationSystem.authorize(new TemplateUser("ghv", "again@gmail.com", "123756"));
        if (!user.isPresent()) {
            System.out.println("Ошибка авторизации");
        } else {
            System.out.println("Авторизация прошла успешно");
        }

        // Выведет на консоль:
        // "Авторизация прошла успешно"
        user = authorizationSystem.authorize(new TemplateUser("ghv", "again@gmail.com", "123456"));
        if (!user.isPresent()) {
            System.out.println("Ошибка авторизации");
        } else {
            System.out.println("Авторизация прошла успешно");
        }

    }
}
