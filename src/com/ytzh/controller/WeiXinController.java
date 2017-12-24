package com.ytzh.controller;




import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;




import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ytzh.pojo.WeiXinOauth2Token;
import com.ytzh.pojo.WeixinUserInfo;
import com.ytzh.util.WeiXinUtil;

@Controller
public class WeiXinController {
	public static Logger logger = Logger.getLogger(WeiXinController.class);
//	@Autowired
//	private UserInfoService userInfoService;
	@RequestMapping(value="/getCode",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String getCode(){
		String url=WeiXinUtil.getCode();
		return "redirect:"+url;
	}
	/**index*/
	@RequestMapping(value="/index",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String toIndex(HttpServletRequest req){
		//第二步 获取accesstekon及openid
//		WeiXinOauth2Token weiXinOauth2Token=null;
//		String code=req.getParameter("code");
//		if(code!=null||!code.equals("")){
//			//获取accesstekon及openid
//	  	    weiXinOauth2Token=WeiXinUtil.getAccessToken(code);
//	  	    //拉取用户信息
//	  	    WeixinUserInfo weixinUserInfo =  WeiXinUtil.getUserInFo(weiXinOauth2Token);
//	  	    System.out.println(weixinUserInfo+">>>>>>>>>>>>>>>>>>>>>weixinUserInfo");
//	  	    HttpSession session= req.getSession();
//	  	    session.setAttribute("weixinUserInfo", weixinUserInfo);
//		} 	
		 WeixinUserInfo weixinUserInfo=new WeixinUserInfo();
		 weixinUserInfo.setNickname("ssss");
		 weixinUserInfo.setOpenid("a");
		 HttpSession session= req.getSession();
		 session.setAttribute("weixinUserInfo", weixinUserInfo);
		 System.out.println(weixinUserInfo);
		return "/index.html";
	}
}
