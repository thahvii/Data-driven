package com.exercise.PageObjectTest;

import com.exercise.PageObject.CreateHotelPage;
import com.exercise.PageObject.DashboardPage;
import com.exercise.PageObject.HotelPage;
import com.exercise.PageObject.LoginPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class CreateHotelPageTest extends LoginPageTest {

    @BeforeMethod
    public void setUp() {
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.myBrowser = new ChromeDriver();
        this.myBrowser.get("https://phptravels.net/api/admin");
        this.myBrowser.manage().window().maximize();
    }

    @Test(dataProvider = "data", dataProviderClass = TestData.class)
    public void testCreateHotelSuccessfully1(String name, String location, String description)throws InterruptedException {
        Thread.sleep(2000);
        LoginPage clickLogin = new LoginPage(this.myBrowser);
        clickLogin.login();
        DashboardPage dashboardPage = new DashboardPage(this.myBrowser);
        Thread.sleep(2000);
        dashboardPage.selectLnkHotel();
        Thread.sleep(2000);
        HotelPage hotelPage = new HotelPage(this.myBrowser);
        hotelPage.clickBtnAdd();
        Thread.sleep(2000);
        CreateHotelPage hotel = new CreateHotelPage(this.myBrowser);
        hotel.createHotel(name, location, description);
    }

    @Test(dataProvider = "dataHotel", dataProviderClass = TestData.class)
    public void testCreateHotelSuccessfully2(String name, String location, String description)throws InterruptedException {
        Thread.sleep(2000);
        LoginPage clickLogin = new LoginPage(this.myBrowser);
        clickLogin.login();
        DashboardPage dashboardPage = new DashboardPage(this.myBrowser);
        Thread.sleep(2000);
        dashboardPage.selectLnkHotel();
        Thread.sleep(2000);
        HotelPage hotelPage = new HotelPage(this.myBrowser);
        hotelPage.clickBtnAdd();
        Thread.sleep(2000);
        CreateHotelPage hotel = new CreateHotelPage(this.myBrowser);
        hotel.createHotel(name, location,description);
    }

    @AfterMethod
    public void tearDown() {
        this.myBrowser.quit();
    }
}