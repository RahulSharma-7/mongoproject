package com.tothenew.mongoproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "seller")
public class Seller
{
    @Id
    private String sellerId;
    private String sellerName;
    private String sellerContact;
    private String sellerCompanyName;
    private String sellerGstNo;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerContact() {
        return sellerContact;
    }

    public void setSellerContact(String sellerContact) {
        this.sellerContact = sellerContact;
    }

    public String getSellerCompanyName() {
        return sellerCompanyName;
    }

    public void setSellerCompanyName(String sellerCompanyName) {
        this.sellerCompanyName = sellerCompanyName;
    }

    public String getSellerGstNo() {
        return sellerGstNo;
    }

    public void setSellerGstNo(String sellerGstNo) {
        this.sellerGstNo = sellerGstNo;
    }

//    @Override
//    public String toString() {
//        return "Seller{" +
//                "sellerId='" + sellerId + '\'' +
//                ", sellerName='" + sellerName + '\'' +
//                ", sellerContact='" + sellerContact + '\'' +
//                ", sellerCompanyName='" + sellerCompanyName + '\'' +
//                ", sellerGstNo='" + sellerGstNo + '\'' +
//                '}';
//    }
}
