package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    @FindBy(id = "loginInputUsername")
    private WebElement usernamenameInput;

    @FindBy(id = "loginInputPassword")
    private WebElement passInupt;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "homeContain")
    private WebElement homeContainer;

    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 4000);
    }

    public void login(){
        wait.until(ExpectedConditions.visibilityOf(usernamenameInput)).sendKeys("johndoe@gmail.com");
        passInupt.sendKeys("123456ABC");
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(homeContainer));
    }
}
