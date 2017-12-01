package com.ytzh.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.UserInfoService;

@Controller
public class WeiXinController {
	public static Logger logger = Logger.getLogger(WeiXinController.class);
	
	@Autowired
	private UserInfoService userInfoService;
	/***
	 * 验证用户信息*/
	@RequestMapping(value="/authorization",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAuthorizationCode(@ModelAttribute String code){
		if(code!=null){
			//第二步 获取accesstekon及openid
			WeiXinOauth2Token weiXinOauth2Token=userInfoService.getAccessToken(code);
			if(weiXinOauth2Token==null){
				logger.error("weiXinOauth2Token结果为null 获取accesstekon失败");
				return "授权失败请返回刷新";
			}
			//验证用户是否已存在
			List<WeixinUserInfo> userInFolist=userInfoService.selectUserIn(weiXinOauth2Token);
			if(userInFolist!=null){
				String userInFoJson=JSON.toJSONString(userInFolist);
				//返回用户信息
				return userInFoJson;
			}else{//拉取用户信息
					
				//根据accesstekon及openid拉取用户信息 存入数据库
				int result=userInfoService.getUserInFo(weiXinOauth2Token);
				if(result==1){
					
					logger.info("用户信息存储成功");
				}else if(result==0){
					logger.info("用户信息存储失败");
				}
				return "sign_in_first";
			}
			
		}else{
			logger.error("code获取为Null");
			return "授权失败请返回刷新";
		}
	}
	/**
	 *签到 */
	@RequestMapping(value="/sign_in",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String sign_in(@ModelAttribute WeixinUserInfo openid){
		
		int result=userInfoService.sign_in(openid);
		
		if(result==1){
			return "签到成功";
		}else if(result==0){
			return "签到失败请重新刷新";
		}else{
			return "您已签到";
		}
		
	}
	@RequestMapping(value="/test",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String test(@ModelAttribute WeixinUserInfo weixinUserInfo){
		System.out.println(weixinUserInfo);
		int result=userInfoService.sign_in(weixinUserInfo);
		
		if(result==1){
			return "签到成功";
		}else if(result==0){
			return "签到失败请重新刷新";
		}else{
			return "您已签到";
		}
		
	}
}
