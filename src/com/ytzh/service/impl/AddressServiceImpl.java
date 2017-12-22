package com.ytzh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ytzh.mapper.AddressMapper;
import com.ytzh.pojo.Address;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	private AddressMapper addressMapper;
	@Resource
	public void setAddressMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}
	
	/***删除收货地址*/
	@Override
	public int deleteAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.deleteAddress(address);
	}
	/***
	 * 新增收货地址*/
	@Override
	public int saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.saveAddress(address);
	}
	/**
	 * 查看收货地址*/
	@Override
	public List<Address> selectAddress(WeixinUserInfo openid) {
		// TODO Auto-generated method stub
		return addressMapper.selectAddress(openid);
	}
	/**
	 * 修改收货地址*/
	@Override
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.updateAddress(address);
	}

}
