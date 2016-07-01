package com.darling.adapter;

import java.lang.reflect.Field;
import java.util.List;

import com.darling.R;
import com.darling.model.CaseInfo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 搭配模板 适配器
 * @author:MushRoom
 * @date:2015-11-3 下午7:56:56
 */
public class ModelAdapter extends BaseAdapter {

		
	public ModelAdapter(Context context, int resource, List<CaseInfo> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}
	
	/**
	 * 
	 */
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		
		CaseInfo caseInfo =getItem(position);
		View view;
		ViewHolder viewHolder;
		try {
			if(convertView == null){
				Context context =getContext();		
				LayoutInflater inflater=LayoutInflater.from(context);				
				view=inflater.inflate(resourceId, null);
				viewHolder=new ViewHolder();
				viewHolder.caseImg=(ImageView) view.findViewById(R.id.model_image);
				viewHolder.caseStyle=(TextView) view.findViewById(R.id.model_style);
				viewHolder.caseDescription=(TextView) view.findViewById(R.id.model_description);
				
				view.setTag(viewHolder);
			}
			else{
				view=convertView;
				viewHolder=(ViewHolder) view.getTag();
			}
			
			//根据文件名称，动态获取图片资源
			Field f = R.drawable.class.getDeclaredField(caseInfo.getCase_id());
			int imgSrc=f.getInt(R.drawable.class);
			viewHolder.caseImg.setImageResource(imgSrc);
			viewHolder.caseStyle.setText(caseInfo.getCase_style());
			viewHolder.caseDescription.setText(caseInfo.getCase_description());
			
			return view;
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			Log.e("mushroom", e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * 自定义控件管理类
	 */
	class ViewHolder{
		ImageView caseImg;
		TextView caseStyle;
		TextView caseDescription;
	}

}

