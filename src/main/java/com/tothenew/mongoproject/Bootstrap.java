package com.tothenew.mongoproject;

import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.Seller;
import com.tothenew.mongoproject.repositories.ProductRepository;
import com.tothenew.mongoproject.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerRepository sellerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        Product product = new Product();
        product.setId("Product1XasdX12");
        product.setProductBrand("JIO");
        product.setProductName("JIO FI");
        product.setProductQuantity(12334);


        Product product1 = new Product();
        product1.setId("Product2");
        product1.setProductName("Shirts");
        product1.setProductBrand("GUCCI");
        product1.setProductQuantity(100);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);


        Seller seller = new Seller();
        seller.setSellerId("SELLER1");
        seller.setSellerCompanyName("COMPPANYXX");
        seller.setSellerContact("WERTYUUGFDCV");
        seller.setSellerGstNo("DFCGHVHKJNLKN");
        seller.setSellerName("SHARRMA");
        seller.setProductList(productList);


        sellerRepository.insert(seller);
        productRepository.insert(product);
        productRepository.insert(product1);

        System.out.println(sellerRepository.findAll());
        System.out.println("HHello");

        }
}
