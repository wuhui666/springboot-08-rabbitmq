package springboot08rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot08RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate template;
    @Autowired
    AmqpAdmin amqpAdmin;

    //单播
    @Test
    public void testDirect() {
        //方法一需要自定义message的消息体与消息头
        //template.send(exchange,routeKey,message );
        //推荐:可以自动将obj转为message,然后序列化发给队列
        template.convertAndSend("amq.direct","wuhuibu", new RabbitAutoConfiguration());
    }

    //广播
    @Test
    public void testFanout(){
        template.convertAndSend("amq.fanout","","fanout msg");
    }
    //主题exchange,路由键模糊匹配
    @Test
    public void testTopic(){
        template.convertAndSend("amq.topic","xxx.hui",".hui msg");
        //template.convertAndSend("amq.topic","wuhui.xxx","wuhui. msg");

    }
    //amqpAdmin操作管理
    @Test
    public void testAmqpaAdmin(){
       amqpAdmin.declareExchange(new DirectExchange("testdirectexchange"));
       amqpAdmin.declareQueue(new Queue("TestQueue",true));
       amqpAdmin.declareBinding(new Binding("TestQueue", Binding.DestinationType.QUEUE, "testdirectexchange", "test", null));

   //amqpAdmin.deleteQueue("TestQueue");
  //amqpAdmin.removeBinding(new Binding("TestQueue", Binding.DestinationType.QUEUE, "amq.direct", "test", null));

    }
    
    //template接收消息，建议监听
    @Test
    public void test(){
        RabbitAutoConfiguration wuhuibu = (RabbitAutoConfiguration)template.receiveAndConvert("wuhui.bu");
        System.out.println(wuhuibu.toString());
    }
}
