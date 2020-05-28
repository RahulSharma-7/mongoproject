package com.tothenew.mongoproject.rabbitmq;

import com.tothenew.mongoproject.entities.Product;
import com.tothenew.mongoproject.entities.ProductRedis;
import com.tothenew.mongoproject.repositories.ProductRedisRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer
{

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @RabbitListener(queues = "product-queue")
    public void receiveProduct(ProductRedis product)
    {
            productRedisRepository.save(product);
    }

}
