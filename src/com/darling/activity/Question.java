package com.darling.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.NumberPicker.OnValueChangeListener;

import com.darling.R;
import com.darling.widget.GalleryView;

/**
 * @author:hj
 * @date:2016-1-21 下午9:24:27
 */
public class Question extends Activity implements OnClickListener{
	private ImageView title_back2;
	private ImageView previous_page, next_page;
	private int num = 1;
	// 问卷1
	private LinearLayout layout;
	private NumberPicker year, month, day;
	private TextView birthday;
	// 问卷2
	private NumberPicker height, weight;
	private TextView basicInformation;
	// 问卷3
	private GalleryView galleryView = null;
	private ImageView face1, face2, face3, face4, face5, face6;
	// 问卷4
	private ImageView skin1, skin2, skin3, skin4;
	// 问卷5
	private ImageView list5Image1_1, list5Image1_2, list5Image2_1,
			list5Image2_2, list5Image3_1, list5Image3_2, list5Image4_1,
			list5Image4_2;
	// 问卷6
	private ImageView list6Image1_1, list6Image1_2, list6Image2_1,
			list6Image2_2, list6Image3_1, list6Image3_2, list6Image4_1,
			list6Image4_2, list6Image5_1, list6Image5_2, list6Image6_1,
			list6Image6_2, list6Image7_1, list6Image7_2;
	// 问卷7
	private ImageView list7Image1_1, list7Image1_2, list7Image2_1,
			list7Image2_2, list7Image3_1, list7Image3_2, list7Image4_1,
			list7Image4_2, list7Image5_1, list7Image5_2, list7Image6_1,
			list7Image6_2, list7Image7_1, list7Image7_2;
	// 问卷8
	private ImageView list8Image1_1, list8Image1_2, list8Image2_1,
			list8Image2_2, list8Image3_1, list8Image3_2, list8Image4_1,
			list8Image4_2, list8Image5_1, list8Image5_2, list8Image6_1,
			list8Image6_2, list8Image7_1, list8Image7_2;
	// 问卷9
	private ImageView list9Image1_1, list9Image1_2, list9Image2_1,
			list9Image2_2, list9Image3_1, list9Image3_2, list9Image4_1,
			list9Image4_2, list9Image5_1, list9Image5_2, list9Image6_1,
			list9Image6_2, list9Image7_1, list9Image7_2;
	// 问卷10

	// 问卷11
	private NumberPicker upper, trouser, shoes;
	private TextView clothes_size;
	String[] size_upper = { "S", "M", "L", "XL", "XXL", "3XL", "4XL" };

	// 问卷12
	private ImageView tag12_1,tag12_2,tag12_3,tag12_4,tag12_5,tag12_6,
					tag12_7,tag12_8,tag12_9,tag12_10;
	private int flag12_1=0,flag12_2=0,flag12_3=0,flag12_4=0,flag12_5=0,flag12_6=0,flag12_7=0,
			flag12_8=0,flag12_9=0,flag12_10=0;
	// 问卷13
	private ImageView tag13_1, tag13_2, tag13_3, tag13_4, tag13_5, tag13_6,
			tag13_7, tag13_8, tag13_9, tag13_10, tag13_11, tag13_12, tag13_13,
			tag13_14, tag13_15, tag13_16, tag13_17, tag13_18, tag13_19,
			tag13_20, tag13_21, tag13_22, tag13_23, tag13_24, tag13_25,
			tag13_26, tag13_27, tag13_28;
	private int flag13_1=0,flag13_2=0,flag13_3=0,flag13_4=0,flag13_5=0,flag13_6=0,flag13_7=0,
			flag13_8=0,flag13_9=0,flag13_10=0,flag13_11=0,flag13_12=0,flag13_13=0,flag13_14=0,
			flag13_15=0,flag13_16=0,flag13_17=0,flag13_18=0,flag13_19=0,flag13_20=0,flag13_21=0,
			flag13_22=0,flag13_23=0,flag13_24=0,flag13_25=0,flag13_26=0,flag13_27=0,flag13_28=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		Intent intent = getIntent();
//		setmTitleName(intent.getStringExtra("title"));

		setContentView(R.layout.question);
		
		title_back2 = (ImageView) findViewById(R.id.title_back2);
		title_back2.setOnClickListener(this);
		
