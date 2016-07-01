package com.darling.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.darling.activity.OneMinuteShakeActivity;
import com.darling.ui.ShakeResult2;
import com.darling.ui.ShakeResult3;
import com.darling.ui.ShakeResult4;
import com.darling.ui.ShakeResult5;
import com.darling.ui.ShakeResult6;
import com.darling.ui.ShakeResult7;
import com.darling.ui.ShakeResult8;
import com.darling.ui.ShakeResult9;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * http请求处理类 摇一摇结果解析 三分钟出门解析
 * 
 * @author:MushRoom
 * @date:2016-2-9 下午4:13:54
 */
public class HttpResultAnalysisUtil {

	private int _nType;
	private String _strResult;
	private String _strThemeTitle;  //抬头的字样
	private String _strThemePicPath;  //页脚主题的图片
	private Context _context;

	/**
	 * 
	 * @author:MushRoom
	 * @date:2016-2-9 下午4:17:20
	 * @param nType
	 *            1:摇一摇；2：三分钟出门
	 * @param result
	 */
	public HttpResultAnalysisUtil(int nType, String result,String themeTitle,String themePicPath, Context context) {
		this._nType = nType;
		this._strResult = result;
		this._context = context;
		this._strThemePicPath=themePicPath;
		this._strThemeTitle=themeTitle;
	}

	/**
	 * 解析 外部函数入口
	 * 
	 * @author:MushRoom
	 * @date:2016-2-9 下午4:20:48
	 * @return
	 */
	public Intent AnalysisResult() {		
		return AnalysisShakeResult();
	}

	/**
	 * 解析摇一摇结果
	 * @author:MushRoom
	 * @date:2016-2-9 下午4:24:48
	 * @return
	 */
	private Intent AnalysisShakeResult(){
		JSONObject jsonobj;
		try{
			jsonobj=new JSONObject(this._strResult);
			
			JSONArray jsonarray=jsonobj.names();
			int len=jsonarray.length();				
			
			List<String> lstResult=new ArrayList<String>();
			String objName=""; //eg. trouser
			String objValue=""; //eg.  icon/0/0/0220.jpg
			
			//遍历，model第一位，裤子如果有 第二位 
			//只排序，后面再赋item位数
			for(int m=0;m<len;m++){
				objName=(String)(jsonarray.get(m));
				objValue=getValueByName(jsonobj,objName,"image_path");
				if(objName.contains("icon")){						
					lstResult.add(0,objValue);						
				}
				else if(objName.contains("trouser")){
					lstResult.add(1,objValue);
				}
				else{						
					lstResult.add(objValue);
				}
			}	
			Intent intent=null;
			if(len<3) return null;
			switch(len-1){
			case 2:
				intent=new Intent(this._context,ShakeResult2.class);
				break;
			case 3:
				intent=new Intent(this._context,ShakeResult3.class);
				break;
			case 4:
				intent=new Intent(this._context,ShakeResult4.class);
				break;
			case 5:
				intent=new Intent(this._context,ShakeResult5.class);
				break;
			case 6:
				intent=new Intent(this._context,ShakeResult6.class);
				break;
			case 7:
				intent=new Intent(this._context,ShakeResult7.class);
				break;
			case 8:
				intent=new Intent(this._context,ShakeResult8.class);
				break;
			case 9:
				intent=new Intent(this._context,ShakeResult9.class);
				break;
			}

			
			intent.putExtra("themePicPath", _strThemePicPath);
			intent.putExtra("themeTitle", _strThemeTitle);
			
			
			String itemName=""; //eg.  shake_item2					
			for(int k=0;k<lstResult.size();k++){
				objValue=lstResult.get(k);	
				if(k==0){					
					intent.putExtra("shake_model", objValue);
				}
				else{
					itemName="shake_item"+String.valueOf(k);
					intent.putExtra(itemName, objValue);
				}					
			}
			return intent;
		}
		catch(Exception ex){
			Log.i("mushroom",ex.getMessage());
			return null;	
		}
	}

	/**
	 * 解析三分钟出门的结果
	 * 
	 * @author:MushRoom
	 * @date:2016-2-9 下午4:25:02
	 * @return
	 */
	private Intent AnalysisThreeMinutesResult() {
		return null;
	}

	/**
	 * 从jsonobject中读取某个字段的信息
	 * 
	 * @author:MushRoom
	 * @date:2016-1-23 下午11:39:44
	 * @param jsonObj
	 *            指http返回的jsonobject
	 * @param type
	 *            例如： icon
	 * @param name
	 *            例如：image_path
	 * @return 例如：icon/0/0/0173.jpg
	 * @throws JSONException
	 */
	private String getValueByName(JSONObject jsonObj, String type, String name)
			throws JSONException {
		String childObj = jsonObj.getString(type);
		JSONObject childJSON = new JSONObject(childObj);
		return childJSON.getString(name);
	}

	// 结果图片路由组合
	class shakeResultModel {
		shakeResultModel(String name, String value) {
			this.strName = name;
			this.strValue = value;
		}

		// 值名称 eg shake_model
		String strName;
		// 值内容 eg icon/0/0/0173.jpg
		String strValue;
	}

}
