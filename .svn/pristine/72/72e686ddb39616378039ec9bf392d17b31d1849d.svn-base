package com.darling.util;

import com.darling.model.UserInfo;

import android.content.SharedPreferences;

public class GlobalVariable {

	public static UserInfo userInfo;
	public static SharedPreferences userData;
	public static SharedPreferences workArea;
	public static SharedPreferences reportPeople;
	public static SharedPreferences noAttention;
	public static String deviceId;//当前设备ID号
	public static boolean is_registering = false;
	//DownloadManager所使用的函数参数用以确定下载类型
	public enum downloadType {
		QSHDB, APK;
	}
	
	/**
	 * 获取用户是否登陆的信息
	 * @return 登陆为true，未登录为false
	 */
	public static boolean isUserLogin(){
		boolean isLogin = userData.getBoolean("IS_LOGIN", false);
		return isLogin;
	}
}
