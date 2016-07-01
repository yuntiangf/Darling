package com.darling.activity;

import com.darling.R;
import com.darling.activity.OneMinuteShakeActivity.ShakeCallBack;
import com.darling.util.HttpResultAnalysisUtil;
import com.darling.util.HttpUtils;
import com.darling.util.HttpUtils.CallBack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class BrandActivity extends FragmentActivity {

	private String _strBrand;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Intent intent=getIntent();
		_strBrand=intent.getStringExtra("brand");
		
		setContentView(R.layout.brand_zara);
		initialEvents();
	}
	
	private void initialEvents(){
		ImageView backBtn=(ImageView) findViewById(R.id.title_back);
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				finish();				
			}
			
		});
		
		//搭配购
		ImageView buyBtn=(ImageView) findViewById(R.id.brand_buy);
		buyBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				ShakeCallBack shakeCallBack = null;
				shakeCallBack=new ShakeCallBack();
				
				String queryURL="http://1zou.me/api/getthelook";
				HttpUtils.doGetAsyn(queryURL, shakeCallBack);			
			}
			
		});
	}
	
	class ShakeCallBack implements CallBack {

		@Override
		public void onRequestComplete(String result) {
			if(result.isEmpty()) {
				Toast.makeText(getApplicationContext(), "没有获取到数据", Toast.LENGTH_SHORT).show();
				return;
			}
			try{
				HttpResultAnalysisUtil analysisUtil=new 
						HttpResultAnalysisUtil(1,result,"搭配购","brand_buyall",BrandActivity.this);				
				Intent intent=analysisUtil.AnalysisResult();
				startActivityForResult(intent,1);
				
			}
			catch(Exception ex){
				Log.i("mushroom", ex.getMessage());
				return;
			}
		}
	}

}
