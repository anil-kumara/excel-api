package com.excelToMysql.Excel.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int productId;

    private String prodName;

    private String prodDescription;

    private int prodPrice;
    public Product() {
    }
    public Product(int productId, String prodName, String prodDescription, int prodPrice) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodPrice = prodPrice;
    }



    public int getProductId() {
        return productId;
    }

    public String getProdName(String stringCellValue) {
        return prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }


}
