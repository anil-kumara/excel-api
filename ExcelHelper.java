package com.excelToMysql.Excel.API.Helper;

import com.excelToMysql.Excel.API.entity.Product;
import org.apache.commons.math3.util.MultidimensionalCounter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelHelper {

    //To check file is excel type or not
    public static boolean checkExcelFormat(MultipartFile file){

        //to get a contents in file
       String contentType=file.getContentType();

       //file excel or ?
       if(contentType.equals("application/vnd.openxmlformats-officedouments.spreadsheetml.sheet")){
           return true;
       }
       else {
           return false;
       }
    }

    //it converts excel to <List> of products
    public static List<Product> convertExcelToListOfProducts(InputStream inputStream){
        List<Product> list=new ArrayList<>();
        try {

            //To read our excel
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheet("ProdData");


            //To iterate each row
            int rowNumber = 0;

            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext()){
                Row row= iterator.next();

                //because first row has column names to skip that, below code is used
                if(rowNumber==0){
                    rowNumber++;
                    continue;
                }

                //to store data
                Product p=new Product();

                //iterate cells
                Iterator<Cell> cells= row.iterator();
                int cellId=0;

                while(cells.hasNext()){
                    Cell cell=cells.next();   //taking single cell
                    switch(cellId){
                        case 0:
                            p.setProductId((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            p.getProdName((String)cell.getStringCellValue());
                            break;
                        case 3:
                            p.setProdDescription((String)cell.getStringCellValue());
                            break;
                        case 4:
                            p.setProdPrice((int)cell.getNumericCellValue());
                            break;
                            default:
                                break;
                    }
                    cellId++;
                }
                list.add(p);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;


    }
}
