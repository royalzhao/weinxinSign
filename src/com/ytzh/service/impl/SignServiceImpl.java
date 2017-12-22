package com.ytzh.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ytzh.mapper.SignInMapper;
import com.ytzh.pojo.Vip;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.SignService;
@Service
public class SignServiceImpl implements SignService {
	private SignInMapper signInMapper;
	@Resource
	public void setSignInMapper(SignInMapper signInMapper) {
		this.signInMapper = signInMapper;
	}

	//签到
	@Override
	public int doSignin(WeixinUserInfo weixinUserInfo) {
		int result =2;
		//签到查询
		Vip uVip=signInMapper.selectVip(weixinUserInfo);
		if(uVip!=null){
			//已签到 检查排名
			double rownum=Double.parseDouble(uVip.getRownum());
			if(rownum<=10.0){
				
				String state=uVip.getState();
				if(!state.equals("1")){
					//排名前十 积分+5
					signInMapper.integration_receive(weixinUserInfo);
				}
			}
			return result;
		}else{
			//签到
			result=signInMapper.doSignin(weixinUserInfo);
			if(result==1){
				//新增签到记录
				signInMapper.sign_record(weixinUserInfo);
				//签到成功
				return result;
			}else{
				//首次签到
				result=signInMapper.firstSign(weixinUserInfo);
				
				//新增签到记录
				signInMapper.sign_record(weixinUserInfo);
			}
		}
		return result;
	}
	//签到页会员信息查询
	@Override
	public Vip selectVip(WeixinUserInfo weixinUserInfo) {
		Vip uVip=signInMapper.selectVip(weixinUserInfo);
		return uVip;
	}
	//签到记录
	@Override
	public List<Map<String, Object>> signListByOid(WeixinUserInfo weixinUserInfo) {
		// TODO Auto-generated method stub
		return signInMapper.signListByOid(weixinUserInfo);
	}
	//签到排名列表
	@Override
	public List<Map<String, Object>> sign_order() {
		
		return signInMapper.sign_order();
	}
	//当日签到人数
	@Override
	public Map<String, Object> signCount() {
		
		return signInMapper.signCount();
	}

}
