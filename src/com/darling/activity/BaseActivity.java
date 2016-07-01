package com.darling.activity;



import java.lang.reflect.Field;

import com.darling.interfaces.ViewInject;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * 基础Activity 实现控件注释初始化
 *
 */
public abstract class BaseActivity extends Activity{

	/**
	 * 返回布局文件的id
	 * @return 
	 */
	public abstract int getLayoutId();
	/**
	 * 相当于Activity的onCreate();
	 */
	public abstract void onInitial();
    @Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//让屏幕不会自动暗下来并锁屏，保持屏幕高亮
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(getLayoutId());	
		autoInjectAllField();
		setFullScreen();
		onInitial();
	}
	
	public void autoInjectAllField(){
		try {
			Class<?> clazzClass=this.getClass();
			Field[] fields=clazzClass.getDeclaredFields();//获得Activity中声明的字段
			for(Field field:fields){
				//查看字段是否有我们自定义的注释类标志的
				if(field.isAnnotationPresent(ViewInject.class)){
					ViewInject inject=field.getAnnotation(ViewInject.class);
					int id=inject.value();
					if(id>0){
						field.setAccessible(true);
						field.set(this, this.findViewById(id));//给我们要找的字段设置值
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void setFullScreen(){
		//设置全屏
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//锁定竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
