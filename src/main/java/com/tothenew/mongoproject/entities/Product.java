package com.tothenew.mongoproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product")
public class Product
{
    @Id
    private String id;
    private String productName;
    private String productBrand;
    private Integer productQuantity;
    private Seller seller;
    private List<String> productReviewList;

    public List<String> getProductReviewList() {
        return productReviewList;
    }

    public void setProductReviewList(List<String> productReviewList) {
        this.productReviewList = productReviewList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id='" + id + '\'' +
//                ", productName='" + productName + '\'' +
//                ", productBrand='" + productBrand + '\'' +
//                ", productQuantity=" + productQuantity +
//                ", seller=" + seller +
//                ", productReviewList=" + productReviewList +
//                '}';
//    }
}
