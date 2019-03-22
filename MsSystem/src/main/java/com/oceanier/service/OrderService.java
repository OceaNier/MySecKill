package com.oceanier.service;

import com.oceanier.dao.OrderDao;
import com.oceanier.entity.Order;
import com.oceanier.vo.order.CustomOrder;
import com.oceanier.vo.order.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public void insertOrder(Order order) {
        orderDao.insertOrder(order);
    }

    public Order queryOrderById(int id) {
        return orderDao.queryOrderById(id);
    }

    public void deleteOrderById(int id) {
        orderDao.deleteOrderById(id);
    }

    public List<Order> queryOrderByUserId(int userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    public List<Order> queryOrderByMerchantId(int merchantId) {
        return orderDao.queryOrderByMerchantId(merchantId);
    }

    public void updateOrderPayState(int payState, int id, int payType) {
        OrderVo orderVo = new OrderVo();
        CustomOrder customOrder = new CustomOrder();
        customOrder.setPayState(payState);
        customOrder.setId(id);
        customOrder.setPayType(payType);
        orderVo.setCustomOrder(customOrder);
        orderDao.updateOrderPayState(orderVo);
    }
}
