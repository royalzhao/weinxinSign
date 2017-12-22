package com.ytzh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ytzh.mapper.PlaceOrderMapper;
import com.ytzh.pojo.Orders;
import com.ytzh.service.PlaceOrderService;
import com.ytzh.util.OrderUtil;
@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
	private PlaceOrderMapper placeOrderMapper;
	@Resource
	public void setPlaceOrderMapper(PlaceOrderMapper placeOrderMapper) {
		this.placeOrderMapper = placeOrderMapper;
	}
	
	
	
	@Override
	public int creatOrder(Orders orders) {
		String orderNum=OrderUtil.getOrderNum();
		orders.setOrder_num(orderNum);
		int result=placeOrderMapper.saveOrder(orders);
		
		return result;
	}

	@Override
	public List<Orders> selectOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
