package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(id = "loginLink")
    private WebElement loginButton;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterForm(){
        firstInput.sendKeys("John");
        lastInput.sendKeys("Doe");
        usernamenameInput.sendKeys("johndoe@gmail.com");
        passInupt.sendKeys("123456ABC");
        signUpButton.click();
        loginButton.click();
    }

}