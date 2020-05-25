package com.tothenew.mongoproject.repositories;


import com.tothenew.mongoproject.entities.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller,String>
{

}
