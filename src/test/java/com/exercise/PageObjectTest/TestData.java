package com.exercise.PageObjectTest;

import java.io.IOException;
import com.exercise.core.ReadExcelFile;
import com.exercise.core.ReadJsonFile;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "data")
    public static Object[][] hotelData() throws IOException {

        return ReadExcelFile.getDataFromExcel("E:\\Auto Test\\datadriven\\DataHotel.xlsx", "Sheet1");
    }

    @DataProvider(name = "dataHotel")
    public static Object[][] hotelDataJson() throws IOException {

        return ReadJsonFile.getDataFromJson("E:\\Auto Test\\datadriven\\DataHotel.json");
    }
}
