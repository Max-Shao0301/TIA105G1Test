package com.order_commodity.model;

import java.io.Serializable;

public class OrderCommodityVO implements Serializable {
    private Integer orderCommodityId;  // 預約商品編號
    private Integer orderId;          // 訂單編號
    private Integer commodityId;      // 商品編號

    // Getter 和 Setter 方法
    public Integer getOrderCommodityId() {
        return orderCommodityId;
    }

    public void setOrderCommodityId(Integer orderCommodityId) {
        this.orderCommodityId = orderCommodityId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
}