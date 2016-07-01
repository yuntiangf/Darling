package com.darling.adapter;

import java.util.List;

import com.darling.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * @author:hj
 * @date:2015-12-26 下午9:36:54
 */
public class ImgAdapter2 extends BaseAdapter {

	private Context mContext;
	private List<Integer> imgList; 
	public ImgAdapter2(Context context,List<Integer> imgList ) {
		mContext = context;
		this.imgList=imgList;
	}
	
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		ViewHolder viewHolder;
		try {
			if(convertView == null){
				
				LayoutInflater inflater=LayoutInflater.from(mContext);				
				view=inflater.inflate(R.layout.clothes_gallery_item, null);
				viewHolder=new ViewHolder();
				viewHolder.imageView1 = (ImageView) view.findViewById(R.id.clothes_gallery1_1);
				viewHolder.imageView2 = (ImageView) view.findViewById(R.id.clothes_gallery1_2);
				viewHolder.imageView3 = (ImageView) view.findViewById(R.id.clothes_gallery1_3);
				
				view.setTag(viewHolder);
			}else{
				view=convertView;
				viewHolder=(ViewHolder) view.getTag();
			}
			
			viewHolder.imageView1.setImageResource(imgList.get((position*3) % imgList.size()));
			viewHolder.imageView2.setImageResource(imgList.get((position*3+1) % imgList.size()));
			viewHolder.imageView3.setImageResource(imgList.get((position*3+2) % imgList.size()));
			return view;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	private static class ViewHolder {
		ImageView imageView1;
		ImageView imageView2;
		ImageView imageView3;
	}

}
