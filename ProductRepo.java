package com.excelToMysql.Excel.API.Repository;

import com.excelToMysql.Excel.API.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
