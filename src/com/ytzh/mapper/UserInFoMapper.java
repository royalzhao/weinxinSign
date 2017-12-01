package com.ytzh.mapper;

import java.util.List;
import java.util.Map;

import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;

public interface UserInFoMapper {

	List<WeixinUserInfo> selectUserInByOID(WeiXinOauth2Token weiXinOauth2Token);

	int userInfoSave(WeixinUserInfo weixinUserInfo);

	Map<String, Object> sign_id_select(WeixinUserInfo openid);

	int sign_in(WeixinUserInfo openid);

	
	
}
