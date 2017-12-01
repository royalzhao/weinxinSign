package com.ytzh.service;

import java.util.List;
import java.util.Map;

import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;

public interface UserInfoService {
	//public String getAuthorizationCode();

	public WeiXinOauth2Token getAccessToken(String code);

	public List<WeixinUserInfo> selectUserIn(WeiXinOauth2Token weiXinOauth2Token);

	public int getUserInFo(WeiXinOauth2Token weiXinOauth2Token);

	public int sign_in(WeixinUserInfo openid);

	
}
