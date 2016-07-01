package com.darling.ui;

import com.darling.R;
import com.darling.activity.BaseFragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseTitleLayout extends LinearLayout {

	public BaseTitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.base_title, this);
		
		//接收数据
		String title=((BaseFragmentActivity)getContext()).getmTitleName();
		if(title.isEmpty()) title="详      情";
		TextView txtView=(TextView) findViewById(R.id.base_title_text);
		txtView.setText(title);
		
		ImageView img=(ImageView) findViewById(R.id.title_back);		
		img.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((Activity)getContext()).finish();
			}
		});
	}

}
