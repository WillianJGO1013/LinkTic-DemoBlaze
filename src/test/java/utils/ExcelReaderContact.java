package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderContact {
	
	public String[] getCredentials(int rowNumber) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File("contacto.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowNumber);
        String email = row.getCell(0).getStringCellValue();
        String name = row.getCell(1).getStringCellValue();
        String msg = row.getCell(2).getStringCellValue();

        workbook.close();
        return new String[] { email, name, msg };
    }

}
