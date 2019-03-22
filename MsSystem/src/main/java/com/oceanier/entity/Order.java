package com.oceanier.entity;

import java.util.Date;

/*
  秒杀订单
 */
public class Order {

    private int id;//订单id
    private int productId;//商品id
    private int payAmount;//支付金额
    private int userId;//用户id
    private int merchantId;//商家id
    private Date createTime;//创建时间
    private Date payTime;//支付时间
    private int payState;//支付状态 1.未支付 2.已支付 3.退款成功 4.发起退款 5.退款失败
    private String receivingAddress;//收货地址
    private String receivingName;//收货人姓名
    private int receivingPhone;//收货人电话
    private String tradeSerialNumber;//交易流水号
    private int count;//数量
    private int payType;//支付类型 1支付宝 2微信 3银联

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName;
    }

    public int getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(int receivingPhone) {
        this.receivingPhone = receivingPhone;
    }

    public String getTradeSerialNumber() {
        return tradeSerialNumber;
    }

    public void setTradeSerialNumber(String tradeSerialNumber) {
        this.tradeSerialNumber = tradeSerialNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }
}
