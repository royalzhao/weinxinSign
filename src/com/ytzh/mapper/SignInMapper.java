package com.ytzh.mapper;

import java.util.List;
import java.util.Map;

import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;

public interface SignInMapper {

	public Map<String, Object> selectSign(WeixinUserInfo weixinUserInfo);

	public int doSignin(WeixinUserInfo weixinUserInfo);

	public int firstSign(WeixinUserInfo weixinUserInfo);
	//新增签到记录
	public void sign_record(WeixinUserInfo weixinUserInfo);
	//签到页会员信息查询
	public Vip selectVip(WeixinUserInfo weixinUserInfo);
	//签到记录
	public List<Map<String, Object>> signListByOid(WeixinUserInfo weixinUserInfo);
	//签到排名列表
	public List<Map<String, Object>> sign_order();
	//当日签到人数
	public Map<String, Object> signCount();
	//排名前十积分+5
	public void integration_receive(WeixinUserInfo weixinUserInfo);
	
}
