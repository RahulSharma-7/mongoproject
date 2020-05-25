package com.tothenew.mongoproject.services;

import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.Seller;
import com.tothenew.mongoproject.repositories.ProductRepository;
import com.tothenew.mongoproject.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;
    public MappingJacksonValue getAllProducts()
    {

        List<Product> productList = productRepository.findAll();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productList);
        return mappingJacksonValue;


    }
}
