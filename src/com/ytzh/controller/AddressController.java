package com.ytzh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ytzh.pojo.Address;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	/**地址新增*/
	@RequestMapping(value="/saveAddress",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addAddress(HttpServletRequest request,@ModelAttribute("address") Address address){
		int result=0;
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		address.setOpenid(weixinUserInfo.getOpenid());
		result=addressService.saveAddress(address);
		return result+"";
	}
	/**地址修改*/
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateAddress(@ModelAttribute Address address){
		int result=0;
		result=addressService.updateAddress(address);
		
		return result+"";
	}
	/**地址注销*/
	@RequestMapping(value="/deleteAddress",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteAddress(@ModelAttribute Address address){
		int result=0;
		result=addressService.deleteAddress(address);
		
		return result+"";
	}
	/**地址查询*/
	@RequestMapping(value="/selectAddress",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addresslist(HttpServletRequest request){
		WeixinUserInfo weixinUserInfo=(WeixinUserInfo) request.getSession().getAttribute("weixinUserInfo");
		if(weixinUserInfo==null){
			return "error";
		}
		List<Address> addresslist=addressService.selectAddress(weixinUserInfo);
		System.out.println(addresslist);
		return JSON.toJSONString(addresslist);
	}
	/***
	 * 地址查询ByID*/
	@RequestMapping(value="/selectAddressById",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectAddressById(@ModelAttribute Address address){
		
		address=addressService.selectAddressById(address);
		return JSON.toJSONString(address);
	}
}
