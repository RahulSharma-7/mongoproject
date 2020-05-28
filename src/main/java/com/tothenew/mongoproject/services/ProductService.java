package com.tothenew.mongoproject.services;

import com.tothenew.mongoproject.configuration.RabbitMqConfig;
import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.ProductRedis;
import com.tothenew.mongoproject.entities.Seller;
import com.tothenew.mongoproject.repositories.ProductRedisRepository;
import com.tothenew.mongoproject.repositories.ProductRepository;
import com.tothenew.mongoproject.repositories.SellerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    @Autowired
    private ProductRedisRepository productRedisRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public MappingJacksonValue getAllProducts()
    {

        List<Product> productList = productRepository.findAll();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productList);
        return mappingJacksonValue;


    }

    public void save(Product product)
    {
        productRepository.insert(product);
        ProductRedis productRedis = toProductRedis(product);
        rabbitTemplate.convertAndSend(RabbitMqConfig.directExchangeName,RabbitMqConfig.routingKey,productRedis);


    }

    private ProductRedis toProductRedis(Product product)
    {
        ProductRedis productRedis = new ProductRedis();
        productRedis.setId(product.getId());
        productRedis.setProductBrand(product.getProductBrand());
        productRedis.setProductName(product.getProductName());
        productRedis.setProductQuantity(product.getProductQuantity());
        productRedis.setProductReviewList(product.getProductReviewList());

        return productRedis;
    }
}