		initView();
		initView1();
	}

	private void initView() {
		previous_page = (ImageView) findViewById(R.id.previous_page);
		next_page = (ImageView) findViewById(R.id.next_page);

		previous_page.setOnClickListener(this);
		next_page.setOnClickListener(this);

		previous_page.setImageResource(R.drawable.previous_page);
		next_page.setImageResource(R.drawable.next_page);

		if (num == 1) {
			previous_page.setVisibility(View.INVISIBLE);
		} else {
			previous_page.setVisibility(View.VISIBLE);
		}
		if (num == 13) {
			next_page.setImageResource(R.drawable.finish);
			// next_page.setVisibility(View.INVISIBLE);
		} else {
			next_page.setVisibility(View.VISIBLE);
		}
	}

	private void initView1() {
		layout = (LinearLayout) findViewById(R.id.question_1);
		layout.setVisibility(View.VISIBLE);

		year = (NumberPicker) findViewById(R.id.year);
		month = (NumberPicker) findViewById(R.id.month);
		day = (NumberPicker) findViewById(R.id.day);
		birthday = (TextView) findViewById(R.id.birthday);

		year.setMaxValue(2020);
		year.setMinValue(1950);
		month.setMaxValue(12);
		month.setMinValue(1);
		day.setMaxValue(31);
		day.setMinValue(1);

		if (year.getValue() == 1950 && month.getValue() == 1
				&& day.getValue() == 1) {
			year.setValue(1993);
			month.setValue(6);
			day.setValue(12);
		}

		initData(year);
		initData(month);
		initData(day);

	}

	private void initData(final NumberPicker numberPicker) {
		numberPicker.setFocusable(true);
		numberPicker.setFocusableInTouchMode(true);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				numberPicker.setValue(newVal);
				birthday.setText("您的出生日期为： " + year.getValue() + "年 "
						+ month.getValue() + "月 " + day.getValue() + "日  ");
			}
		});
	}

	private void initView2() {

		layout = (LinearLayout) findViewById(R.id.question_2);
		layout.setVisibility(View.VISIBLE);
		height = (NumberPicker) findViewById(R.id.height);
		weight = (NumberPicker) findViewById(R.id.weight);
		basicInformation = (TextView) findViewById(R.id.basicInformation);

		height.setMaxValue(190);
		height.setMinValue(150);
		weight.setMaxValue(80);
		weight.setMinValue(40);

		init(height);
		init(weight);

		if (height.getValue() == 150 && weight.getValue() == 40) {
			height.setValue(168);
			weight.setValue(45);
		}

	}

	private void init(final NumberPicker numberPicker) {
		numberPicker.setFocusable(true);
		numberPicker.setFocusableInTouchMode(true);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				numberPicker.setValue(newVal);

				basicInformation.setText("您的身高是: " + height.getValue() + "cm"
						+ "\n您的体重是: " + weight.getValue() + "kg");
			}
		});
	}

	private void initView3() {
		layout = (LinearLayout) findViewById(R.id.question_3);
		layout.setVisibility(View.VISIBLE);

		face1 = (ImageView) findViewById(R.id.face1);
		face2 = (ImageView) findViewById(R.id.face2);
		face3 = (ImageView) findViewById(R.id.face3);
		face4 = (ImageView) findViewById(R.id.face4);
		face5 = (ImageView) findViewById(R.id.face5);
		face6 = (ImageView) findViewById(R.id.face6);

		face1.setOnClickListener(this);
		face2.setOnClickListener(this);
		face3.setOnClickListener(this);
		face4.setOnClickListener(this);
		face5.setOnClickListener(this);
		face6.setOnClickListener(this);

	}

	private void initView4() {
		layout = (LinearLayout) findViewById(R.id.question_4);
		layout.setVisibility(View.VISIBLE);

		skin1 = (ImageView) findViewById(R.id.skin1);
		skin2 = (ImageView) findViewById(R.id.skin2);
		skin3 = (ImageView) findViewById(R.id.skin3);
		skin4 = (ImageView) findViewById(R.id.skin4);

		skin1.setOnClickListener(this);
		skin2.setOnClickListener(this);
		skin3.setOnClickListener(this);
		skin4.setOnClickListener(this);
	}

	private void initView5() {
		layout = (LinearLayout) findViewById(R.id.question_5);
		layout.setVisibility(View.VISIBLE);

		list5Image1_1 = (ImageView) findViewById(R.id.list5Image1_1);
		list5Image1_2 = (ImageView) findViewById(R.id.list5Image1_2);
		list5Image2_1 = (ImageView) findViewById(R.id.list5Image2_1);
		list5Image2_2 = (ImageView) findViewById(R.id.list5Image2_2);
		list5Image3_1 = (ImageView) findViewById(R.id.list5Image3_1);
		list5Image3_2 = (ImageView) findViewById(R.id.list5Image3_2);
		list5Image4_1 = (ImageView) findViewById(R.id.list5Image4_1);
		list5Image4_2 = (ImageView) findViewById(R.id.list5Image4_2);

		list5Image1_2.setOnClickListener(this);
		list5Image2_2.setOnClickListener(this);
		list5Image3_2.setOnClickListener(this);
		list5Image4_2.setOnClickListener(this);

	}

	private void initView6() {
		layout = (LinearLayout) findViewById(R.id.question_6);
		layout.setVisibility(View.VISIBLE);

		list6Image1_1 = (ImageView) findViewById(R.id.list6Image1_1);
		list6Image1_2 = (ImageView) findViewById(R.id.list6Image1_2);
		list6Image2_1 = (ImageView) findViewById(R.id.list6Image2_1);
		list6Image2_2 = (ImageView) findViewById(R.id.list6Image2_2);
		list6Image3_1 = (ImageView) findViewById(R.id.list6Image3_1);
		list6Image3_2 = (ImageView) findViewById(R.id.list6Image3_2);
		list6Image4_1 = (ImageView) findViewById(R.id.list6Image4_1);
		list6Image4_2 = (ImageView) findViewById(R.id.list6Image4_2);
		list6Image5_1 = (ImageView) findViewById(R.id.list6Image5_1);
		list6Image5_2 = (ImageView) findViewById(R.id.list6Image5_2);
		list6Image6_1 = (ImageView) findViewById(R.id.list6Image6_1);
		list6Image6_2 = (ImageView) findViewById(R.id.list6Image6_2);
		list6Image7_1 = (ImageView) findViewById(R.id.list6Image7_1);
		list6Image7_2 = (ImageView) findViewById(R.id.list6Image7_2);

		list6Image1_2.setOnClickListener(this);
		list6Image2_2.setOnClickListener(this);
		list6Image3_2.setOnClickListener(this);
		list6Image4_2.setOnClickListener(this);
		list6Image5_2.setOnClickListener(this);
		list6Image6_2.setOnClickListener(this);
		list6Image7_2.setOnClickListener(this);
	}

	private void initView7() {
		layout = (LinearLayout) findViewById(R.id.question_7);
		layout.setVisibility(View.VISIBLE);

		list7Image1_1 = (ImageView) findViewById(R.id.list7Image1_1);
		list7Image1_2 = (ImageView) findViewById(R.id.list7Image1_2);
		list7Image2_1 = (ImageView) findViewById(R.id.list7Image2_1);
		list7Image2_2 = (ImageView) findViewById(R.id.list7Image2_2);
		list7Image3_1 = (ImageView) findViewById(R.id.list7Image3_1);
		list7Image3_2 = (ImageView) findViewById(R.id.list7Image3_2);
		list7Image4_1 = (ImageView) findViewById(R.id.list7Image4_1);
		list7Image4_2 = (ImageView) findViewById(R.id.list7Image4_2);
		list7Image5_1 = (ImageView) findViewById(R.id.list7Image5_1);
		list7Image5_2 = (ImageView) findViewById(R.id.list7Image5_2);
		list7Image6_1 = (ImageView) findViewById(R.id.list7Image6_1);
		list7Image6_2 = (ImageView) findViewById(R.id.list7Image6_2);
		list7Image7_1 = (ImageView) findViewById(R.id.list7Image7_1);
		list7Image7_2 = (ImageView) findViewById(R.id.list7Image7_2);

		list7Image1_2.setOnClickListener(this);
		list7Image2_2.setOnClickListener(this);
		list7Image3_2.setOnClickListener(this);
		list7Image4_2.setOnClickListener(this);
		list7Image5_2.setOnClickListener(this);
		list7Image6_2.setOnClickListener(this);
		list7Image7_2.setOnClickListener(this);
	}

	private void initView8() {
		layout = (LinearLayout) findViewById(R.id.question_8);
		layout.setVisibility(View.VISIBLE);

		list8Image1_1 = (ImageView) findViewById(R.id.list8Image1_1);
		list8Image1_2 = (ImageView) findViewById(R.id.list8Image1_2);
		list8Image2_1 = (ImageView) findViewById(R.id.list8Image2_1);
		list8Image2_2 = (ImageView) findViewById(R.id.list8Image2_2);
		list8Image3_1 = (ImageView) findViewById(R.id.list8Image3_1);
		list8Image3_2 = (ImageView) findViewById(R.id.list8Image3_2);
		list8Image4_1 = (ImageView) findViewById(R.id.list8Image4_1);
		list8Image4_2 = (ImageView) findViewById(R.id.list8Image4_2);
		list8Image5_1 = (ImageView) findViewById(R.id.list8Image5_1);
		list8Image5_2 = (ImageView) findViewById(R.id.list8Image5_2);
		list8Image6_1 = (ImageView) findViewById(R.id.list8Image6_1);
		list8Image6_2 = (ImageView) findViewById(R.id.list8Image6_2);
		list8Image7_1 = (ImageView) findViewById(R.id.list8Image7_1);
		list8Image7_2 = (ImageView) findViewById(R.id.list8Image7_2);

		list8Image1_2.setOnClickListener(this);
		list8Image2_2.setOnClickListener(this);
		list8Image3_2.setOnClickListener(this);
		list8Image4_2.setOnClickListener(this);
		list8Image5_2.setOnClickListener(this);
		list8Image6_2.setOnClickListener(this);
		list8Image7_2.setOnClickListener(this);
	}

	private void initView9() {
		layout = (LinearLayout) findViewById(R.id.question_9);
		layout.setVisibility(View.VISIBLE);

		list9Image1_1 = (ImageView) findViewById(R.id.list9Image1_1);
		list9Image1_2 = (ImageView) findViewById(R.id.list9Image1_2);
		list9Image2_1 = (ImageView) findViewById(R.id.list9Image2_1);
		list9Image2_2 = (ImageView) findViewById(R.id.list9Image2_2);
		list9Image3_1 = (ImageView) findViewById(R.id.list9Image3_1);
		list9Image3_2 = (ImageView) findViewById(R.id.list9Image3_2);
		list9Image4_1 = (ImageView) findViewById(R.id.list9Image4_1);
		list9Image4_2 = (ImageView) findViewById(R.id.list9Image4_2);
		list9Image5_1 = (ImageView) findViewById(R.id.list9Image5_1);
		list9Image5_2 = (ImageView) findViewById(R.id.list9Image5_2);
		list9Image6_1 = (ImageView) findViewById(R.id.list9Image6_1);
		list9Image6_2 = (ImageView) findViewById(R.id.list9Image6_2);
		list9Image7_1 = (ImageView) findViewById(R.id.list9Image7_1);
		list9Image7_2 = (ImageView) findViewById(R.id.list9Image7_2);

		list9Image1_2.setOnClickListener(this);
		list9Image2_2.setOnClickListener(this);
		list9Image3_2.setOnClickListener(this);
		list9Image4_2.setOnClickListener(this);
		list9Image5_2.setOnClickListener(this);
		list9Image6_2.setOnClickListener(this);
		list9Image7_2.setOnClickListener(this);
	}

	private void initView10() {
		layout = (LinearLayout) findViewById(R.id.question_10);
		layout.setVisibility(View.VISIBLE);

	}

	private void initView11() {
		layout = (LinearLayout) findViewById(R.id.question_11);
		layout.setVisibility(View.VISIBLE);

		upper = (NumberPicker) findViewById(R.id.size_upper);
		trouser = (NumberPicker) findViewById(R.id.size_trouser);
		shoes = (NumberPicker) findViewById(R.id.size_shoes);
		clothes_size = (TextView) findViewById(R.id.clothes_size);

		upper.setDisplayedValues(size_upper);
		upper.setMaxValue(size_upper.length - 1);
		trouser.setMaxValue(42);
		trouser.setMinValue(25);
		shoes.setMaxValue(45);
		shoes.setMinValue(30);

		if (trouser.getValue() == 25 && shoes.getValue() == 30) {
			// upper.setValue(Integer.parseInt(size_upper[2].trim()));
			trouser.setValue(28);
			shoes.setValue(37);
		}

		initSize(upper);
		initSize(trouser);
		initSize(shoes);

	}

	private void initSize(final NumberPicker numberPicker) {
		numberPicker.setFocusable(true);
		numberPicker.setFocusableInTouchMode(true);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				numberPicker.setValue(newVal);
				clothes_size.setText("您选择常穿的上衣的尺码是："
						+ size_upper[upper.getValue()].toString()
						+ "\n 裤子的尺码是：" + trouser.getValue() + "\n 鞋子的尺码是："
						+ shoes.getValue());
			}
		});
	}

	private void initView12() {
		layout = (LinearLayout) findViewById(R.id.question_12);
		layout.setVisibility(View.VISIBLE);

		tag12_1 = (ImageView) findViewById(R.id.tag12_1);
		tag12_2 = (ImageView) findViewById(R.id.tag12_2);
		tag12_3 = (ImageView) findViewById(R.id.tag12_3);
		tag12_4 = (ImageView) findViewById(R.id.tag12_4);
		tag12_5 = (ImageView) findViewById(R.id.tag12_5);
		tag12_6 = (ImageView) findViewById(R.id.tag12_6);
		tag12_7 = (ImageView) findViewById(R.id.tag12_7);
		tag12_8 = (ImageView) findViewById(R.id.tag12_8);
		tag12_9 = (ImageView) findViewById(R.id.tag12_9);
		tag12_10 = (ImageView) findViewById(R.id.tag12_10);
		
		tag12_1.setOnClickListener(this);
		tag12_2.setOnClickListener(this);
		tag12_3.setOnClickListener(this);
		tag12_4.setOnClickListener(this);
		tag12_5.setOnClickListener(this);
		tag12_6.setOnClickListener(this);
		tag12_7.setOnClickListener(this);
		tag12_8.setOnClickListener(this);
		tag12_9.setOnClickListener(this);
		tag12_10.setOnClickListener(this);
	}

	private void initView13() {
		layout = (LinearLayout) findViewById(R.id.question_13);
		layout.setVisibility(View.VISIBLE);

		tag13_1 = (ImageView) findViewById(R.id.tag13_1);
		tag13_2 = (ImageView) findViewById(R.id.tag13_2);
		tag13_3 = (ImageView) findViewById(R.id.tag13_3);
		tag13_4 = (ImageView) findViewById(R.id.tag13_4);
		tag13_5 = (ImageView) findViewById(R.id.tag13_5);
		tag13_6 = (ImageView) findViewById(R.id.tag13_6);
		tag13_7 = (ImageView) findViewById(R.id.tag13_7);
		tag13_8 = (ImageView) findViewById(R.id.tag13_8);
		tag13_9 = (ImageView) findViewById(R.id.tag13_9);
		tag13_10 = (ImageView) findViewById(R.id.tag13_10);
		tag13_11 = (ImageView) findViewById(R.id.tag13_11);
		tag13_12 = (ImageView) findViewById(R.id.tag13_12);
		tag13_13 = (ImageView) findViewById(R.id.tag13_13);
		tag13_14 = (ImageView) findViewById(R.id.tag13_14);
		tag13_15 = (ImageView) findViewById(R.id.tag13_15);
		tag13_16 = (ImageView) findViewById(R.id.tag13_16);
		tag13_17 = (ImageView) findViewById(R.id.tag13_17);
		tag13_18 = (ImageView) findViewById(R.id.tag13_18);
		tag13_19 = (ImageView) findViewById(R.id.tag13_19);
		tag13_20 = (ImageView) findViewById(R.id.tag13_20);
		tag13_21 = (ImageView) findViewById(R.id.tag13_21);
		tag13_22 = (ImageView) findViewById(R.id.tag13_22);
		tag13_23 = (ImageView) findViewById(R.id.tag13_23);
		tag13_24 = (ImageView) findViewById(R.id.tag13_24);
		tag13_25 = (ImageView) findViewById(R.id.tag13_25);
		tag13_26 = (ImageView) findViewById(R.id.tag13_26);
		tag13_27 = (ImageView) findViewById(R.id.tag13_27);
		tag13_28 = (ImageView) findViewById(R.id.tag13_28);

		tag13_1.setOnClickListener(this);
		tag13_2.setOnClickListener(this);
		tag13_3.setOnClickListener(this);
		tag13_4.setOnClickListener(this);
		tag13_5.setOnClickListener(this);
		tag13_6.setOnClickListener(this);
		tag13_7.setOnClickListener(this);
		tag13_8.setOnClickListener(this);
		tag13_9.setOnClickListener(this);
		tag13_10.setOnClickListener(this);
		tag13_11.setOnClickListener(this);
		tag13_12.setOnClickListener(this);
		tag13_13.setOnClickListener(this);
		tag13_14.setOnClickListener(this);
		tag13_15.setOnClickListener(this);
		tag13_16.setOnClickListener(this);
		tag13_17.setOnClickListener(this);
		tag13_18.setOnClickListener(this);
		tag13_19.setOnClickListener(this);
		tag13_20.setOnClickListener(this);
		tag13_21.setOnClickListener(this);
		tag13_22.setOnClickListener(this);
		tag13_23.setOnClickListener(this);
		tag13_24.setOnClickListener(this);
		tag13_25.setOnClickListener(this);
		tag13_26.setOnClickListener(this);
		tag13_27.setOnClickListener(this);
		tag13_28.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back2:
			finish();
			break;
		case R.id.previous_page:
			num--;
			initView();
			showQuestionView(num);
			break;
		case R.id.next_page:
			if (num == 13) {
				finish();
			} else {
				num++;
				initView();
				showQuestionView(num);
			}
			break;
		case R.id.face1:
			clearFace();
			face1.setImageResource(R.drawable.face1_2);
			break;
		case R.id.face2:
			clearFace();
			face2.setImageResource(R.drawable.face2_2);
			break;
		case R.id.face3:
			clearFace();
			face3.setImageResource(R.drawable.face3_2);
			break;
		case R.id.face4:
			clearFace();
			face4.setImageResource(R.drawable.face4_2);
			break;
		case R.id.face5:
			clearFace();
			face5.setImageResource(R.drawable.face5_2);
			break;
		case R.id.face6:
			clearFace();
			face6.setImageResource(R.drawable.face6_2);
			break;
		case R.id.skin1:
			clearSkin();
			skin1.setImageResource(R.drawable.skin1_2);
			break;
		case R.id.skin2:
			clearSkin();
			skin2.setImageResource(R.drawable.skin2_2);
			break;
		case R.id.skin3:
			clearSkin();
			skin3.setImageResource(R.drawable.skin3_2);
			break;
		case R.id.skin4:
			clearSkin();
			skin4.setImageResource(R.drawable.skin4_2);
			break;
		case R.id.list5Image1_2:
			clearClothes(5);
			list5Image1_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list5Image2_2:
			clearClothes(5);
			list5Image2_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list5Image3_2:
			clearClothes(5);
			list5Image3_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list5Image4_2:
			clearClothes(5);
			list5Image4_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image1_2:
			clearClothes(6);
			list6Image1_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image2_2:
			clearClothes(6);
			list6Image2_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image3_2:
			clearClothes(6);
			list6Image3_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image4_2:
			clearClothes(6);
			list6Image4_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image5_2:
			clearClothes(6);
			list6Image5_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image6_2:
			clearClothes(6);
			list6Image6_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list6Image7_2:
			clearClothes(6);
			list6Image7_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image1_2:
			clearClothes(7);
			list7Image1_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image2_2:
			clearClothes(7);
			list7Image2_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image3_2:
			clearClothes(7);
			list7Image3_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image4_2:
			clearClothes(7);
			list7Image4_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image5_2:
			clearClothes(7);
			list7Image5_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image6_2:
			clearClothes(7);
			list7Image6_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list7Image7_2:
			clearClothes(7);
			list7Image7_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image1_2:
			clearClothes(8);
			list8Image1_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image2_2:
			clearClothes(8);
			list8Image2_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image3_2:
			clearClothes(8);
			list8Image3_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image4_2:
			clearClothes(8);
			list8Image4_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image5_2:
			clearClothes(8);
			list8Image5_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image6_2:
			clearClothes(8);
			list8Image6_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list8Image7_2:
			clearClothes(8);
			list8Image7_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image1_2:
			clearClothes(9);
			list9Image1_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image2_2:
			clearClothes(9);
			list9Image2_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image3_2:
			clearClothes(9);
			list9Image3_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image4_2:
			clearClothes(9);
			list9Image4_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image5_2:
			clearClothes(9);
			list9Image5_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image6_2:
			clearClothes(9);
			list9Image6_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.list9Image7_2:
			clearClothes(9);
			list9Image7_1.setImageResource(R.drawable.selected_2);
			break;
		case R.id.tag12_1:
			if(flag12_1 == 0){
				tag12_1.setImageResource(R.drawable.tag12_1_2);
				flag12_1 = 1;
			}else if(flag12_1 == 1){
				tag12_1.setImageResource(R.drawable.tag12_1_1);
				flag12_1 = 0;
			}
			break;
		case R.id.tag12_2:
			if(flag12_2 == 0){
				tag12_2.setImageResource(R.drawable.tag12_2_2);
				flag12_2 = 1;
			}else if(flag12_2 == 1){
				tag12_2.setImageResource(R.drawable.tag12_2_1);
				flag12_2 = 0;
			}
			break;
		case R.id.tag12_3:
			if(flag12_3 == 0){
				tag12_3.setImageResource(R.drawable.tag12_3_2);
				flag12_3 = 1;
			}else if(flag12_3 == 1){
				tag12_3.setImageResource(R.drawable.tag12_3_1);
				flag12_3 = 0;
			}
			break;
		case R.id.tag12_4:
			if(flag12_4 == 0){
				tag12_4.setImageResource(R.drawable.tag12_4_2);
				flag12_4 = 1;
			}else if(flag12_4 == 1){
				tag12_4.setImageResource(R.drawable.tag12_4_1);
				flag12_4 = 0;
			}
			break;
		case R.id.tag12_5:
			if(flag12_5 == 0){
				tag12_5.setImageResource(R.drawable.tag12_5_2);
				flag12_5 = 1;
			}else if(flag12_5 == 1){
				tag12_5.setImageResource(R.drawable.tag12_5_1);
				flag12_5 = 0;
			}
			break;
		case R.id.tag12_6:
			if(flag12_6 == 0){
				tag12_6.setImageResource(R.drawable.tag12_6_2);
				flag12_6 = 1;
			}else if(flag12_6 == 1){
				tag12_6.setImageResource(R.drawable.tag12_6_1);
				flag12_6 = 0;
			}
			break;
		case R.id.tag12_7:
			if(flag12_7 == 0){
				tag12_7.setImageResource(R.drawable.tag12_7_2);
				flag12_7 = 1;
			}else if(flag12_7 == 1){
				tag12_7.setImageResource(R.drawable.tag12_7_1);
				flag12_7 = 0;
			}
			break;
		case R.id.tag12_8:
			if(flag12_8 == 0){
				tag12_8.setImageResource(R.drawable.tag12_8_2);
				flag12_8 = 1;
			}else if(flag12_8 == 1){
				tag12_8.setImageResource(R.drawable.tag12_8_1);
				flag12_8 = 0;
			}
			break;
		case R.id.tag12_9:
			if(flag12_9 == 0){
				tag12_9.setImageResource(R.drawable.tag12_9_2);
				flag12_9 = 1;
			}else if(flag12_9 == 1){
				tag12_9.setImageResource(R.drawable.tag12_9_1);
				flag12_9 = 0;
			}
			break;
		case R.id.tag12_10:
			if(flag12_10 == 0){
				tag12_10.setImageResource(R.drawable.tag12_10_2);
				flag12_10 = 1;
			}else if(flag12_10 == 1){
				tag12_10.setImageResource(R.drawable.tag12_10_1);
				flag12_10 = 0;
			}
			break;
		case R.id.tag13_1:
			if(flag13_1 == 0){
				tag13_1.setImageResource(R.drawable.tag13_1_2);
				flag13_1 = 1;
			}else if(flag13_1 == 1){
				tag13_1.setImageResource(R.drawable.tag13_1_1);
				flag13_1 = 0;
			}
			break;
		case R.id.tag13_2:
			if(flag13_2 == 0){
				tag13_2.setImageResource(R.drawable.tag13_2_2);
				flag13_2 = 1;
			}else if(flag13_2 == 1){
				tag13_2.setImageResource(R.drawable.tag13_2_1);
				flag13_2 = 0;
			}
			break;
		case R.id.tag13_3:
			if(flag13_3 == 0){
				tag13_3.setImageResource(R.drawable.tag13_3_2);
				flag13_3 = 1;
			}else if(flag13_3 == 1){
				tag13_3.setImageResource(R.drawable.tag13_3_1);
				flag13_3 = 0;
			}
			break;
		case R.id.tag13_4:
			if(flag13_4 == 0){
				tag13_4.setImageResource(R.drawable.tag13_4_2);
				flag13_4 = 1;
			}else if(flag13_4 == 1){
				tag13_4.setImageResource(R.drawable.tag13_4_1);
				flag13_4 = 0;
			}
			break;
		case R.id.tag13_5:
			if(flag13_5 == 0){
				tag13_5.setImageResource(R.drawable.tag13_5_2);
				flag13_5 = 1;
			}else if(flag13_5 == 1){
				tag13_5.setImageResource(R.drawable.tag13_5_1);
				flag13_5 = 0;
			}
			break;
		case R.id.tag13_6:
			if(flag13_6 == 0){
				tag13_6.setImageResource(R.drawable.tag13_6_2);
				flag13_6 = 1;
			}else if(flag13_6 == 1){
				tag13_6.setImageResource(R.drawable.tag13_6_1);
				flag13_6 = 0;
			}
			break;
		case R.id.tag13_7:
			if(flag13_7 == 0){
				tag13_7.setImageResource(R.drawable.tag13_7_2);
				flag13_7 = 1;
			}else if(flag13_7 == 1){
				tag13_7.setImageResource(R.drawable.tag13_7_1);
				flag13_7 = 0;
			}
			break;
		case R.id.tag13_8:
			if(flag13_8 == 0){
				tag13_8.setImageResource(R.drawable.tag13_8_2);
				flag13_8 = 1;
			}else if(flag13_8 == 1){
				tag13_8.setImageResource(R.drawable.tag13_8_1);
				flag13_8 = 0;
			}
			break;
		case R.id.tag13_9:
			if(flag13_9 == 0){
				tag13_9.setImageResource(R.drawable.tag13_9_2);
				flag13_9 = 1;
			}else if(flag13_9 == 1){
				tag13_9.setImageResource(R.drawable.tag13_9_1);
				flag13_9 = 0;
			}
			break;
		case R.id.tag13_10:
			if(flag13_10 == 0){
				tag13_10.setImageResource(R.drawable.tag13_10_2);
				flag13_10 = 1;
			}else if(flag13_10 == 1){
				tag13_10.setImageResource(R.drawable.tag13_10_1);
				flag13_10 = 0;
			}
			break;
		case R.id.tag13_11:
			if(flag13_11 == 0){
				tag13_11.setImageResource(R.drawable.tag13_11_2);
				flag13_11 = 1;
			}else if(flag13_11 == 1){
				tag13_11.setImageResource(R.drawable.tag13_11_1);
				flag13_11 = 0;
			}
			break;
		case R.id.tag13_12:
			if(flag13_12 == 0){
				tag13_12.setImageResource(R.drawable.tag13_12_2);
				flag13_12 = 1;
			}else if(flag13_12 == 1){
				tag13_12.setImageResource(R.drawable.tag13_12_1);
				flag13_12 = 0;
			}
			break;
		case R.id.tag13_13:
			if(flag13_13 == 0){
				tag13_13.setImageResource(R.drawable.tag13_13_2);
				flag13_13 = 1;
			}else if(flag13_13 == 1){
				tag13_13.setImageResource(R.drawable.tag13_13_1);
				flag13_13 = 0;
			}
			break;
		case R.id.tag13_14:
			if(flag13_14 == 0){
				tag13_14.setImageResource(R.drawable.tag13_14_2);
				flag13_14 = 1;
			}else if(flag13_14 == 1){
				tag13_14.setImageResource(R.drawable.tag13_14_1);
				flag13_14 = 0;
			}
			break;
		case R.id.tag13_15:
			if(flag13_15 == 0){
				tag13_15.setImageResource(R.drawable.tag13_15_2);
				flag13_15 = 1;
			}else if(flag13_15 == 1){
				tag13_15.setImageResource(R.drawable.tag13_15_1);
				flag13_15 = 0;
			}
			break;
		case R.id.tag13_16:
			if(flag13_16 == 0){
				tag13_16.setImageResource(R.drawable.tag13_16_2);
				flag13_16 = 1;
			}else if(flag13_16 == 1){
				tag13_16.setImageResource(R.drawable.tag13_16_1);
				flag13_16 = 0;
			}
			break;
		case R.id.tag13_17:
			if(flag13_17 == 0){
				tag13_17.setImageResource(R.drawable.tag13_17_2);
				flag13_17 = 1;
			}else if(flag13_17 == 1){
				tag13_17.setImageResource(R.drawable.tag13_17_1);
				flag13_17 = 0;
			}
			break;
		case R.id.tag13_18:
			if(flag13_18 == 0){
				tag13_18.setImageResource(R.drawable.tag13_18_2);
				flag13_18 = 1;
			}else if(flag13_18 == 1){
				tag13_18.setImageResource(R.drawable.tag13_18_1);
				flag13_18 = 0;
			}
			break;
		case R.id.tag13_19:
			if(flag13_19 == 0){
				tag13_19.setImageResource(R.drawable.tag13_19_2);
				flag13_19 = 1;
			}else if(flag13_19 == 1){
				tag13_19.setImageResource(R.drawable.tag13_19_1);
				flag13_19 = 0;
			}
			break;
		case R.id.tag13_20:
			if(flag13_20 == 0){
				tag13_20.setImageResource(R.drawable.tag13_20_2);
				flag13_20 = 1;
			}else if(flag13_20 == 1){
				tag13_20.setImageResource(R.drawable.tag13_20_1);
				flag13_20 = 0;
			}
			break;
		case R.id.tag13_21:
			if(flag13_21 == 0){
				tag13_21.setImageResource(R.drawable.tag13_21_2);
				flag13_21 = 1;
			}else if(flag13_21 == 1){
				tag13_21.setImageResource(R.drawable.tag13_21_1);
				flag13_21 = 0;
			}
			break;
		case R.id.tag13_22:
			if(flag13_22 == 0){
				tag13_22.setImageResource(R.drawable.tag13_22_2);
				flag13_22 = 1;
			}else if(flag13_22 == 1){
				tag13_22.setImageResource(R.drawable.tag13_22_1);
				flag13_22 = 0;
			}
			break;
		case R.id.tag13_23:
			if(flag13_23 == 0){
				tag13_23.setImageResource(R.drawable.tag13_23_2);
				flag13_23 = 1;
			}else if(flag13_23 == 1){
				tag13_23.setImageResource(R.drawable.tag13_23_1);
				flag13_23 = 0;
			}
			break;
		case R.id.tag13_24:
			if(flag13_24 == 0){
				tag13_24.setImageResource(R.drawable.tag13_24_2);
				flag13_24 = 1;
			}else if(flag13_24 == 1){
				tag13_24.setImageResource(R.drawable.tag13_24_1);
				flag13_24 = 0;
			}
			break;
		case R.id.tag13_25:
			if(flag13_25 == 0){
				tag13_25.setImageResource(R.drawable.tag13_25_2);
				flag13_25 = 1;
			}else if(flag13_25 == 1){
				tag13_25.setImageResource(R.drawable.tag13_25_1);
				flag13_25 = 0;
			}
			break;
		case R.id.tag13_26:
			if(flag13_26 == 0){
				tag13_26.setImageResource(R.drawable.tag13_26_2);
				flag13_26 = 1;
			}else if(flag13_26 == 1){
				tag13_26.setImageResource(R.drawable.tag13_26_1);
				flag13_26 = 0;
			}
			break;
		case R.id.tag13_27:
			if(flag13_27 == 0){
				tag13_27.setImageResource(R.drawable.tag13_27_2);
				flag13_27 = 1;
			}else if(flag13_27 == 1){
				tag13_27.setImageResource(R.drawable.tag13_27_1);
				flag13_27 = 0;
			}
			break;
		case R.id.tag13_28:
			if(flag13_28 == 0){
				tag13_28.setImageResource(R.drawable.tag13_28_2);
				flag13_28 = 1;
			}else if(flag13_28 == 1){
				tag13_28.setImageResource(R.drawable.tag13_28_1);
				flag13_28 = 0;
			}
			break;
		
		}
	}

	private void clearFace() {
		face1.setImageResource(R.drawable.face1_1);
		face2.setImageResource(R.drawable.face2_1);
		face3.setImageResource(R.drawable.face3_1);
		face4.setImageResource(R.drawable.face4_1);
		face5.setImageResource(R.drawable.face5_1);
		face6.setImageResource(R.drawable.face6_1);
	}

	private void clearSkin() {
		skin1.setImageResource(R.drawable.skin1_1);
		skin2.setImageResource(R.drawable.skin2_1);
		skin3.setImageResource(R.drawable.skin3_1);
		skin4.setImageResource(R.drawable.skin4_1);
	}

	private void clearClothes(int id) {

		if (id == 5) {
			list5Image1_1.setImageResource(R.drawable.selected_1);
			list5Image2_1.setImageResource(R.drawable.selected_1);
			list5Image3_1.setImageResource(R.drawable.selected_1);
			list5Image4_1.setImageResource(R.drawable.selected_1);
		}
		if (id == 6) {
			list6Image1_1.setImageResource(R.drawable.selected_1);
			list6Image2_1.setImageResource(R.drawable.selected_1);
			list6Image3_1.setImageResource(R.drawable.selected_1);
			list6Image4_1.setImageResource(R.drawable.selected_1);
			list6Image5_1.setImageResource(R.drawable.selected_1);
			list6Image6_1.setImageResource(R.drawable.selected_1);
			list6Image7_1.setImageResource(R.drawable.selected_1);
		}
		if (id == 7) {
			list7Image1_1.setImageResource(R.drawable.selected_1);
			list7Image2_1.setImageResource(R.drawable.selected_1);
			list7Image3_1.setImageResource(R.drawable.selected_1);
			list7Image4_1.setImageResource(R.drawable.selected_1);
			list7Image5_1.setImageResource(R.drawable.selected_1);
			list7Image6_1.setImageResource(R.drawable.selected_1);
			list7Image7_1.setImageResource(R.drawable.selected_1);
		}
		if (id == 8) {
			list8Image1_1.setImageResource(R.drawable.selected_1);
			list8Image2_1.setImageResource(R.drawable.selected_1);
			list8Image3_1.setImageResource(R.drawable.selected_1);
			list8Image4_1.setImageResource(R.drawable.selected_1);
			list8Image5_1.setImageResource(R.drawable.selected_1);
			list8Image6_1.setImageResource(R.drawable.selected_1);
			list8Image7_1.setImageResource(R.drawable.selected_1);
		}
		if (id == 9) {
			list9Image1_1.setImageResource(R.drawable.selected_1);
			list9Image2_1.setImageResource(R.drawable.selected_1);
			list9Image3_1.setImageResource(R.drawable.selected_1);
			list9Image4_1.setImageResource(R.drawable.selected_1);
			list9Image5_1.setImageResource(R.drawable.selected_1);
			list9Image6_1.setImageResource(R.drawable.selected_1);
			list9Image7_1.setImageResource(R.drawable.selected_1);
		}
	}

	private void showQuestionView(int num) {
		layout.setVisibility(View.GONE);
		switch (num) {
		case 1:
			initView1();
			break;
		case 2:
			initView2();
			break;
		case 3:
			initView3();
			break;
		case 4:
			initView4();
			break;
		case 5:
			initView5();
			break;
		case 6:
			initView6();
			break;
		case 7:
			initView7();
			break;
		case 8:
			initView8();
			break;
		case 9:
			initView9();
			break;
		case 10:
			initView10();
			break;
		case 11:
			initView11();
			break;
		case 12:
			initView12();
			break;
		case 13:
			initView13();
			break;
		}
	}

}
