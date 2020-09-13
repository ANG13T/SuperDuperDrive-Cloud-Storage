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

    @FindBy(id = "addCred")
    private WebElement addCredButton;

    @FindBy(id = "createNoteForm")
    private WebElement createNoteForm;

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "nav-notes-tab")
    private WebElement navNotes;

    @FindBy(id = "nav-credentials-tab")
    private WebElement navCreds;

    @FindBy(id = "createCredForm")
    private WebElement createCredsForm;

    @FindBy(id = "credential-url")
    private WebElement credUrl;

    @FindBy(id = "credential-username")
    private WebElement credUsername;

    @FindBy(id = "credential-password")
    private WebElement credPassword;

    @FindBy(id = "credSubmit")
    private WebElement credSubmit;




    @FindBy(id = "noteSubmitButton")
    private WebElement noteSubmit;


    private WebDriver driver;
    private WebDriverWait wait;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 1000);
    }

    public void logOut(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public void createNote(){
        wait.until(ExpectedConditions.visibilityOf(navNotes)).click();
        wait.until(ExpectedConditions.visibilityOf(createNoteButton)).click();
        wait.until(ExpectedConditions.visibilityOf(createNoteForm));
        noteTitle.sendKeys("New note");
        noteDescription.sendKeys("Cool Note");
        noteSubmit.click();
        wait.until(ExpectedConditions.urlContains("Note"));
    }

    public void goToNotes(){
        wait.until(ExpectedConditions.visibilityOf(navNotes)).click();
    }

    public void goToCreds(){
        wait.until(ExpectedConditions.visibilityOf(navCreds)).click();
    }

    public int noteAmount(){
        return driver.findElements(By.className("note")).size();
    }

    public void editNote(String noteId){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(noteId)))).click();
        wait.until(ExpectedConditions.visibilityOf(createNoteForm));
        noteTitle.sendKeys("Updated note");
        noteDescription.sendKeys("This is a Note");
        noteSubmit.click();
    }

    public void deleteNote(String noteId){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(noteId)))).click();
    }

    public void createCredential(){
        wait.until(ExpectedConditions.visibilityOf(navCreds)).click();
        wait.until(ExpectedConditions.visibilityOf(addCredButton)).click();
        wait.until(ExpectedConditions.visibilityOf(createCredsForm));
        credUrl.sendKeys("https://google.com");
        credUsername.sendKeys("jane@gmail.com");
        credPassword.sendKeys("12345");
        credSubmit.click();
        wait.until(ExpectedConditions.urlContains("Credential"));
    }

    public void editCredential(String credentialId){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(credentialId)))).click();
        wait.until(ExpectedConditions.visibilityOf(createCredsForm));
        credUrl.sendKeys("Google.com");
        credUsername.sendKeys("Jame");
        credPassword.sendKeys("67");
        credSubmit.click();
    }

    public void deleteCredential(String credentialId){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(credentialId)))).click();
    }
}
