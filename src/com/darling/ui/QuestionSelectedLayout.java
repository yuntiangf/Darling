package com.darling.ui;

import com.darling.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class QuestionSelectedLayout extends LinearLayout {
	private ImageView btn1, btn2, btn3, btn4;;
	public QuestionSelectedLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.question_selected, this);

		
		btn1 = (ImageView) findViewById(R.id.btn_1);
		btn2 = (ImageView) findViewById(R.id.btn_2);
		btn3 = (ImageView) findViewById(R.id.btn_3);
		btn4 = (ImageView) findViewById(R.id.btn_4);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				clear();
				btn1.setImageResource(R.drawable.select1_2);
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				clear();
				btn2.setImageResource(R.drawable.select2_2);
			}
		});
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				clear();
				btn3.setImageResource(R.drawable.select3_2);
			}
		});
		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				clear();
				btn4.setImageResource(R.drawable.select4_2);
			}
		});
	}
	
	public void  clear(){
		btn1.setImageResource(R.drawable.select1_1);
		btn2.setImageResource(R.drawable.select2_1);
		btn3.setImageResource(R.drawable.select3_1);
		btn4.setImageResource(R.drawable.select4_1);
	}
}
