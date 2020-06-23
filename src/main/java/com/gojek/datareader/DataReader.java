package com.gojek.datareader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import com.gojek.constants.ConfigConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;

public class DataReader {


    public ArrayList Read(int sheetno,String fileName){
        ArrayList<String> rowData = new ArrayList<String>();
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file); //obtaining bytes from the file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(sheetno); //creating a Sheet object to retrieve object
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator(); //iterating over each column
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case NUMERIC:
                        rowData.add(String.valueOf((cell.getNumericCellValue())));
                        break;
                    case STRING:
                        rowData.add((cell.getStringCellValue()));
                        break;
                }

            }
        }}
        catch (Exception ex){
            return null;
        }
        return rowData;
    }
}