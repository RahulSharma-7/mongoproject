package com.tothenew.mongoproject.repositories;

import com.tothenew.mongoproject.entities.ProductRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRedisRepositoryImpl implements ProductRedisRepository
{

    @Autowired
    private HashOperations<String,String, ProductRedis> hashOperations;


    @Override
    public void save(ProductRedis product)
    {

        hashOperations.put("product",product.getId(),product);

    }

    @Override
    public List<ProductRedis> findAll() {
       Map<String, ProductRedis> productRedisMap = hashOperations.entries("product");
    List<ProductRedis> productRedisList = new ArrayList<>(productRedisMap.values());
    return productRedisList;
    }

}
