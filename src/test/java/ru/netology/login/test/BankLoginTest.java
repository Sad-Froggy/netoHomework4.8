package ru.netology.login.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.login.data.DataHelper;
import ru.netology.login.data.SQLHelper;
import ru.netology.login.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

import static ru.netology.login.data.SQLHelper.cleanDB;

public class BankLoginTest {

    String APP_URL = "http://localhost:9999";

    LoginPage loginPage;


    @BeforeEach
    void setup() {
        loginPage = open(APP_URL, LoginPage.class);
    }

    @AfterAll
    static void clean() {
        cleanDB();
    }

    @Test
    void shouldTestEnterWithValidLoginAndPassword() {
        var authinfo = DataHelper.getAutInfo();
        var verPage = loginPage.validLogin(authinfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verPage.verify(verificationCode);
    }

    @Test
    void shouldTestEnterWithRandomLogin() {
        var autoinfo = DataHelper.getRandomLogin();
        loginPage.validLogin(autoinfo);
        loginPage.notificationVisibility();
    }

    @Test
    void shouldTestEnterWithRandomPassword() {
        var authInfo = DataHelper.getRandomPassword();
        loginPage.validLogin(authInfo);
        loginPage.notificationVisibility();
    }

    @Test
    void shouldTestEnterWithRandomVerificationCode() {
        var authInfo = DataHelper.getAutInfo();
        var verPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getRandomVerificationCode();
        verPage.verifyRandomCode(verificationCode);
    }

}
