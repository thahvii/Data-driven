package com.exercise.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelPage extends LoginPage {
    // page emlements

    private By btnAdd = By.xpath("//button[@type='submit']");

    public HotelPage(WebDriver myBrowser) {
        super(myBrowser);
    }

    // page actions
    public void clickBtnAdd() throws InterruptedException {
        myBrowser.findElement(btnAdd).click();
        Thread.sleep(2000);
    }

    // page validate

}
