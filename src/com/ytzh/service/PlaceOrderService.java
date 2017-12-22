package com.ytzh.service;

import java.util.List;

import com.ytzh.pojo.Orders;

public interface PlaceOrderService {
	/***
	 * 下单*/
	 public int creatOrder(Orders orders);
	 /**
	  * 订单查询*/
	 
	 public List<Orders> selectOrder();
}
