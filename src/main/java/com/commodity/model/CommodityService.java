package com.commodity.model;

import java.util.List;

public class CommodityService {
	
	private CommodityDAO_interface dao;
	
	public CommodityService() {
		dao = new CommodityJDBCDAO();
	}
	
	public CommodityVO addCommodity(String name, String size) {
		
		CommodityVO commodityVO = new CommodityVO();
		
		commodityVO.setName(name);
		commodityVO.setSize(size);	
		dao.insert(commodityVO);
		
		return commodityVO;
		
	}
	
	public CommodityVO updateCommodity(Integer commodity_id, String name, Integer status, String size) {
		
		CommodityVO commodityVO = new CommodityVO();
		
		commodityVO.setCommodity_id(commodity_id);
		commodityVO.setName(name);
		commodityVO.setStatus(status);
		commodityVO.setSize(size);
		
		dao.update(commodityVO);
				
		return commodityVO;
	}
	
	public CommodityVO getOneCommodity(Integer commodity_id) {
		return dao.findbyPrimaryKey(commodity_id);
	}
	
	public List<CommodityVO> getAll(){
		return dao.getAll();
	}
}
