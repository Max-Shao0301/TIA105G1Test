package com.apply.model;

import java.util.List;

public interface ApplyDAO_interface {
	public void insert(ApplyVO applyVO);
	public void update(ApplyVO applyVO);
	public void delete(Integer applyId);
	public ApplyVO findByPrimaryKey(Integer applyId);
	public List<ApplyVO> getAll();
}
