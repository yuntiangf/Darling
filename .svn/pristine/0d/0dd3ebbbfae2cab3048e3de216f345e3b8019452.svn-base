package com.darling.activity;

import java.io.InputStream;

import com.darling.R;
import com.darling.util.CommonTools;
import com.darling.widget.SelectableRoundedImageView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class FirstModelDetailActivity extends BaseFragmentActivity{

	private String userid;
	private String fileName;
	private AssetManager assetManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		userid=intent.getStringExtra("userid");
		fileName=intent.getStringExtra("imgSrc");
		
		setContentView(R.layout.first_model_detail);
		assetManager=this.getAssets();
		
		initValue();
		initEvents();
		
	}
	
	/**
	 * 初始化信息
	 * @author:MushRoom
	 * @date:2015-12-14 下午11:23:03
	 */
	public void initValue(){
		//初始化用户头像
		try {
			int imgSrc=CommonTools.getImageSrc(userid);
			SelectableRoundedImageView userHead=(SelectableRoundedImageView) findViewById(R.id.publisher_head);
			userHead.setScaleType(ScaleType.CENTER_CROP);
			userHead.setOval(true);
			userHead.setImageResource(imgSrc);
			
			userHead.setOnClickListener(new OnClickListener(){

				@SuppressLint("ShowToast") @Override
				public void onClick(View v) {
					gotoUserInfo(v);
				}
				
			});
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//初始化iconimg。
		try{
			ImageView iconImg=(ImageView) findViewById(R.id.icon_img);
			iconImg.setScaleType(ScaleType.CENTER_CROP);
			InputStream in=assetManager.open(fileName);
			Bitmap bmp=BitmapFactory.decodeStream(in);
			
			iconImg.setImageBitmap(bmp);
			
		}
		catch(Exception e){
			Log.i("mushroom",e.getMessage());
		}		
		
	}
	
	/**
	 * 初始化事件类
	 * @author:MushRoom
	 * @date:2016-2-4 下午3:57:44
	 */
	public void initEvents(){
		//返回键
		View btn=findViewById(R.id.title_back);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();				
			}			
		});
		
		//转向用户信息
		
		LinearLayout viewUserInfo=(LinearLayout) findViewById(R.id.publisher_info);
		viewUserInfo.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				gotoUserInfo(v);				
			}
			
		});
		
	}
	
	/**
	 * 跳转至用户信息
	 * @author:MushRoom
	 * @date:2016-2-5 下午4:51:35
	 * @param v
	 */
	private void gotoUserInfo(View v){
		Intent intent=new Intent(this.getApplicationContext(),UserInfoActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 点击单品进入单品详情页面	
	 * @author:MushRoom
	 * @date:2015-12-7 下午11:18:46
	 * @param view
	 */
	public void gotoItemDetail(View view){
		Intent intent=new Intent(this,FirstItemDetailActivity.class);
		startActivity(intent);
	}

}
