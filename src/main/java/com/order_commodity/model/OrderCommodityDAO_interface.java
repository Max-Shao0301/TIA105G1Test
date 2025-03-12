package com.order_commodity.model;

import java.util.List;

public interface OrderCommodityDAO_interface {
    // 新增一筆預約商品記錄
    public void insert(OrderCommodityVO orderCommodityVO);

    // 更新一筆預約商品記錄
    public void update(OrderCommodityVO orderCommodityVO);

    // 根據預約商品編號刪除一筆記錄
    public void delete(Integer orderCommodityId);

    // 根據預約商品編號查詢一筆記錄
    public OrderCommodityVO findByPrimaryKey(Integer orderCommodityId);

    // 查詢所有預約商品記錄
    public List<OrderCommodityVO> getAll();
}