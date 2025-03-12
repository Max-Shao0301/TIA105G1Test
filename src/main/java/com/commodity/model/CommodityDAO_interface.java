package com.commodity.model;

import java.util.List;

public interface CommodityDAO_interface {
	public void insert(CommodityVO commodityVO);
	public void update(CommodityVO commodityVO);
	public CommodityVO findbyPrimaryKey(Integer commodity_id);
	public List<CommodityVO>getAll();
	
}
