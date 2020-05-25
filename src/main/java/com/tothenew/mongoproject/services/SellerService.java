package com.tothenew.mongoproject.services;

import com.tothenew.mongoproject.entities.Seller;
import com.tothenew.mongoproject.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService
{
    @Autowired
    private SellerRepository sellerRepository;

    public MappingJacksonValue getSeller()
    {
        List<Seller> sellers = sellerRepository.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sellers);
        return mappingJacksonValue;
    }
}
