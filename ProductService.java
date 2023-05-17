package com.excelToMysql.Excel.API.Service;

import com.excelToMysql.Excel.API.Helper.ExcelHelper;
import com.excelToMysql.Excel.API.Repository.ProductRepo;
import com.excelToMysql.Excel.API.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void save(MultipartFile file) {

        try {
            List<Product> products = ExcelHelper.convertExcelToListOfProducts(file.getInputStream());
            this.productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }
}
