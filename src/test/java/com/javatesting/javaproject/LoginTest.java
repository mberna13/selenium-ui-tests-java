package com.javatesting.javaproject;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTest {
    @Test
    void openDemoQaHomePage() {
        Selenide.open("https://demoqa.com");
        $("div.home-banner").shouldBe(visible);
    }
}
