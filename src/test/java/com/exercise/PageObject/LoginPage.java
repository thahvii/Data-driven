package com.exercise.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver myBrowser;

    // page elements
    private By txtEmail = By.cssSelector("input[type='text']");
    private By txtPassword = By.xpath("//input[@name='password']");
    private By btnLogin = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver myBrowser) {
        this.myBrowser = myBrowser;
    }

    // page actions
    public void login() throws InterruptedException {
        System.out.println(this.myBrowser.getCurrentUrl());
        myBrowser.findElement(txtEmail).sendKeys("admin@phptravels.com");
        myBrowser.findElement(txtPassword).sendKeys("demoadmin");
        myBrowser.findElement(btnLogin).click();
        Thread.sleep(2000);

    }

}
