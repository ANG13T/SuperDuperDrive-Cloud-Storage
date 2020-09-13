package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    @FindBy(id = "inputFirstName")
    private WebElement firstInput;

    @FindBy(id = "inputLastName")
    private WebElement lastInput;

    @FindBy(id = "inputUsername")
    private WebElement usernamenameInput;

    @FindBy(id = "inputPassword")
    private WebElement passInupt;

    @FindBy(id = "signupButton")
    private WebElement signUpButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getDisplayedCount() {
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
}
