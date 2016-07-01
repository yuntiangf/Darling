package com.darling.ui;

import com.darling.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout{

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.activity_title, this);
		
	
		ImageView imgView=(ImageView) findViewById(R.id.title_saoyisao);
		imgView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getContext().getApplicationContext(), "扫一扫 Click", Toast.LENGTH_SHORT).show();				
			}
			
		});
	}

}
