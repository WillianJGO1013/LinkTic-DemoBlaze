package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	
	public String[] getCredentials(int rowNumber) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File("usuarios.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowNumber);
        String username = row.getCell(0).getStringCellValue();
        String password = row.getCell(1).getStringCellValue();

        workbook.close();
        return new String[] { username, password };
    }
}
