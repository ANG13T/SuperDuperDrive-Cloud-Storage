package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUpPage {
    @FindBy(id = "inputFirstName")
    private WebElement firstInput;

    @FindBy(id = "inputLastName")
    private WebElement lastInput;

    WebDriver driver;

    @FindBy(id = "inputUsername")
    private WebElement usernamenameInput;

    @FindBy(id = "inputPassword")
    private WebElement passInupt;

    @FindBy(id = "signupButton")
    private WebElement signUpButton;

    @FindBy(id = "loginLink")
    private WebElement loginButton;

    @FindBy(id = "loginRedirect")
    private WebElement loginRedirect;

    private WebDriverWait wait;
    private int port;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.port = port;
        wait = new WebDriverWait(driver, 1000);
        PageFactory.initElements(driver, this);
    }

    public void enterForm(){
        firstInput.sendKeys("John");
        lastInput.sendKeys("Doe");
        usernamenameInput.sendKeys("johndoe@gmail.com");
        passInupt.sendKeys("123456ABC");
        signUpButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginRedirect));
    }

}
