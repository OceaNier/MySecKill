package com.oceanier.action.task;

import com.oceanier.entity.Order;
import com.oceanier.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CheckOrderTimeoutTask {

    @Autowired
    OrderService orderService;

    @Scheduled(cron = "0/2 * * * * *")
    public void checkTimeoutOrder() {
        List<Order> list = orderService.listOrder();
        System.out.println("====检查订单超时====");
        for (Order order : list) {
            Date createTime = order.getCreateTime();
            Date payTime = order.getPayTime();
            if (payTime != null) {
                continue;
            }
            long timeDistance = System.currentTimeMillis() - createTime.getTime();
            long minute = timeDistance / (60 * 1000);
            if (minute > 20 && order.getOrderFlag() == 0) {
                orderService.updateFlagById(1, order.getId());
            }
        }
    }
}
