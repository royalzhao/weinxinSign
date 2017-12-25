package com.ytzh.mapper;

import java.util.List;

import com.ytzh.pojo.Address;
import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;

public interface AddressMapper {

	public int deleteAddress(Address address);

	public int saveAddress(Address address);

	public List<Address> selectAddress(WeixinUserInfo openid);

	public int updateAddress(Address address);
	//查询地址ById
	public Address selectAddressById(Address address);
	//查询默认地址
	public Address selectDefaultAddress(WeixinUserInfo weixinUserInfo);
	//修改地址状态为默认
	public int updateAddressSate(Address address);
	//修改地址状态为非默认
	public int AddressSateUnDefault(WeixinUserInfo weixinUserInfo);

}
