package com.javatesting.javaproject;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("UI Testing")
@Feature("Text Box Form Submission")
@DisplayName("ToolsQA Text Box Tests")
public class TextBoxFormTest {

    @BeforeEach
    @Step("Open Text Box Form page")
    public void setUp() {
        open("https://demoqa.com/text-box");
    }

    @Test
    @Story("Valid form submission")
    @DisplayName("Submit form with valid data and verify output")
    public void testSubmitTextBoxFormSuccess() {
        fillForm("Jane Doe", "jane.doe@example.com", "123 Elm Street", "456 Oak Avenue");
        submitForm();
        verifyOutput("Jane Doe", "jane.doe@example.com", "123 Elm Street", "456 Oak Avenue");
    }

    @Step("Fill form with: {0}, {1}, {2}, {3}")
    private void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
    }

    @Step("Click Submit button")
    private void submitForm() {
        $("#submit").click();
    }

    @Step("Verify output section has correct submitted values")
    private void verifyOutput(String fullName, String email, String currentAddress, String permanentAddress) {
        $("#output").shouldBe(visible);
        $("#name").shouldHave(text(fullName));
        $("#email").shouldHave(text(email));
        $("#currentAddress").shouldHave(text(currentAddress));
        $("#permanentAddress").shouldHave(text(permanentAddress));
    }
}
