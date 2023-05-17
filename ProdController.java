package com.excelToMysql.Excel.API.RestController;

import com.excelToMysql.Excel.API.Helper.ExcelHelper;
import com.excelToMysql.Excel.API.Service.ProductService;
import com.excelToMysql.Excel.API.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProdController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){

        if(ExcelHelper.checkExcelFormat(file)){
            this.productService.save(file);

            return ResponseEntity.ok(Map.of("message","file is uploaded and data is save to data base"));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload a excel format file");
    }
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

}
