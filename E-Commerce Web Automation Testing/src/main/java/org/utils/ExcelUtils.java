package org.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static String readCell(String filePath, String sheetName,
                                  int rowIndex, int colIndex) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook  = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row   row   = sheet.getRow(rowIndex);
            Cell  cell  = row.getCell(colIndex);

            return cell.getCellType() == CellType.STRING
                    ? cell.getStringCellValue()
                    : cell.toString();
        } catch (IOException e) {
            throw new RuntimeException("Excel okuma hatası: " + e.getMessage(), e);
        }
    }
}