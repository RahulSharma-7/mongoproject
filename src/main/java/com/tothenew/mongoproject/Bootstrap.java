package com.tothenew.mongoproject;

import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.ProductRedis;
import com.tothenew.mongoproject.entities.Seller;
import com.tothenew.mongoproject.repositories.ProductRedisRepository;
import com.tothenew.mongoproject.repositories.ProductRepository;
import com.tothenew.mongoproject.repositories.SellerRepository;
import com.tothenew.mongoproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    private ProductService productService;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ProductRedisRepository productRedisRepository;
    @Autowired
    private ProductRepository productRepository;


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

        productService.save(product);
        productService.save(product1);



        Thread.sleep(10000);
 //       wait(10000);
        System.out.println("<--------------------The Product is listed from the Redis db------------------->");
        System.out.println(productRedisRepository.findAll());
        System.out.println("<-----------------The product is listed from the Mongo db---------------------->");
        System.out.println(productRepository.findAll());


        }
}
