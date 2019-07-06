package springboot08rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Springboot08RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08RabbitmqApplication.class, args);
    }

}
