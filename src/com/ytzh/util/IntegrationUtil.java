package com.ytzh.util;

public class IntegrationUtil {
	//签到积分奖励
	public static int signReceive(int signInIntegration, int i) {
		int inIntegration=signInIntegration+=i;
		return inIntegration;
	}
	

}
