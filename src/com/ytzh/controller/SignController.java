package com.ytzh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.SignService;

@Controller
public class SignController {
	@Autowired
	private SignService signService;
	/**
	 * 签到*/
	@RequestMapping(value="/signIn",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public 	String signIn(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		int result=0;
		if(weixinUserInfo!=null){
			//签到
			result=signService.doSignin(weixinUserInfo);
		}
		return result+"";
	}
	
	/**
	 * 签到页会员信息查询*/
	@RequestMapping(value="/selectVip",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectVip(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		
		Vip uVip=signService.selectVip(weixinUserInfo);
		System.out.println(uVip+"uVip会员信息查询");
		return JSON.toJSONString(uVip);
	}
	
	/**
	 * 签到记录*/
	@RequestMapping(value="/signList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String signListByOid(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		List<Map<String,Object>> signList=signService.signListByOid(weixinUserInfo);
		System.out.println(signList+"signList签到记录列表");
		return JSON.toJSONString(signList);
	}
	
	/**
	 * 签到排名列表*/
	@RequestMapping(value="/orderLi",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String sign_order_list(HttpServletRequest request){
		List<Map<String, Object>> orderList=signService.sign_order();
		System.out.println(orderList+"orderList签到排名列表");
		return JSON.toJSONString(orderList);
	}
	/***当日签到人数*/
	@RequestMapping(value="/signCount",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String signCount(){
		Map<String,Object> signCount=signService.signCount();
		return JSON.toJSONString(signCount);
	}
}
