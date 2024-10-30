package ru.netology.login.data;

import java.util.Locale;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {

    private DataHelper() {

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorizationCode {
        private String id;
        private String code;
        private String user_id;
        private String created;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode {
        private String code;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    private static Faker faker = new Faker(new Locale("en"));

    public static String getUserName() {
        return faker.name().firstName().toLowerCase();
    }

    public static String getUserPassword() {
        return faker.internet().password(7, 9);
    }

    public static AuthInfo getRandomLogin() {
        return new AuthInfo(getUserName(), "qwerty123");
    }

    public static AuthInfo getRandomPassword() {
        return new AuthInfo("vasya", getUserPassword());
    }

    public static AuthInfo getAutInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerificationCode getRandomVerificationCode() {
        return new VerificationCode(faker.numerify("#####"));
    }




}