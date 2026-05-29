package com.sky.Task;


import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;


    //取消超时未支付的订单
    @Scheduled(cron = "0 0/1 * * * ?")//每分钟执行一次
    public void cancelOutTimeOrder(){
        log.info("定时处理超时订单{}", LocalDateTime.now());
        LocalDateTime time = LocalDateTime.now().plusMinutes(-15);
        List<Orders> orders = orderMapper.cancelOutTimeOrder(Orders.PAID,time);
        if(orders != null && orders.size() > 0){
            for (Orders order : orders) {
                order.setStatus(Orders.CANCELLED);
                order.setCancelReason("支付超时，取消订单");
                order.setCancelTime(LocalDateTime.now());
                orderMapper.update(order);
            }
        }

    }

    //取消一直在派送中的订单
    @Scheduled(cron = "0 0 1 * * ?")//每天凌晨1点执行一次
    public void OutTimeDeliveryOrder(){
        log.info("定时处理处于派送中的订单{}", LocalDateTime.now());
        LocalDateTime time = LocalDateTime.now().plusMinutes(-60);
        List<Orders> orders = orderMapper.cancelOutTimeOrder(Orders.DELIVERY_IN_PROGRESS,time);
        if(orders != null && orders.size() > 0){
            for (Orders order : orders) {
                order.setStatus(Orders.COMPLETED);
                orderMapper.update(order);
            }
        }

    }
}
