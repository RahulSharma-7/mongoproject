package com.tothenew.mongoproject.repositories;

import com.tothenew.mongoproject.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>
{
}
