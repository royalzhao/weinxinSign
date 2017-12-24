package com.ytzh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ytzh.pojo.Goods;
import com.ytzh.service.GoodService;
/**
 * 兑换商城*/
@Controller
public class GoodController {
	@Autowired
	private GoodService goodService;
	
	/**
	 * 货柜展示*/
	@RequestMapping(value="/showContainer",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showContainer(){
		List<Goods> goodsList= goodService.selectGoodList();
		return JSON.toJSONString(goodsList);
	}
	/**商品详情*/
	@RequestMapping(value="/goodById",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String goodById(@ModelAttribute Goods good){
		return JSON.toJSONString("");
	}
}
