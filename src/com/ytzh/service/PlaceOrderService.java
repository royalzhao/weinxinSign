package com.ytzh.service;

import java.util.List;
import java.util.Map;

import com.ytzh.pojo.Goods;
import com.ytzh.pojo.Orders;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;

public interface PlaceOrderService {
	/***
	 * 下单*/
	public int creatOrder(Orders orders);
	 /**
	  * 订单查询
	 * @param weixinUserInfo */
	public List<Orders> selectOrder(WeixinUserInfo weixinUserInfo);
	//下单验证
	public int pOrderReady(WeixinUserInfo weixinUserInfo, Goods good);
	//积分余额查询
	public Vip selectIntegration(WeixinUserInfo weixinUserInfo);
}
