package com.darling.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * 程序入口。需要判断是否为第一次运行
 * @author:MushRoom
 * @date:2015-11-22 下午8:02:11
 */
public class StartActivity extends Activity {

	 @Override
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			
			//判断是否为第一次登录
//			SharedPreferences setting =getSharedPreferences("check",MODE_PRIVATE);			
//			Boolean user_first=setting.getBoolean("firstload", true);
//			if(!user_first){
//				Intent intent=new Intent();
//				intent.setClass(this, WelcomeActivity.class);
//				this.startActivity(intent);
//				this.finish();
//			}
//			else{
//				setting.edit().putBoolean("firstload", false).commit();
//				Intent intent=new Intent();
//				intent.setClass(this, LeaderActivity.class);
//				this.startActivity(intent);
//				this.finish();				
//			}
			
			Intent intent=new Intent();
			intent.setClass(this, LeaderActivity.class);
			this.startActivity(intent);
			this.finish();
			
		}
}
