package com.ytzh.service;

import java.util.List;
import java.util.Map;

import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;

public interface SignService {
	//签到
	public int doSignin(WeixinUserInfo weixinUserInfo);
	//签到页会员信息查询
	public Vip selectVip(WeixinUserInfo weixinUserInfo);
	//签到记录
	public List<Map<String, Object>> signListByOid(WeixinUserInfo weixinUserInfo);
	//签到排名列表
	public List<Map<String, Object>> sign_order();
	//当日签到人数
	public Map<String, Object> signCount();
	
}
