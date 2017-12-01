package com.ytzh.pojo;

public class WeiXinOauth2Token {
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String errcode;
	private String errmsg;
	
	
	public WeiXinOauth2Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeiXinOauth2Token(String accessToken, String expiresIn,
			String refreshToken, String openid, String scope) {
		super();
		this.access_token = accessToken;
		this.expires_in = expiresIn;
		this.refresh_token = refreshToken;
		this.openid = openid;
		this.scope = scope;
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}
	
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expiresIn) {
		expires_in = expiresIn;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refreshToken) {
		refresh_token = refreshToken;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "WeiXinOauth2Token [access_token=" + access_token + ", errcode="
				+ errcode + ", errmsg=" + errmsg + ", expires_in=" + expires_in
				+ ", openid=" + openid + ", refresh_token=" + refresh_token
				+ ", scope=" + scope + "]";
	}
	
}
