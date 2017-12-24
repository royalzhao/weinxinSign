package com.ytzh.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytzh.pojo.Goods;
import com.ytzh.pojo.Orders;

import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.PlaceOrderService;



@Controller
public class PlaceOrderController {
	@Autowired 
	private PlaceOrderService placeOrderService;
	/****
	 * 下单验证*/
	@RequestMapping(value="/pOrderReady",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String pOrderReady(HttpServletRequest request,@ModelAttribute Goods good){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		int result=placeOrderService.pOrderReady(weixinUserInfo,good);
		return result+"";
	}
	
	/***
	 * 下单结算*/
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String placeOrder(HttpServletRequest request,@ModelAttribute Orders orders){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		orders.setOpenid(weixinUserInfo.getOpenid());
		int result=placeOrderService.creatOrder(orders);	
		return result+"";
	}
}