package com.darling.widget;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 自定义衣服类型选择的按钮组
 * @author:MushRoom
 * @date:2015-12-25 下午10:30:11
 */
public class ClothesTypeVertical extends LinearLayout {
	
	private String clothesType;
	public String getClothesType() {
		return clothesType;
	}

	public void setClothesType(String clothesType) {
		this.clothesType = clothesType;
	}
	
	private List<Integer> lstBtns=new ArrayList<Integer>();
	
	public ClothesTypeVertical(Context context,String type) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.clothetype_vertical, this);
		
		initBtns();
		
		if(type.isEmpty()) type="帽子";//默认选择帽子
		initRadioGroup(type);
		
		RadioGroup radioGroup=(RadioGroup) findViewById(R.id.type_group);		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton selectedBtn=(RadioButton) findViewById(checkedId);
				clothesType=(String) selectedBtn.getText();
			}
			
		});

	}	

	/**
	 * 初始化按钮组
	 * @author:MushRoom
	 * @date:2015-12-25 下午10:39:32
	 */
	private void initBtns(){
		lstBtns.clear();
		lstBtns.add(R.id.btn_hat);
		lstBtns.add(R.id.btn_scarf);
		lstBtns.add(R.id.btn_upper);
		lstBtns.add(R.id.btn_bag);
		lstBtns.add(R.id.btn_skirt);
		lstBtns.add(R.id.btn_trousers);
		lstBtns.add(R.id.btn_shoes);
		lstBtns.add(R.id.btn_belt);
	}
	
	/**
	 * 初始化按钮组的值
	 * @author:MushRoom
	 * @date:2015-12-25 下午10:30:05
	 * @param selValue
	 */
	private void initRadioGroup(String selValue){
		//.performClick();
		int len=lstBtns.size();
		if(len<1) return;
		
		RadioButton btn;
		for(int i=0;i<len;i++){
			btn=(RadioButton) findViewById(lstBtns.get(i));
			if(((String)btn.getText()).equals(selValue)){
				btn.performClick();
				clothesType=selValue;
				return;
			}
		}
		
	}
	


}
