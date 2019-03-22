package com.oceanier.vo.product;

import com.oceanier.entity.Product;

import java.util.Date;

public class CustomProduct extends Product {

    //秒杀价格范围
    private int startMiaoshaPrice;//起始
    private int endMiaoshaPrice;//结束

    //原价范围
    private int startOriginalPrice;
    private int endOriginalPrice;

    //申请时间范围
    private String startApplyDate;//开始
    private String endApplyDate;//结束

    //审核时间范围
    private String startAuditDate;
    private String endAuditDate;

    //秒杀开始时间范围
    private String startStartDate;
    private String endStartDate;

    //秒杀结束时间范围
    private String startEndDate;
    private String endEndDate;

    //商品数范围
    private int startProductCount;
    private int endProductCount;

    //库存量范围
    private int startStockCount;
    private int endStockCount;

    public int getStartMiaoshaPrice() {
        return startMiaoshaPrice;
    }

    public void setStartMiaoshaPrice(int startMiaoshaPrice) {
        this.startMiaoshaPrice = startMiaoshaPrice;
    }

    public int getEndMiaoshaPrice() {
        return endMiaoshaPrice;
    }

    public void setEndMiaoshaPrice(int endMiaoshaPrice) {
        this.endMiaoshaPrice = endMiaoshaPrice;
    }

    public int getStartOriginalPrice() {
        return startOriginalPrice;
    }

    public void setStartOriginalPrice(int startOriginalPrice) {
        this.startOriginalPrice = startOriginalPrice;
    }

    public int getEndOriginalPrice() {
        return endOriginalPrice;
    }

    public void setEndOriginalPrice(int endOriginalPrice) {
        this.endOriginalPrice = endOriginalPrice;
    }

    public String getStartApplyDate() {
        return startApplyDate;
    }

    public void setStartApplyDate(String startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    public String getEndApplyDate() {
        return endApplyDate;
    }

    public void setEndApplyDate(String endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    public String getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(String startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public String getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(String endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public String getStartStartDate() {
        return startStartDate;
    }

    public void setStartStartDate(String startStartDate) {
        this.startStartDate = startStartDate;
    }

    public String getEndStartDate() {
        return endStartDate;
    }

    public void setEndStartDate(String endStartDate) {
        this.endStartDate = endStartDate;
    }

    public String getStartEndDate() {
        return startEndDate;
    }

    public void setStartEndDate(String startEndDate) {
        this.startEndDate = startEndDate;
    }

    public String getEndEndDate() {
        return endEndDate;
    }

    public void setEndEndDate(String endEndDate) {
        this.endEndDate = endEndDate;
    }

    public int getStartProductCount() {
        return startProductCount;
    }

    public void setStartProductCount(int startProductCount) {
        this.startProductCount = startProductCount;
    }

    public int getEndProductCount() {
        return endProductCount;
    }

    public void setEndProductCount(int endProductCount) {
        this.endProductCount = endProductCount;
    }

    public int getStartStockCount() {
        return startStockCount;
    }

    public void setStartStockCount(int startStockCount) {
        this.startStockCount = startStockCount;
    }

    public int getEndStockCount() {
        return endStockCount;
    }

    public void setEndStockCount(int endStockCount) {
        this.endStockCount = endStockCount;
    }
}
