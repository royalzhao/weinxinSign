package com.ytzh.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderUtil {
	public static String getOrderNum(){
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat df2 = new SimpleDateFormat("HH");
		
		long currentTimeMillis=System.currentTimeMillis();
		String order_num=df.format(new Date())+currentTimeMillis+df2.format(new Date());
		return order_num;
		
	}
	
}
