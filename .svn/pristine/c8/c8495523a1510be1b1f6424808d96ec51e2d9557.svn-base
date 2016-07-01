package com.darling.activity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Toast;

import com.darling.R;
import com.darling.ui.ShakeResult2;
import com.darling.ui.ShakeResult3;
import com.darling.ui.ShakeResult4;
import com.darling.ui.ShakeResult5;
import com.darling.ui.ShakeResult6;
import com.darling.ui.ShakeResult7;
import com.darling.ui.ShakeResult8;
import com.darling.ui.ShakeResult9;
import com.darling.util.HttpResultAnalysisUtil;
import com.darling.util.HttpUtils;
import com.darling.util.HttpUtils.CallBack;
import com.darling.util.ImageUtil;
import com.darling.util.ShakeListenerUtils;
import com.darling.util.ShakeListenerUtils.OnShakeListener;

public class OneMinuteShakeActivity extends BaseFragmentActivity {
	
	Vibrator mVibrator;
	ShakeListenerUtils mShakeListener = null;
	private RelativeLayout mImgUp;
	private RelativeLayout mImgDn;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));		
		setContentView(R.layout.one_minute_shake);
		
		mVibrator=(Vibrator)getApplication().getSystemService(VIBRATOR_SERVICE);
		mImgUp = (RelativeLayout) findViewById(R.id.shakeImgUp);
		mImgDn = (RelativeLayout) findViewById(R.id.shakeImgDown);
		
		//关闭监听：mShakeListener.stop();
		
		mShakeListener=new ShakeListenerUtils(OneMinuteShakeActivity.this);
		mShakeListener.setOnShakeListener(new OnShakeListener(){

			@Override
			public void onShake() {
				//上下分离
				startAnim();
				mShakeListener.stop();
				
				startVibrato();
				new Handler().postDelayed(new Runnable(){

					@Override
					public void run() {
					   //震动停止显示结果
					   mVibrator.cancel();					   
					   showShakeResult();	
					}					
				}, 2000);
							
			}
			
		});
		
	}
	
	/**
	 * 再摇一次
	 * @author:MushRoom
	 * @date:2015-12-27 下午2:23:23
	 * @param v
	 */
	@SuppressWarnings("deprecation")
	public void returnShake(View v){
		mShakeListener.start();
	}
	
	/**
	 * 显示摇一摇结果
	 * @author:MushRoom
	 * @date:2015-12-22 下午9:05:49
	 */
	private void showShakeResult(){

		ShakeCallBack shakeCallBack = null;
		shakeCallBack=new ShakeCallBack();
		
		String queryURL="http://1zou.me/api/shake/1";
		HttpUtils.doGetAsyn(queryURL, shakeCallBack);
		
		
	}
	
	/**
	 * 摇一摇http请求回调类
	 * @author:MushRoom
	 * @date:2016-1-5 下午11:16:46
	 */
	class ShakeCallBack implements CallBack {

		@Override
		public void onRequestComplete(String result) {
			if(result.isEmpty()) {
				Toast.makeText(getApplicationContext(), "没有获取到数据", Toast.LENGTH_SHORT).show();
				mShakeListener.start();
				return;
			}
			try{
				HttpResultAnalysisUtil analysisUtil=new 
						HttpResultAnalysisUtil(1,result,"一分钟摇一摇","todaybest",OneMinuteShakeActivity.this);				
				Intent intent=analysisUtil.AnalysisResult();
				startActivityForResult(intent,1);
				
			}
			catch(Exception ex){
				mShakeListener.start();
				return;
			}
		}
	}
		
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		mShakeListener.start();
	}
	
	
	/**
	 * 动画效果 上下分离
	 * @author:MushRoom
	 * @date:2016-1-23 下午7:10:11
	 */
	public void startAnim () {   
		AnimationSet animup = new AnimationSet(true);
		TranslateAnimation mytranslateanimup0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.5f);
		mytranslateanimup0.setDuration(1000);
		TranslateAnimation mytranslateanimup1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.5f);
		mytranslateanimup1.setDuration(1000);
		mytranslateanimup1.setStartOffset(1000);
		animup.addAnimation(mytranslateanimup0);
		animup.addAnimation(mytranslateanimup1);
		mImgUp.startAnimation(animup);
		
		AnimationSet animdn = new AnimationSet(true);
		TranslateAnimation mytranslateanimdn0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.5f);
		mytranslateanimdn0.setDuration(1000);
		TranslateAnimation mytranslateanimdn1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.5f);
		mytranslateanimdn1.setDuration(1000);
		mytranslateanimdn1.setStartOffset(1000);
		animdn.addAnimation(mytranslateanimdn0);
		animdn.addAnimation(mytranslateanimdn1);
		mImgDn.startAnimation(animdn);	
	}
	
	/**
	 * 手机震动
	 * @author:MushRoom
	 * @date:2016-1-23 下午7:10:55
	 */
	public void startVibrato(){	
		MediaPlayer player;
		player = MediaPlayer.create(this, R.raw.awe);
		player.setLooping(false);
        player.start();		
		
		//定义震动
		mVibrator.vibrate( new long[]{500,200,500,200}, -1); 
		//第一个｛｝里面是节奏数组， 第二个参数是重复次数，-1为不重复，非-1俄日从pattern的指定下标开始重复
	}
	
	/**
	 * 
	 * @author:MushRoom
	 * @date:2015-12-21 下午11:12:16
	 * @param v
	 */
	public void shake_activity_back(View v){
		this.finish();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mShakeListener != null) {
			mShakeListener.stop();
		}
	}
}
