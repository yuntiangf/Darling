package com.darling.adapter;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.darling.model.CaseInfo;

/**
 * 适配器基类
 * @author:MushRoom
 * @date:2015-11-3 下午9:29:01
 */
public class BaseAdapter extends ArrayAdapter<CaseInfo> {
	
	//子项布局layout的id
	protected int resourceId;
		
	public BaseAdapter(Context context, int resource,
			List<CaseInfo> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}

}
