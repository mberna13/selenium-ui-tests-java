package com.javatesting.javaproject;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginLearnTest {
    private static final String LEARNIX_URL = "https://www.learnix.education/";

    @Test
    @DisplayName("Should open Learnix homepage and click login button")
    void openLearnQAHomePage() {
        open(LEARNIX_URL);
        $("[href='/login']").click(); // Using a more reliable selector
        $("[id='email']").setValue("demo@demo.com");
        $("[id='password']").setValue("demo");
        $("[class='login-btn']").click();
        sleep(3000);
        $("[class='user-name']").shouldHave(text("Logged in as: Demo User"));
    }
}
