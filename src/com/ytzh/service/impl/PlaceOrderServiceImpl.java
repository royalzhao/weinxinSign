package com.ytzh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ytzh.mapper.PlaceOrderMapper;
import com.ytzh.pojo.Goods;
import com.ytzh.pojo.Orders;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;
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
	
	
	//下单结算
	@Override
	public int creatOrder(Orders orders) {
		String orderNum=OrderUtil.getOrderNum();
		orders.setOrder_num(orderNum);
		int result=placeOrderMapper.saveOrder(orders);
		
		return result;
	}
	//查询订单
	@Override
	public List<Orders> selectOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	//下单验证
	@Override
	public int pOrderReady(WeixinUserInfo weixinUserInfo,Goods good) {
		int result=0;
		Map<String,Object> map=new HashMap<String, Object>();
		//查询用户签到积分数
		Vip vip=placeOrderMapper.selectIntegration(weixinUserInfo);
		int sign_in_integration= Integer.parseInt(vip.getSign_in_integration()) ;
		int cost_integration=Integer.parseInt(good.getCost_integration()) ;
		//比较商品积分和用户积分
		if(sign_in_integration<cost_integration){
			return result;
		}else{
			result=1;
		}
		return result;
	}

	//积分余额查询
	@Override
	public Vip selectIntegration(WeixinUserInfo weixinUserInfo) {
		
		return placeOrderMapper.selectIntegration(weixinUserInfo);
	}

}
