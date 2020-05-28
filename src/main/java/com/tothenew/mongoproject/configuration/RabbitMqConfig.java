package com.tothenew.mongoproject.configuration;

import com.tothenew.mongoproject.rabbitmq.Consumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig
{
public static final String directExchangeName =  "product-queue-exchange";
public static final String queueName = "product-queue";
public static final String routingKey = "product-queue-binding-key";

    @Bean
    Queue queue()
    {
        return new Queue(queueName,false);
    }

    @Bean
    DirectExchange directExchange()
    {
        return new DirectExchange(directExchangeName);
    }
    @Bean
    Binding binding()
    {
            return BindingBuilder.bind(queue()).to(directExchange()).with(routingKey);
    }

    @Bean
    SimpleRabbitListenerContainerFactory productContainer(SimpleRabbitListenerContainerFactoryConfigurer simpleRabbitListenerContainerFactoryConfigurer, ConnectionFactory connectionFactory)
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactoryConfigurer.configure(factory,connectionFactory);
        factory.setMessageConverter(productMeassageConverter());
        return factory;

    }

    private MessageConverter productMeassageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Consumer consumer)
    {
        return new MessageListenerAdapter(consumer);
    }



}
