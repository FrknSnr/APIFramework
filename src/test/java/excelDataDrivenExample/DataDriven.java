package excelDataDrivenExample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getData(String testcaseName, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\HP\\Desktop\\workspace\\ExcelDatabase.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        ArrayList<String> a = new ArrayList<>();

        int numOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numOfSheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                int col = -1;
                int k = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
                        col = k;
                    }
                    k++;
                }

                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(col).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        Iterator<Cell> c = r.cellIterator();
                        while (c.hasNext()) {
                            Cell cl = c.next();
                            if (cl.getCellType() == CellType.STRING) {
                                a.add(cl.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(cl.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
