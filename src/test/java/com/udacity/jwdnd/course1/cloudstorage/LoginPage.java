package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement usernamenameInput;

    @FindBy(id = "inputPassword")
    private WebElement passInupt;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 1000);
    }

    public void login(){
        usernamenameInput.sendKeys("johndoe@gmail.com");
        passInupt.sendKeys("123456ABC");
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
}
