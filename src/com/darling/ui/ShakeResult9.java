package com.darling.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.darling.R;
import com.darling.activity.BaseFragmentActivity;
import com.darling.util.CommonTools;
import com.darling.util.ImageUtil;
import com.darling.util.ImageUtil.ImageCallback;
import com.darling.model.LoadImageInfo;

public class ShakeResult9 extends BaseFragmentActivity {

	private String shake_model;
	//如果有褲子，則第一位
	private String shake_item1; 
	private String shake_item2;
	private String shake_item3;
	private String shake_item4;
	private String shake_item5;
	private String shake_item6;
	private String shake_item7;
	private String shake_item8;
	private String shake_item9;
	private String themeTitle;
	private String themePicPath;
	
	private ImageUtil imageUtil;
	private String imgHttpUrl="http://1zou.me/images/";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		Intent i=getIntent();	
		shake_model=i.getStringExtra("shake_model");
		shake_item1=i.getStringExtra("shake_item1");
		shake_item2=i.getStringExtra("shake_item2");	
		shake_item3=i.getStringExtra("shake_item3");	
		shake_item4=i.getStringExtra("shake_item4");	
		shake_item5=i.getStringExtra("shake_item5");
		shake_item6=i.getStringExtra("shake_item6");
		shake_item7=i.getStringExtra("shake_item7");
		shake_item8=i.getStringExtra("shake_item8");
		shake_item9=i.getStringExtra("shake_item9");
		
		themeTitle = i.getStringExtra("themeTitle");
		themePicPath = i.getStringExtra("themePicPath");

		setmTitleName(themeTitle);
		setContentView(R.layout.shake_result_seven);
		
		imageUtil=new ImageUtil(ShakeResult9.this);
		//初始化图片
		initialImages();

		initialBottom();
	}

	/**
	 * 初始化底部图片资源
	 * @author:MushRoom
	 * @date:2016-2-9 下午5:47:05
	 */
	private void initialBottom() {
		ImageView themeView=(ImageView) this.findViewById(R.id.themePic);
		try {
			themeView.setImageResource(CommonTools.getImageSrc(themePicPath));
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
	}
	
	private void initialImages(){
		List<LoadImageInfo> lstImages=new ArrayList<LoadImageInfo>();
		LoadImageInfo imgModel=new LoadImageInfo(shake_model,(ImageView) findViewById(R.id.shake_model));
		LoadImageInfo img1=new LoadImageInfo(shake_item1,(ImageView) findViewById(R.id.shake_item1));
		LoadImageInfo img2=new LoadImageInfo(shake_item2,(ImageView) findViewById(R.id.shake_item2));
		LoadImageInfo img3=new LoadImageInfo(shake_item3,(ImageView) findViewById(R.id.shake_item3));
		LoadImageInfo img4=new LoadImageInfo(shake_item4,(ImageView) findViewById(R.id.shake_item4));
		LoadImageInfo img5=new LoadImageInfo(shake_item5,(ImageView) findViewById(R.id.shake_item5));
		LoadImageInfo img6=new LoadImageInfo(shake_item6,(ImageView) findViewById(R.id.shake_item6));
		LoadImageInfo img7=new LoadImageInfo(shake_item7,(ImageView) findViewById(R.id.shake_item7));
		LoadImageInfo img8=new LoadImageInfo(shake_item8,(ImageView) findViewById(R.id.shake_item8));
		LoadImageInfo img9=new LoadImageInfo(shake_item9,(ImageView) findViewById(R.id.shake_item9));
		lstImages.add(imgModel);
		lstImages.add(img1);
		lstImages.add(img2);
		lstImages.add(img3);
		lstImages.add(img4);
		lstImages.add(img5);
		lstImages.add(img6);
		lstImages.add(img7);
		lstImages.add(img8);
		lstImages.add(img9);
		loadImages(lstImages);		
		
	}
	
	private void loadImages(List<LoadImageInfo> lstImageInfos){
		LoadImageInfo imgInfo;
		String imgUrl="";
		String imgPath="";
		String imgName="";
		
		for(int i=0;i<lstImageInfos.size();i++){
			imgInfo=lstImageInfos.get(i);
			imgUrl=imgInfo.getImgUrl();
			imgPath=imgHttpUrl+imgUrl;
			imgName=imgUrl.substring(imgUrl.lastIndexOf("/")+1);
			final ImageView imgView=imgInfo.getmImageView(); 
			
			imageUtil.loadImage(imgName, imgPath, true, new ImageCallback(){
				public void onStart(String imageUrl) {			
					
				}
				
				public void onFailed(String imageUrl) {				
					
				}
				
				public void loadImage(Bitmap bitmap, String imageUrl) {
					imgView.setImageBitmap(bitmap);					
				}
			});
		}
		
	}
	
}
