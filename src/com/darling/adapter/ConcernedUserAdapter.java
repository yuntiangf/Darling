package com.darling.adapter;

import java.lang.reflect.Field;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.darling.R;
import com.darling.model.UserInfo;
import com.darling.widget.SelectableRoundedImageView;

/**
 * “我关注的用户”适配器
 * @author:MushRoom
 * @date:2015-12-13 下午1:34:15
 */
public class ConcernedUserAdapter extends ArrayAdapter<UserInfo> {
	//子项布局layout的id
	protected int resourceId;
	
	public ConcernedUserAdapter(Context context, int resource,
			List<UserInfo> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		UserInfo userinfo=getItem(position);
		View view;
		ViewHolder viewHolder;
		try{
			if(convertView == null){
				Context context =getContext();		
				LayoutInflater inflater=LayoutInflater.from(context);				
				view=inflater.inflate(resourceId, null);
				viewHolder=new ViewHolder();
				viewHolder.uerImg=(SelectableRoundedImageView) view.findViewById(R.id.user_image);
				viewHolder.userDescription=(TextView) view.findViewById(R.id.user_info);
				view.setTag(viewHolder);
			}
			else{
				view=convertView;
				viewHolder=(ViewHolder) view.getTag();
			}
			
			Field f=R.drawable.class.getDeclaredField(userinfo.getId());
			int imgSrc=f.getInt(R.drawable.class);
			String des=userinfo.getName()+userinfo.getSex();
			
			viewHolder.uerImg.setImageResource(imgSrc);		
			viewHolder.uerImg.setScaleType(ScaleType.CENTER_CROP);
			viewHolder.uerImg.setOval(true);
			viewHolder.userDescription.setText(des);
			return view;
		}
		catch(Exception e){
			
		}
		return null;
	}
	
	/**
	 * 自定义控件管理类
	 */
	class ViewHolder{
		SelectableRoundedImageView uerImg;
		TextView userDescription;
	}

}
