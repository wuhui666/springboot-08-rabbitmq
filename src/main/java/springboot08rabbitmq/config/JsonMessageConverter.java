package springboot08rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuhui
 * @time: 2019/7/6 15:20
 * @desc:
 */
@Configuration
public class JsonMessageConverter {
        @Bean
        public MessageConverter messageConverter(){
            return new Jackson2JsonMessageConverter();
        }
}
