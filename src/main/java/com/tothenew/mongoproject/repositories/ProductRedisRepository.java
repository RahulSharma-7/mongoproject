package com.tothenew.mongoproject.repositories;

import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.ProductRedis;

import java.util.List;

public interface ProductRedisRepository
{
void save(ProductRedis product);
List<ProductRedis> findAll();
}
