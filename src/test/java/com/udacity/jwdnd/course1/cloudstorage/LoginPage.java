package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement usernamenameInput;

    @FindBy(id = "inputPassword")
    private WebElement passInupt;

    @FindBy(id = "loginButton")
    private WebElement signUpButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(){
        usernamenameInput.sendKeys("johndoe@gmail.com");
        passInupt.sendKeys("123456ABC");
        signUpButton.click();
    }
}
