package ru.netology.login.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.login.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id = 'password'] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement notification = $("[data-test-id=error-notification] .notification__content");

    public void notificationVisibility() {
        notification.shouldBe(Condition.visible).shouldHave(text("Ошибка! Неверно указан логин или пароль"));
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
