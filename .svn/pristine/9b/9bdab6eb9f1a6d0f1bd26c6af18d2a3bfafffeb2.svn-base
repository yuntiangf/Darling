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
 * 案例  适配器
 * @author:MushRoom
 * @date:2015-10-25 上午12:04:50
 */
public class CaseAdapter extends BaseAdapter {
	
	public CaseAdapter(Context context, int resource, List<CaseInfo> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}

	/**
	 * position:listView中的位置
	 * convertView:适配器子项控件item,缓冲之前加载好的布局
	 * parent:
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
				viewHolder.caseImg=(ImageView) view.findViewById(R.id.waterfall_image);
				viewHolder.userName=(TextView) view.findViewById(R.id.username);
				viewHolder.loverNum=(TextView) view.findViewById(R.id.lovernum);
				
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
			viewHolder.userName.setText(caseInfo.getUser_name());
			//viewHolder.loverNum.setText(caseInfo.getLover_num());
			
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
		TextView userName;
		TextView loverNum;
	}

}
