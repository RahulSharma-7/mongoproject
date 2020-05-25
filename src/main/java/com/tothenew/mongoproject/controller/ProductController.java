package com.tothenew.mongoproject.controller;

import com.tothenew.mongoproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public MappingJacksonValue getAllProducts()
    {
        return productService.getAllProducts();
    }
}
