package com.ytzh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ytzh.pojo.Orders;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.PlaceOrderService;


@Controller
public class PersonController {
	@Autowired 
	private PlaceOrderService placeOrderService;
	/**
	 * 查询订单*/
	@RequestMapping(value="/selectOrder",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectOrder(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		List<Orders> myOrders=placeOrderService.selectOrder(weixinUserInfo);
		return JSON.toJSONString(myOrders);
	}
	/**积分余额查询*/
	@RequestMapping(value="/selectIntegration",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectIntegration(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		Vip vip=placeOrderService.selectIntegration(weixinUserInfo);
		return JSON.toJSONString(vip);
	}
	/***确认收货*/
	@RequestMapping(value="/firmOrder",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String firmOrder(HttpServletRequest request,@ModelAttribute Orders order){
		
		int result =placeOrderService.firmOrder(order);
		
		return result+"";
	}
	
	/**个人信息*/
	@RequestMapping(value="/getUserinfo",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserinfo(HttpServletRequest request,@ModelAttribute Orders order){
		
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		return JSON.toJSONString(weixinUserInfo);
	}
	
}
