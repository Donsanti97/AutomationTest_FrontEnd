package com.example.screenplay.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getUserData(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            Map<String, String> data = new HashMap<>();
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                Row headerRow = rowIterator.next();
                Row dataRow = rowIterator.next();
                for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                    data.put(headerRow.getCell(i).getStringCellValue(), dataRow.getCell(i).getStringCellValue());
                }
            }
            workbook.close();
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
