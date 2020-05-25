package com.tothenew.mongoproject.controller;

import com.tothenew.mongoproject.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController
{
    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller")
    public MappingJacksonValue getSeller()
    {
        return sellerService.getSeller();
    }
}
