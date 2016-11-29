package util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by srikanth on 29/11/16.
 */
public class ExcelFileManager {
    Workbook wb = null;

    public Object[][] readExcelData(String filePath, String fileName, String sheetName){
        // object for File input stream
        Object [][]data = null;
        try{
            File file = new File(filePath+"/"+fileName);
            FileInputStream fs = new FileInputStream(file);
            String fileExtension = fileName.substring(fileName.indexOf("."));
            if(fileExtension.equals(".xls")) {
                wb = new HSSFWorkbook(fs);
            }else if(fileExtension.equals(".xlsx")) {
                wb = new XSSFWorkbook(fs);
            }else{
                System.out.println("File extension: "+fileExtension);
                System.out.println("ERROR: invalid file format, only .xls and .xlsx are supported");
                throw new RemoteException();
            }
            //get the sheet
            Sheet wbSheet =  wb.getSheet(sheetName);

            //get the rows count
            int rowCount = wbSheet.getLastRowNum() - wbSheet.getFirstRowNum();
            data = new Object[rowCount][2];

            System.out.println("Rows count = "+rowCount);

            for(int i=0;i<=rowCount;i++){
                //iterate through rows
                Row row = wbSheet.getRow(i+1);

                for(int j=0;j<row.getLastCellNum();j++){
//                    System.out.print(row.getCell(j).getStringCellValue()+"|| ");
                    data[i][j] = row.getCell(j).getStringCellValue();
                }
//                System.out.println();
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR: file is not found");
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("unable to read workbook");
            e.printStackTrace();
        }finally {
            return data;
        }

    }
}
