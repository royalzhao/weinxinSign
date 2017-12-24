package com.ytzh.mapper;

import java.util.List;

import com.ytzh.pojo.Orders;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;

public interface PlaceOrderMapper {
	//下单
	public int saveOrder(Orders orders);
	//结算
	public int settleAccounts(Orders orders);
	
	//查询用户签到积分数
	public Vip selectIntegration(WeixinUserInfo weixinUserInfo);
	//查询订单
	public List<Orders> selectOrder(WeixinUserInfo weixinUserInfo);
	//确认收货
	public int firmOrder(Orders order);
	

}
