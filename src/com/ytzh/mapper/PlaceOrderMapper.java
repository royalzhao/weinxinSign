package com.ytzh.mapper;

import com.ytzh.pojo.Orders;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;

public interface PlaceOrderMapper {

	public int saveOrder(Orders orders);
	
	//查询用户签到积分数
	public Vip selectIntegration(WeixinUserInfo weixinUserInfo);

}
