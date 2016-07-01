package com.darling.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * @author:hj
 * @date:2015-12-26 下午9:36:54
 */
public class ImgAdapter extends BaseAdapter {

	private Context mContext;
	private List<Integer> imgList; 
	public ImgAdapter(Context context,List<Integer> imgList ) {
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

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			ImageView imageView = new ImageView(mContext);
			imageView.setAdjustViewBounds(true);
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(
					android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			convertView = imageView;
			viewHolder.imageView = (ImageView) convertView;
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.imageView.setImageResource(imgList.get(position % imgList.size()));
		return convertView;
	}

	private static class ViewHolder {
		ImageView imageView;
	}
}
