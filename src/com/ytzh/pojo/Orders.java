package com.ytzh.pojo;

public class Orders {
	//订单号
	private String order_num;
	//商品编号
	private String g_id;
	//商品数量
	private String g_num;
	//兑换积分
	private String exchange_integration;
	//订单状态
	private String state;
	//下单时间
	private String o_date;
	//收货地址
	private String address;
	//收件人姓名
	private String consignee;
	//收件人电话
	private String consignee_tele;
	//详细收货地址
	private String full_address;
	//邮编
	private String zip_code;
	//运单号
	private String tracking_num;
	//openid
	private String openid;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String orderNum) {
		order_num = orderNum;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String gId) {
		g_id = gId;
	}
	public String getG_num() {
		return g_num;
	}
	public void setG_num(String gNum) {
		g_num = gNum;
	}
	public String getExchange_integration() {
		return exchange_integration;
	}
	public void setExchange_integration(String exchangeIntegration) {
		exchange_integration = exchangeIntegration;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String oDate) {
		o_date = oDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsignee_tele() {
		return consignee_tele;
	}
	public void setConsignee_tele(String consigneeTele) {
		consignee_tele = consigneeTele;
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
	public String getTracking_num() {
		return tracking_num;
	}
	public void setTracking_num(String trackingNum) {
		tracking_num = trackingNum;
	}
	public Orders(String orderNum, String gId, String gNum,
			String exchangeIntegration, String state, String oDate,
			String address, String consignee, String consigneeTele,
			String fullAddress, String zipCode, String trackingNum,String openid) {
		super();
		this.order_num = orderNum;
		this.g_id = gId;
		this.g_num = gNum;
		this.exchange_integration = exchangeIntegration;
		this.state = state;
		this.o_date = oDate;
		this.address = address;
		this.consignee = consignee;
		this.consignee_tele = consigneeTele;
		this.full_address = fullAddress;
		this.zip_code = zipCode;
		this.tracking_num = trackingNum;
		this.openid=openid;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [address=" + address + ", consignee=" + consignee
				+ ", consignee_tele=" + consignee_tele
				+ ", exchange_integration=" + exchange_integration
				+ ", full_address=" + full_address + ", g_id=" + g_id
				+ ", g_num=" + g_num + ", o_date=" + o_date + ", openid="
				+ openid + ", order_num=" + order_num + ", state=" + state
				+ ", tracking_num=" + tracking_num + ", zip_code=" + zip_code
				+ "]";
	}
	
	
	
}
