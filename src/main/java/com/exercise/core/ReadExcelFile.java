package com.exercise.core;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
        try {
            FileInputStream excelFile = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0); // header

            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalColumn = row.getLastCellNum();

            Object[][] tabArray = new Object[totalRows - 1][totalColumn];
            for (int i = 1; i < totalRows; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < totalColumn; j++) {
                    if (row == null) {
                        tabArray[i - 1][j] = "";
                        continue;
                    }
                    cell = row.getCell(j);
                    if (cell == null) {
                        tabArray[i - 1][j] = "";
                        continue;
                    }
                    tabArray[i - 1][j] = cell.getStringCellValue();
                }
            }
            return tabArray;
        } catch (Exception e) {
            throw (e);
        }
    }
}
