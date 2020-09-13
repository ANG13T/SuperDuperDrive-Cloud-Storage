package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    @FindBy(id = "logOutButton")
    private WebElement logoutButton;

    @FindBy(id = "createNote")
    private WebElement createNoteButton;

    @FindBy(id = "createNoteForm")
    private WebElement createNoteForm;

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "noteSubmit")
    private WebElement noteSubmit;

    private WebDriver driver;
    private WebDriverWait wait;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 1000);
    }

    public void logOut(){
        logoutButton.click();
    }

    public void createNote(){
        wait.until(ExpectedConditions.visibilityOf(createNoteButton));
        createNoteButton.click();
        wait.until(ExpectedConditions.visibilityOf(createNoteForm));
        noteTitle.sendKeys("New note");
        noteDescription.sendKeys("Cool Note");
        noteSubmit.submit();
    }

    public boolean hasNote(String noteID){
        return driver.findElements(By.id(noteID)).size() > 0;
    }

    public void editNote(){

    }

    public void deleteNote(){

    }

    public void createCredential(){

    }

    public void editCredential(){

    }

    public void deleteCredential(){

    }
}
