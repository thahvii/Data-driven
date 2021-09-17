package com.exercise.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends LoginPage {
    // page elements
    private By lblAccount = By.xpath("//li[@id='account']/a");
    private By lnkHotel1 = By.xpath("//a[normalize-space()='hotels']");
    private By lnkHotel2 = By.xpath("//a[contains(@href, '#Hotels')]");
    private By lnkHotel3 = By.xpath("//a[@href='https://phptravels.net/api/admin/hotels']");

    public DashboardPage(WebDriver myBrowser) {
        super(myBrowser);
    }

    // page actions
    public HotelPage selectLnkHotel() throws InterruptedException {
        myBrowser.findElement(lnkHotel1).click();
        Actions action = new Actions(this.myBrowser);
        action.moveToElement(myBrowser.findElement(lnkHotel2)).moveToElement(myBrowser.findElement(lnkHotel3)).click()
                .build().perform();
        Thread.sleep(2000);
        return new HotelPage(this.myBrowser);
    }

    // page validate
    public boolean isLblAccount() {
        if (myBrowser.findElement(lblAccount).isDisplayed()) {
            return true;
        }
        return false;
    }
}

