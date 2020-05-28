package com.tothenew.mongoproject.repositories;

import com.tothenew.mongoproject.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String>
{
}
