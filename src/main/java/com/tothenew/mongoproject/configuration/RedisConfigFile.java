package com.tothenew.mongoproject.configuration;

import com.tothenew.mongoproject.entities.ProductRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfigFile
{
    @Bean
    public JedisConnectionFactory jedisConnectionFactory()
    {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate()
    {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }


    @Bean
    public HashOperations<String,String, ProductRedis> hashOperations(RedisTemplate<String,Object> redisTemplate)
    {
        return redisTemplate.opsForHash();
    }


}
