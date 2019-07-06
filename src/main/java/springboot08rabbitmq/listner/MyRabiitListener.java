package springboot08rabbitmq.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: wuhui
 * @time: 2019/7/6 15:43
 * @desc: 监听队列获取消息
 */
/*
@Component
public class MyRabiitListener {
    @RabbitListener(queues = {"wuhui.bu","wuhui.zeng","zeng.hui","bu.hui"})//app需要添加@EnableRabbit
    public void listen(String msg){
        System.out.println("receive :"+msg);
    }
}
*/
