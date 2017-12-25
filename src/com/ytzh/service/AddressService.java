package com.ytzh.service;

import java.util.List;

import com.ytzh.pojo.Address;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;

public interface AddressService {
	/***
	 * 新增收货地址*/
	public int saveAddress(Address address);
	/**
	 * 修改收货地址*/
	public int updateAddress(Address address);
	/**
	 * 查看收货地址*/
	public List<Address> selectAddress(WeixinUserInfo openid);
	/**
	 * 删除收货地址*/
	public int deleteAddress(Address address);
	//查询地址信息ByID
	public Address selectAddressById(Address address);
	//查询默认地址
	public Address selectDefaultAddress(WeixinUserInfo weixinUserInfo);
	//修改地址状态
	public int updateAddressSate(WeixinUserInfo weixinUserInfo,Address address);
	
}
