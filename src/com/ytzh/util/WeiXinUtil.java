package com.ytzh.util;

import org.apache.log4j.Logger;

import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;

import net.sf.json.JSONObject;

public class WeiXinUtil {
	//公众号appIP
	private static final String APPID = "wxe0f9974fb42fff1a";
	//公众号appSecret
	private static final String APPSECRET = "30010a7b6b86f802ed23efa7d716d903";
	//回调链接
	private static final String REDIRECT_URL="http://www.ackao.cn/shop/index.do";
	//获取code url
	private static final String GET_CODE_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE&connect_redirect=1#wechat_redirect";
	//获取用户信息方式:scope=snsapi_base静默获取openid;scope=snsapi_userinfo授权页获取用户信息
	private static final String SCOPE="snsapi_userinfo";
	
	//获取access_token
	private static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新access_token
	private static final String REFRESH_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//拉取用户信息
	private static final String GET_USERINFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//检验授权凭证（access_token）是否有效
	private static final String VERIFY_ACCESS_TOKEN="https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
	private static Logger log=Logger.getLogger(WeiXinUtil.class);
	/**
	 * 获取code*/
	public static String getCode(){
		String requestUrl=GET_CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI", REDIRECT_URL).replace("SCOPE", SCOPE);
		//String  j=HttpsGetUtil.httpRequestVoid(requestUrl, "GET", null);
		return requestUrl;
	}
	/**
	 * 用户授权后获取access_token及openid*/
	public static WeiXinOauth2Token getAccessToken(String code) {
		WeiXinOauth2Token weiXinOauth2Token=null;
		String requestUrl=GET_ACCESS_TOKEN.replace("APPID", APPID).replace("SECRET", APPSECRET).replace("CODE", code);
		//使用Http发送url获取access_token_json
		JSONObject access_token_json=HttpsGetUtil.httpRequest(requestUrl, "GET", null);
		if(access_token_json!=null){
			try{
				String access_token=access_token_json.getString("access_token");
				String expires_in=access_token_json.getString("expires_in");
				String refresh_token=access_token_json.getString("refresh_token");
				String openid=access_token_json.getString("openid");
				String scope=access_token_json.getString("scope");
				//封装access_token_json
				weiXinOauth2Token=new WeiXinOauth2Token(access_token,expires_in,refresh_token,openid,scope);
				return weiXinOauth2Token;
			}catch (Exception e) {
				String errorCode = access_token_json.getString("errcode");
                String errorMsg = access_token_json.getString("errmsg");
                e.printStackTrace();
                log.error("网页授权凭证GET_ACCESS_TOKEN()失败 errcode:"+errorCode+",errMsg:"+errorMsg);
			}
		}else{
			log.error("获取access_token_json为null http获取access_token_json失败!");
		}
		return weiXinOauth2Token;
	}
	/**
	 * 获取微信用户信息*/
	public static WeixinUserInfo getUserInFo(WeiXinOauth2Token weiXinOauth2Token) {
		WeixinUserInfo weixinUserInfo=null;
		 // 拼接请求地址
		String get_userInFo_url=GET_USERINFO_URL.replace("ACCESS_TOKEN", weiXinOauth2Token.getAccess_token()).replace("OPENID", weiXinOauth2Token.getOpenid());
		 // 获取用户信息
		JSONObject userInFo=HttpsGetUtil.httpRequest(get_userInFo_url, "GET", null);
		if(userInFo!=null){
			try{
				String openid=userInFo.getString("openid");
				String nickname=userInFo.getString("nickname");
				String sex=userInFo.getString("sex");
				String province=userInFo.getString("province");
				String city=userInFo.getString("city");
				String country=userInFo.getString("country");
				String headimgurl=userInFo.getString("headimgurl");
//				String privilege=userInFo.getString("privilege");
//				String unionid=userInFo.getString("unionid");
				weixinUserInfo=new WeixinUserInfo(openid,nickname,sex,province,city,country,headimgurl);
			}catch (Exception e) {
				String errorCode = userInFo.getString("errcode");
                String errorMsg = userInFo.getString("errmsg");  
                System.out.println("拉取用户信息失败 errcode:"+errorCode+",errMsg:"+errorMsg); 
			}
		}else{
			log.error("access_token_json为null http获取access_token_json失败!");
		}
		return weixinUserInfo;
	}
	/***
	 * 刷新access_token*/
	public static WeiXinOauth2Token refresh_token(String refresh_token){
		WeiXinOauth2Token weiXinOauth2Token=null;
		String requestUrl=REFRESH_TOKEN_URL.replace("APPID", APPID).replace("REFRESH_TOKEN", refresh_token);
		//发送请求刷新refresh_token
		JSONObject refresh_token_json=HttpsGetUtil.httpRequest(requestUrl, "GET", null);
		if(refresh_token_json!=null){
			try{
				String access_token=refresh_token_json.getString("access_token");
				String expires_in=refresh_token_json.getString("expires_in");
				String refresh_token_new=refresh_token_json.getString("refresh_token");
				String openid=refresh_token_json.getString("openid");
				String scope=refresh_token_json.getString("scope");
				//封装access_token_json
				weiXinOauth2Token=new WeiXinOauth2Token(access_token,expires_in,refresh_token_new,openid,scope);
				return weiXinOauth2Token;
			}catch (Exception e) {
				String errorCode = refresh_token_json.getString("errcode");
                String errorMsg = refresh_token_json.getString("errmsg");
                e.printStackTrace();
                log.error("刷新失败 refresh_token errcode:"+errorCode+",errMsg:"+errorMsg);
			}
		}else{
			log.error("获取refresh_token_json为null http获取refresh_token_json失败!");
		}
		return weiXinOauth2Token;
	}
	/****
	 *检验授权凭证（access_token）是否有效 */
	public static JSONObject access_token_chick(String access_token,String openid){
		String requestUrl=VERIFY_ACCESS_TOKEN.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
		JSONObject chick_json=HttpsGetUtil.httpRequest(requestUrl, "GET", null);
		return chick_json;
	}
	//第一步：用户同意授权，获取code 前端完成
	//第二步：通过code换取网页授权access_token
	//第三步：刷新access_token（如果需要）
	//第四步：拉取用户信息(需scope为 snsapi_userinfo)
	
	
}
