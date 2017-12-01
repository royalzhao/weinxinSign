package com.ytzh.pojo;

public class WeixinUserInfo {
	// 用户的标识
    private String openid;
    // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
    private String subscribe;
    // 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    private String subscribeTime;
    // 昵称
    private String nickname;
    // 用户的性别（1是男性，2是女性，0是未知）
    private String sex;
    // 用户所在国家
    private String country;
    // 用户所在省份
    private String province;
    // 用户所在城市
    private String city;
    // 用户的语言，简体中文为zh_CN
    private String language;
    // 用户头像
    private String headimgurl;
    //用户特权
    private String privilege;
    private String unionid;
    //用户积分
    private String sign_in_integration;
    //签到时间
    private String s_date;
    
	
	public WeixinUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeixinUserInfo(String openid, String nickname, String sex,
			String province, String city, String country,
			String headimgurl, String privilege, String unionid) {
		this.openid=openid;
		this.city=city;
		this.country=country;
		this.headimgurl=headimgurl;
		this.nickname=nickname;
		this.privilege=privilege;
		this.province=province;
		this.sex=sex;
		this.unionid=unionid;
	}
	public String getSign_in_integration() {
		return sign_in_integration;
	}
	public void setSign_in_integration(String signInIntegration) {
		sign_in_integration = signInIntegration;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String sDate) {
		s_date = sDate;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public String toString() {
		return "WeixinUserInfo [city=" + city + ", country=" + country
				+ ", headimgurl=" + headimgurl + ", language=" + language
				+ ", nickname=" + nickname + ", openid=" + openid
				+ ", privilege=" + privilege + ", province=" + province
				+ ", s_date=" + s_date + ", sex=" + sex
				+ ", sign_in_integration=" + sign_in_integration
				+ ", subscribe=" + subscribe + ", subscribeTime="
				+ subscribeTime + ", unionid=" + unionid + "]";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
    
    
}
