package com.ytzh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ytzh.mapper.GoodMapper;
import com.ytzh.pojo.Goods;
import com.ytzh.service.GoodService;
@Service
public class GoodServiceImpl implements GoodService {
	private GoodMapper goodMapper;
	@Resource
	public void setGoodMapper(GoodMapper goodMapper) {
		this.goodMapper = goodMapper;
	}

	//商品列表
	@Override
	public List<Goods> selectGoodList() {
		
		return goodMapper.selectGoodList();
	}

}
