package com.ytzh.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ytzh.mapper.UserInFoMapper;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.UserInfoService;
import com.ytzh.util.WeiXinUtil;
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private UserInFoMapper userInFoMapper;
	
	/**
	 * 获取AccessToken**/
	@Override
	public WeiXinOauth2Token getAccessToken(String code) {
		WeiXinOauth2Token weiXinOauth2Token=WeiXinUtil.getAccessToken(code);
		return weiXinOauth2Token;
	}
	/**
	 * 验证用户是否存在 */
	@Override
	public List<WeixinUserInfo> selectUserIn(WeiXinOauth2Token weiXinOauth2Token) {
		//检查是否有该openid
		
		List<WeixinUserInfo> userInFolist= userInFoMapper.selectUserInByOID(weiXinOauth2Token);
		return userInFolist;
	}
	/***
	 * 拉取用户信息*/
	@Override
	public int getUserInFo(WeiXinOauth2Token weiXinOauth2Token) {
		int result=2;
		//拉取用户信息
		WeixinUserInfo weixinUserInfo =  WeiXinUtil.getUserInFo(weiXinOauth2Token);
		if(weixinUserInfo!=null){
			
			//将用户信息存入数据库
			result=userInFoMapper.userInfoSave(weixinUserInfo);
			return result;
		}else{
			return result;
		}
		
	}
	/**
	 * 签到送积分*/
	@Override
	public int sign_in(WeixinUserInfo openid) {
		int result=2;
		//签到验证
		Map<String,Object> map=userInFoMapper.sign_id_select(openid);
		
		String count=map.get("count").toString();

		if(count.equals("1")){
			
			return result;
		}else{
			
			//签到
			result=userInFoMapper.sign_in(openid);
		}
		return result;
	}
	

	

}
