package com.oceanier.service;

import com.oceanier.dao.OrderDao;
import com.oceanier.entity.Order;
import com.oceanier.vo.order.CustomOrder;
import com.oceanier.vo.order.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

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

    public List<Order> listOrder() {
        return orderDao.listOrder();
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

    public void updateOrderByTradeSerialNumber(int payState, String tradeSerialNumber, int payType, Date payTime) {
        OrderVo orderVo = new OrderVo();
        CustomOrder customOrder = new CustomOrder();
        customOrder.setPayState(payState);
        customOrder.setTradeSerialNumber(tradeSerialNumber);
        customOrder.setPayType(payType);
        customOrder.setPayTime(payTime);
        orderVo.setCustomOrder(customOrder);
        orderDao.updateOrderByTradeSerialNumber(orderVo);
    }

    public void updateOrderByTradeSerialNumber1(int payState, String tradeSerialNumber) {
        Order order = new Order();
        order.setTradeSerialNumber(tradeSerialNumber);
        order.setPayState(payState);
        orderDao.updateOrderByTradeSerialNumber1(order);
    }

    public void updateFlagById(int flag, int id) {
        Order order = new Order();
        order.setId(id);
        order.setOrderFlag(flag);
        orderDao.updateFlag(order);
    }
}
