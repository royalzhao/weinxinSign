package com.ytzh.pojo;

public class Address {
	//收件人姓名
	private String e_name;
	//收件人电话
	private String telephone;
	//用户微信openid
	private String openid;
	//收件人详细地址
	private String full_address;
	//邮编
	private String zip_code;
	//收件人地址
	private String e_address;
	//id
	private String address_id;
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String eName) {
		e_name = eName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String fullAddress) {
		full_address = fullAddress;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zipCode) {
		zip_code = zipCode;
	}
	public String getE_address() {
		return e_address;
	}
	public void setE_address(String eAddress) {
		e_address = eAddress;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String addressId) {
		address_id = addressId;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", e_address=" + e_address
				+ ", e_name=" + e_name + ", full_address=" + full_address
				+ ", openid=" + openid + ", telephone=" + telephone
				+ ", zip_code=" + zip_code + "]";
	}
	
	
	
	
	
}
