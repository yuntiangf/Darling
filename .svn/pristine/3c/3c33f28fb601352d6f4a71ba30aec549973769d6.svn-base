package com.darling.activity;

import java.util.ArrayList;
import java.util.Calendar;

import com.darling.R;
import com.darling.adapter.ImgAdapter;
import com.darling.adapter.ImgAdapter2;
import com.darling.widget.GalleryView;
import com.darling.widget.KeywordsFlow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author:hj
 * @date:2015-12-26 下午3:54:04
 */
public class QuestionnaireActivity extends BaseFragmentActivity implements OnClickListener,
OnItemSelectedListener,OnItemClickListener,OnValueChangeListener{
	
	private Button previous_page , next_page;
	private TextView page_number;
	private int num = 1;
	//问卷1
	private LinearLayout layout;
	private DatePicker mDatePicker;
	private TextView mTextView1;
	Calendar c = Calendar.getInstance();
	private int year = c.get(Calendar.YEAR);
	private int month = c.get(Calendar.MONTH);
	private int day = c.get(Calendar.DAY_OF_MONTH);
	
	//问卷2
	private NumberPicker height1,height2,height3,weight1,weight2;
	private TextView mTextView2;
	//问卷3
	private GalleryView galleryView = null;
	private ArrayList<Integer> faceImgList = new ArrayList<Integer>();;
	private TextView face_name,face_describe;
	private String[] face_Name={"鹅蛋脸","圆脸","瓜子脸","方脸"};
	private String[] face_Describe={"额头、颧骨宽度一致， 下巴曲线圆润自然",
									"额头、颧骨、下颌的宽度基本相同， 线条圆润",
									"瓜子脸上部略圆下部略尖，形似瓜子",
									"额头、颧骨、下颌的宽度基本相同， 四方四正"};
	//问卷4
	private ArrayList<Integer> skinImgList = new ArrayList<Integer>();
	private TextView skin_name;
	private String[] skin_Name={"晶莹白皙","自然圆润","自然偏黄","活力小麦"};
	//问卷5
	private ArrayList<Integer> clothesImgList1 = new ArrayList<Integer>();
	private TextView clothes_gallery1_page;
	private String[] clothes_Name1={"（第一组，共三组）","（第二组，共三组）","（第三组，共三组）"};
	//问卷6
	private ArrayList<Integer> clothesImgList2 = new ArrayList<Integer>();
	private TextView clothes_gallery2_page;
	private String[] clothes_Name2={"（第一组，共七组）","（第二组，共七组）","（第三组，共七组）",
									"（第四组，共七组）","（第五组，共七组）","（第六组，共七组）","（第七组，共七组）"};
	//问卷7
	private ArrayList<Integer> clothesImgList3 = new ArrayList<Integer>();
	private TextView clothes_gallery3_page;
//	private String[] clothes_Name3={"（第一组，共七组）","（第二组，共七组）","（第三组，共七组）",
//										"（第四组，共七组）","（第五组，共七组）","（第六组，共七组）","（第七组，共七组）"};
	//问卷8
	private ArrayList<Integer> clothesImgList4 = new ArrayList<Integer>();
	private TextView clothes_gallery4_page;
//	private String[] clothes_Name4={"（第一组，共七组）","（第二组，共七组）","（第三组，共七组）",
//										"（第四组，共七组）","（第五组，共七组）","（第六组，共七组）","（第七组，共七组）"};
	//问卷9
	private ArrayList<Integer> clothesImgList5 = new ArrayList<Integer>();
	private TextView clothes_gallery5_page;
//	private String[] clothes_Name5={"（第一组，共七组）","（第二组，共七组）","（第三组，共七组）",
//										"（第四组，共七组）","（第五组，共七组）","（第六组，共七组）","（第七组，共七组）"};
	//问卷10
	private ListView question_list;
	private TextView choose;
	private String[] question_describe={"很正式的上午洽谈","不太随便就好的工作场合","逛街、日常小聚、轻松时刻",
			"约会、浪漫的甜蜜时间","典礼、隆重、庆典的场合","绚丽、梦幻的夜生活"};
	private Dialog dialog;
	//问卷11
	private NumberPicker upper,trouser1,trouser2,shoes1,shoes2;
	private TextView mTextView4,size_transform;
	String[] size_upper = {"XS","S","M","L","XL","XXL","3XL","4XL"};
	
	//问卷12
	private KeywordsFlow keywordsFlow1;
	private String[] keywords1;
	private ArrayList<String> choose_Tags1 = new ArrayList<String>();
	private TextView add_Tags1, clear_Tags1;
	private StringBuffer sb1 = new StringBuffer();
	//问卷12
	private KeywordsFlow keywordsFlow2;
	private String[] keywords2;
	private ArrayList<String> choose_Tags2 = new ArrayList<String>();
	private TextView add_Tags2, clear_Tags2;
	private StringBuffer sb2 = new StringBuffer();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		
		setContentView(R.layout.questionnaire);
		
		initView();
		initView1();
	}

	private void initView(){
		previous_page = (Button) findViewById(R.id.previous_page);
		next_page = (Button) findViewById(R.id.next_page);
		page_number = (TextView) findViewById(R.id.page_number);
		
		previous_page.setOnClickListener(this);
		next_page.setOnClickListener(this);
		page_number.setText(" "+num);
		
		if (num == 1) {
			previous_page.setVisibility(View.INVISIBLE);
		}else{
			previous_page.setVisibility(View.VISIBLE);
		}
		if(num == 13){
			next_page.setVisibility(View.INVISIBLE);
		}else{
			next_page.setVisibility(View.VISIBLE);
		}
	}
	
	private void initView1() {
		layout = (LinearLayout) findViewById(R.id.question_1);
		layout.setVisibility(View.VISIBLE);
		mDatePicker = (DatePicker) findViewById(R.id.datePicker);
		mTextView1 = (TextView) findViewById(R.id.show1);
		
		mDatePicker.init(year, month, day, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int month,
					int day) {
				QuestionnaireActivity.this.year = year;
				QuestionnaireActivity.this.month = month;
				QuestionnaireActivity.this.day = day;
				
				mTextView1.setText("您的出生日期为： " + year + "年 " + month + "月 " + day + "日  ");
			
			}
		});
		
	}

	private void initView2(){
		
		layout = (LinearLayout) findViewById(R.id.question_2);
		layout.setVisibility(View.VISIBLE);
		height1 = (NumberPicker) findViewById(R.id.height1);
		height2 = (NumberPicker) findViewById(R.id.height2);
		height3 = (NumberPicker) findViewById(R.id.height3);
		weight1 = (NumberPicker) findViewById(R.id.weight1);
		weight2 = (NumberPicker) findViewById(R.id.weight2);
		mTextView2 = (TextView) findViewById(R.id.show2);
		init(height1);
		init(height2);
		init(height3);
		init(weight1);
		init(weight2);
		
		if(height1.getValue() == 0 && height2.getValue() == 0 && height3.getValue() == 0
				&& weight1.getValue() == 0 && weight2.getValue() == 0){
			height1.setValue(1);
			height2.setValue(6);
			height3.setValue(5);
			weight1.setValue(4);
			weight1.setValue(5);
		}
		
	}
	
	private void init(final NumberPicker numberPicker){
		numberPicker.setMaxValue(9);
		numberPicker.setMinValue(0);
		numberPicker.setFocusable(true);
		numberPicker.setFocusableInTouchMode(true);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				numberPicker.setValue(newVal);
				int h = height1.getValue()*100 + height2.getValue()*10 + height3.getValue(); 
				int w = weight1.getValue()*10 + weight2.getValue();
				mTextView2.setText("您的身高是: "+h+ "cm"+"\n您的体重是: "+w+"kg");
			}
		});
	}
	
	private void initView3(){
		layout = (LinearLayout) findViewById(R.id.question_3);
		layout.setVisibility(View.VISIBLE);
		face_name = (TextView) findViewById(R.id.face_name);
		face_describe = (TextView) findViewById(R.id.face_describe);
		
		if(faceImgList.size() == 0){
			faceImgList.add(R.drawable.face1);
			faceImgList.add(R.drawable.face2);
			faceImgList.add(R.drawable.face3);
			faceImgList.add(R.drawable.face4);
			
		}
		
		galleryView = (GalleryView) findViewById(R.id.face_gallery);
		ImgAdapter adapter = new ImgAdapter(QuestionnaireActivity.this,faceImgList);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView4(){
		layout = (LinearLayout) findViewById(R.id.question_4);
		layout.setVisibility(View.VISIBLE);
		skin_name = (TextView) findViewById(R.id.skin_name);
		
		if(skinImgList.size() == 0){
			skinImgList.add(R.drawable.skin1);
			skinImgList.add(R.drawable.skin2);
			skinImgList.add(R.drawable.skin3);
			skinImgList.add(R.drawable.skin4);
			
		}
		
		galleryView = (GalleryView) findViewById(R.id.skin_gallery);
		ImgAdapter adapter = new ImgAdapter(QuestionnaireActivity.this,skinImgList);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView5(){
		layout = (LinearLayout) findViewById(R.id.question_5);
		layout.setVisibility(View.VISIBLE);
		clothes_gallery1_page = (TextView) findViewById(R.id.clothes_gallery1_page);
		
		if(clothesImgList1.size() == 0){
			clothesImgList1.add(R.drawable.clothes_gallery1_1);
			clothesImgList1.add(R.drawable.clothes_gallery1_2);
			clothesImgList1.add(R.drawable.clothes_gallery1_3);
			clothesImgList1.add(R.drawable.clothes_gallery1_4);
			clothesImgList1.add(R.drawable.clothes_gallery1_5);
			clothesImgList1.add(R.drawable.clothes_gallery1_6);
			clothesImgList1.add(R.drawable.clothes_gallery1_7);
			clothesImgList1.add(R.drawable.clothes_gallery1_8);
			clothesImgList1.add(R.drawable.clothes_gallery1_9);
			
		}
		
		galleryView = (GalleryView) findViewById(R.id.clothes_gallery1);
		ImgAdapter2 adapter = new ImgAdapter2(QuestionnaireActivity.this,clothesImgList1);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView6(){
		layout = (LinearLayout) findViewById(R.id.question_6);
		layout.setVisibility(View.VISIBLE);
		clothes_gallery2_page = (TextView) findViewById(R.id.clothes_gallery2_page);
		
		if(clothesImgList2.size() == 0){
			clothesImgList2.add(R.drawable.clothes_gallery1_1);
			clothesImgList2.add(R.drawable.clothes_gallery1_2);
			clothesImgList2.add(R.drawable.clothes_gallery1_3);
			clothesImgList2.add(R.drawable.clothes_gallery1_4);
			clothesImgList2.add(R.drawable.clothes_gallery1_5);
			clothesImgList2.add(R.drawable.clothes_gallery1_6);
			clothesImgList2.add(R.drawable.clothes_gallery1_7);
			clothesImgList2.add(R.drawable.clothes_gallery1_8);
			clothesImgList2.add(R.drawable.clothes_gallery1_9);
			clothesImgList2.add(R.drawable.clothes_gallery1_1);
			clothesImgList2.add(R.drawable.clothes_gallery1_2);
			clothesImgList2.add(R.drawable.clothes_gallery1_3);
			clothesImgList2.add(R.drawable.clothes_gallery1_4);
			clothesImgList2.add(R.drawable.clothes_gallery1_5);
			clothesImgList2.add(R.drawable.clothes_gallery1_6);
			clothesImgList2.add(R.drawable.clothes_gallery1_7);
			clothesImgList2.add(R.drawable.clothes_gallery1_8);
			clothesImgList2.add(R.drawable.clothes_gallery1_9);
			clothesImgList2.add(R.drawable.other);
			clothesImgList2.add(R.drawable.other);
			clothesImgList2.add(R.drawable.other);
		}
		
		galleryView = (GalleryView) findViewById(R.id.clothes_gallery2);
		ImgAdapter2 adapter = new ImgAdapter2(QuestionnaireActivity.this,clothesImgList2);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView7(){
		layout = (LinearLayout) findViewById(R.id.question_7);
		layout.setVisibility(View.VISIBLE);
		clothes_gallery3_page = (TextView) findViewById(R.id.clothes_gallery3_page);
		
		if(clothesImgList3.size() == 0){
			clothesImgList3.add(R.drawable.clothes_gallery1_1);
			clothesImgList3.add(R.drawable.clothes_gallery1_2);
			clothesImgList3.add(R.drawable.clothes_gallery1_3);
			clothesImgList3.add(R.drawable.clothes_gallery1_4);
			clothesImgList3.add(R.drawable.clothes_gallery1_5);
			clothesImgList3.add(R.drawable.clothes_gallery1_6);
			clothesImgList3.add(R.drawable.clothes_gallery1_7);
			clothesImgList3.add(R.drawable.clothes_gallery1_8);
			clothesImgList3.add(R.drawable.clothes_gallery1_9);
			clothesImgList3.add(R.drawable.clothes_gallery1_1);
			clothesImgList3.add(R.drawable.clothes_gallery1_2);
			clothesImgList3.add(R.drawable.clothes_gallery1_3);
			clothesImgList3.add(R.drawable.clothes_gallery1_4);
			clothesImgList3.add(R.drawable.clothes_gallery1_5);
			clothesImgList3.add(R.drawable.clothes_gallery1_6);
			clothesImgList3.add(R.drawable.clothes_gallery1_7);
			clothesImgList3.add(R.drawable.clothes_gallery1_8);
			clothesImgList3.add(R.drawable.clothes_gallery1_9);
			clothesImgList3.add(R.drawable.other);
			clothesImgList3.add(R.drawable.other);
			clothesImgList3.add(R.drawable.other);
		}
		
		galleryView = (GalleryView) findViewById(R.id.clothes_gallery3);
		ImgAdapter2 adapter = new ImgAdapter2(QuestionnaireActivity.this,clothesImgList3);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView8(){
		layout = (LinearLayout) findViewById(R.id.question_8);
		layout.setVisibility(View.VISIBLE);
		clothes_gallery4_page = (TextView) findViewById(R.id.clothes_gallery4_page);
		
		if(clothesImgList4.size() == 0){
			clothesImgList4.add(R.drawable.clothes_gallery1_1);
			clothesImgList4.add(R.drawable.clothes_gallery1_2);
			clothesImgList4.add(R.drawable.clothes_gallery1_3);
			clothesImgList4.add(R.drawable.clothes_gallery1_4);
			clothesImgList4.add(R.drawable.clothes_gallery1_5);
			clothesImgList4.add(R.drawable.clothes_gallery1_6);
			clothesImgList4.add(R.drawable.clothes_gallery1_7);
			clothesImgList4.add(R.drawable.clothes_gallery1_8);
			clothesImgList4.add(R.drawable.clothes_gallery1_9);
			clothesImgList4.add(R.drawable.clothes_gallery1_1);
			clothesImgList4.add(R.drawable.clothes_gallery1_2);
			clothesImgList4.add(R.drawable.clothes_gallery1_3);
			clothesImgList4.add(R.drawable.clothes_gallery1_4);
			clothesImgList4.add(R.drawable.clothes_gallery1_5);
			clothesImgList4.add(R.drawable.clothes_gallery1_6);
			clothesImgList4.add(R.drawable.clothes_gallery1_7);
			clothesImgList4.add(R.drawable.clothes_gallery1_8);
			clothesImgList4.add(R.drawable.clothes_gallery1_9);
			clothesImgList4.add(R.drawable.other);
			clothesImgList4.add(R.drawable.other);
			clothesImgList4.add(R.drawable.other);
		}
		
		galleryView = (GalleryView) findViewById(R.id.clothes_gallery4);
		ImgAdapter2 adapter = new ImgAdapter2(QuestionnaireActivity.this,clothesImgList4);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView9(){
		layout = (LinearLayout) findViewById(R.id.question_9);
		layout.setVisibility(View.VISIBLE);
		clothes_gallery5_page = (TextView) findViewById(R.id.clothes_gallery5_page);
		
		if(clothesImgList5.size() == 0){
			clothesImgList5.add(R.drawable.clothes_gallery1_1);
			clothesImgList5.add(R.drawable.clothes_gallery1_2);
			clothesImgList5.add(R.drawable.clothes_gallery1_3);
			clothesImgList5.add(R.drawable.clothes_gallery1_4);
			clothesImgList5.add(R.drawable.clothes_gallery1_5);
			clothesImgList5.add(R.drawable.clothes_gallery1_6);
			clothesImgList5.add(R.drawable.clothes_gallery1_7);
			clothesImgList5.add(R.drawable.clothes_gallery1_8);
			clothesImgList5.add(R.drawable.clothes_gallery1_9);
			clothesImgList5.add(R.drawable.clothes_gallery1_1);
			clothesImgList5.add(R.drawable.clothes_gallery1_2);
			clothesImgList5.add(R.drawable.clothes_gallery1_3);
			clothesImgList5.add(R.drawable.clothes_gallery1_4);
			clothesImgList5.add(R.drawable.clothes_gallery1_5);
			clothesImgList5.add(R.drawable.clothes_gallery1_6);
			clothesImgList5.add(R.drawable.clothes_gallery1_7);
			clothesImgList5.add(R.drawable.clothes_gallery1_8);
			clothesImgList5.add(R.drawable.clothes_gallery1_9);
			clothesImgList5.add(R.drawable.other);
			clothesImgList5.add(R.drawable.other);
			clothesImgList5.add(R.drawable.other);
		}
		
		galleryView = (GalleryView) findViewById(R.id.clothes_gallery5);
		ImgAdapter2 adapter = new ImgAdapter2(QuestionnaireActivity.this,clothesImgList5);
		galleryView.setAdapter(adapter);
		galleryView.setFocusable(true);
		galleryView.setOnItemSelectedListener(this);
		galleryView.setOnItemClickListener(this);
	}
	
	private void initView10(){
		layout = (LinearLayout) findViewById(R.id.question_10);
		layout.setVisibility(View.VISIBLE);
		
		question_list = (ListView) findViewById(R.id.question_list);
		QuestionAdapter adapter = new QuestionAdapter();
		question_list.setAdapter(adapter);
		question_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				LayoutInflater layoutInflater = LayoutInflater.from(QuestionnaireActivity.this);
				View v = layoutInflater.inflate(R.layout.question_dialog, null);
				dialog = new AlertDialog.Builder(QuestionnaireActivity.this).setTitle("请选择……").
						setView(v).create();
				dialog.show();
				
				choose=(TextView) view.findViewById(R.id.choose);
				final TextView text1=(TextView) dialog.findViewById(R.id.text1);
				final TextView text2=(TextView) dialog.findViewById(R.id.text2);
				final TextView text3=(TextView) dialog.findViewById(R.id.text3);
				final TextView text4=(TextView) dialog.findViewById(R.id.text4);
				text1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						choose.setText("总是");
						dialog.dismiss();
					}
				});
				text2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						choose.setText("一周两次");
						dialog.dismiss();
					}
				});
				text3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						choose.setText("一月两次");
						dialog.dismiss();
					}
				});
				text4.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						choose.setText("很少");
						dialog.dismiss();
					}
				});
			}
		});
		
		
	}
	
	public class QuestionAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return question_describe.length;
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
			View view = View.inflate(QuestionnaireActivity.this, R.layout.question_item, null);
			TextView question = (TextView) view.findViewById(R.id.question_describe);
			String str = question_describe[position];
			question.setText(str);
			return view;
		}
		
	}
	
	private void initView11(){
		layout = (LinearLayout) findViewById(R.id.question_11);
		layout.setVisibility(View.VISIBLE);
		
		upper = (NumberPicker) findViewById(R.id.size_upper);
		trouser1 = (NumberPicker) findViewById(R.id.size_trouser1);
		trouser2 = (NumberPicker) findViewById(R.id.size_trouser2);
		shoes1 = (NumberPicker) findViewById(R.id.size_shoes1);
		shoes2 = (NumberPicker) findViewById(R.id.size_shoes2);
		mTextView4 = (TextView) findViewById(R.id.show3);
		size_transform = (TextView) findViewById(R.id.size_transform);
		size_transform.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(QuestionnaireActivity.this, "尺码转换……", Toast.LENGTH_SHORT).show();
			}
		});
		
		upper.setDisplayedValues(size_upper);
		upper.setMinValue(0);
		upper.setMaxValue(size_upper.length-1);
		
		initSize(trouser1);
		init(trouser2);
		initSize(shoes1);
		init(shoes2);
		trouser1.setValue(2);
		trouser2.setValue(7);
		shoes1.setValue(3);
		shoes2.setValue(6);
		
		upper.setOnValueChangedListener(this);
		trouser1.setOnValueChangedListener(this);
		trouser2.setOnValueChangedListener(this);
		shoes1.setOnValueChangedListener(this);
		shoes2.setOnValueChangedListener(this);
	}
	
	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		mTextView4.setText("您选择常穿的上衣的尺码是："+size_upper[upper.getValue()].toString()+
				"\n 裤子的尺码是："+trouser1.getValue()+trouser2.getValue()+
				"\n 鞋子的尺码是："+shoes1.getValue()+shoes2.getValue());
	}
	
	private void initSize(final NumberPicker numberPicker){
		numberPicker.setMaxValue(4);
		numberPicker.setMinValue(1);
		numberPicker.setFocusable(true);
		numberPicker.setFocusableInTouchMode(true);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				numberPicker.setValue(newVal);
			}
		});
	}
	
	private void initView12(){
		layout = (LinearLayout) findViewById(R.id.question_12);
		layout.setVisibility(View.VISIBLE);
		
		add_Tags1 = (TextView) findViewById(R.id.add_Tags1);
		clear_Tags1 = (TextView) findViewById(R.id.clear_Tags1);
		keywordsFlow1 = (KeywordsFlow) findViewById(R.id.keywordsflow1);
		
		clear_Tags1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clearChoose(choose_Tags1,sb1,add_Tags1);
			}
		});
		
		initTags(layout.getId());
		refreshTags(keywordsFlow1,keywords1,choose_Tags1,sb1,add_Tags1);
		
	}
	
	private void initView13(){
		layout = (LinearLayout) findViewById(R.id.question_13);
		layout.setVisibility(View.VISIBLE);
		
		add_Tags2 = (TextView) findViewById(R.id.add_Tags2);
		clear_Tags2 = (TextView) findViewById(R.id.clear_Tags2);
		keywordsFlow2 = (KeywordsFlow) findViewById(R.id.keywordsflow2);
		
		clear_Tags2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clearChoose(choose_Tags2,sb2,add_Tags2);
			}
		});
		
		initTags(layout.getId());
		refreshTags(keywordsFlow2,keywords2,choose_Tags2,sb2,add_Tags2);
		
	}
	private void initTags( int id){
		if(id == R.id.question_12){
			keywords1 = new String[] { "肩膀锁骨", "美背", "臀部", "看脸就好", "颈部优雅",
					"胸部", "手臂", "小腹线条", "腿部", "脚踝", "纤纤玉足"};
			
		}
		if(id == R.id.question_13){
			keywords2 = new String[] { "头太小", "脖子短", "肩太宽", "平胸", "短手臂","驼背", "大肚腩", 
					"大pp", "扁pp", "腿不直", "5-5身","大腿粗", "身材过度", "小腿粗","肥短", "胖全身", 
					"宽pp", "大胃王","肉肉背", "手臂粗", "大胸","溜肩", "肩太紧","脖子粗", "头很大"};
			
		}
	}
	
	//更新标签
	private void refreshTags(KeywordsFlow keywordsFlow,String[] keywords,final ArrayList<String> choose_Tags,final StringBuffer sb,
			final TextView add_Tags) {
		keywordsFlow.setDuration(800l);
		
		keywordsFlow.setOnItemClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String keyword = ((TextView) v).getText().toString();// 获得点击的标签
				saveChooseTags(keyword,choose_Tags,sb,add_Tags);
			}
		});
		// 添加
		for (int i = 0; i < keywords.length; i++) {
			String tmp = keywords[i];
			keywordsFlow.feedKeyword(tmp,keywords.length);
		}
		
		keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
	}
	
	/*
	 * 保存搜索记录
	 */
	private void saveChooseTags(String str,ArrayList<String> choose_Tags,StringBuffer sb,TextView add_Tags) {
		if(choose_Tags.size() > 0){
			for (int i = 0; i < choose_Tags.size(); i++) {
				if (str.equals(choose_Tags.get(i))) {
					Toast.makeText(QuestionnaireActivity.this, "已添加！", Toast.LENGTH_SHORT).show();
					break;
				}else if(i == choose_Tags.size()-1){
					choose_Tags.add(str);
					sb.append(","+str);
					break;
				}
			}
			
		}else{
			choose_Tags.add(str);
			sb.append(str);
		}
		add_Tags.setText(sb);
	}

	private void clearChoose(ArrayList<String> choose_Tags,StringBuffer sb,TextView add_Tags) {
		Toast.makeText(this, "清除历史记录", Toast.LENGTH_LONG).show();
		add_Tags.setText("");
		choose_Tags.clear();
		sb.setLength(0);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.previous_page:
			num --;
			initView();
			showQuestionView(num);
			break;
		case R.id.next_page:
			num++;
			initView();
			showQuestionView(num);
			break;
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch (galleryView.getId()) {
		case R.id.face_gallery:
			position = position % faceImgList.size();
			face_name.setText(face_Name[position]);
			face_describe.setText(face_Describe[position]);
			break;
		case R.id.skin_gallery:
			position = position % skinImgList.size();
			skin_name.setText(skin_Name[position]);
			break;
		case R.id.clothes_gallery1:
			position = position % (clothesImgList1.size()/3);
			clothes_gallery1_page.setText(clothes_Name1[position]);
			break;
		case R.id.clothes_gallery2:
			position = position % (clothesImgList2.size()/3);
			clothes_gallery2_page.setText(clothes_Name2[position]);
			break;
		case R.id.clothes_gallery3:
			position = position % (clothesImgList3.size()/3);
			clothes_gallery3_page.setText(clothes_Name2[position]);
			break;
		case R.id.clothes_gallery4:
			position = position % (clothesImgList4.size()/3);
			clothes_gallery4_page.setText(clothes_Name2[position]);
			break;
		case R.id.clothes_gallery5:
			position = position % (clothesImgList5.size()/3);
			clothes_gallery5_page.setText(clothes_Name2[position]);
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (galleryView.getId()) {
		case R.id.face_gallery:
			position = position % faceImgList.size();
			Toast.makeText(QuestionnaireActivity.this, "您的脸型是："+ face_Name[position].toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.skin_gallery:
			position = position % skinImgList.size();
			Toast.makeText(QuestionnaireActivity.this, "您的肤色是："+ skin_Name[position].toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_gallery1:
			position = position % (clothesImgList1.size() / 3);
			Toast.makeText(QuestionnaireActivity.this, "上班时必须穿第 "+(position+1) +" 组", Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_gallery2:
			position = position % (clothesImgList2.size() / 3);
			Toast.makeText(QuestionnaireActivity.this, "不上班时常穿第 "+(position+1) +" 组", Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_gallery3:
			position = position % (clothesImgList3.size() / 3);
			Toast.makeText(QuestionnaireActivity.this, "我最喜欢的着装风格是第 "+(position+1) +" 组", Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_gallery4:
			position = position % (clothesImgList4.size() / 3);
			Toast.makeText(QuestionnaireActivity.this, "我最想尝试的新风格是第 "+(position+1) +" 组", Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_gallery5:
			position = position % (clothesImgList5.size() / 3);
			Toast.makeText(QuestionnaireActivity.this, "我真心无法接受的风格是第 "+(position+1) +" 组", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
