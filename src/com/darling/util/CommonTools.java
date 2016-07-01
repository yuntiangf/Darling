package com.darling.util;

import java.lang.reflect.Field;

import android.content.Context;
import android.widget.Toast;

import com.darling.R;

/**
 * 常见工具类
 * @author:MushRoom
 * @date:2015-12-14 下午11:31:16
 */
public class CommonTools {

	
	/**
	 * 根据名称获取图片资源
	 * @author:MushRoom
	 * @date:2015-12-14 下午11:30:28
	 * @param name
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	public static int getImageSrc(String name) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
		Field f;
		f = R.drawable.class.getDeclaredField(name);
		int imgSrc=f.getInt(R.drawable.class);
		return imgSrc;
	}
	
	/**
	 * 统一提示的格式
	 * @author:MushRoom
	 * @date:2016-1-5 下午11:32:17
	 * @param context
	 * @param msg
	 * @param duration
	 */
	public static void showMsg(Context context,String msg,Integer duration){
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 衣服名称类型对应
	 * @author:MushRoom
	 * @date:2016-2-16 下午10:52:51
	 * @param name 例如：帽子
	 * @return 例如：hat
	 */
	public static String getEnByName(String name){	
		String enName="";
		if(name.equals("帽子")) enName="hat";
		else if(name.equals("围巾")) enName="scarf";
		else if(name.equals("上衣")) enName="upper";
		else if(name.equals("包包")) enName= "bag";
		else if(name.equals("裙装")) enName="skirt";
		else if(name.equals("裤装")) enName="trouser";
		else if(name.equals("鞋子")) enName="shoe";
		else if(name.equals("腰带")) enName="waist";		
		return enName;
		
	}
}
