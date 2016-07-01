package com.darling.ui;
import com.darling.R;
import com.darling.activity.OneMinuteShakeActivity;
import com.darling.activity.Question;
import com.darling.activity.QuestionHomePage;
import com.darling.activity.ThreeMinutesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment{
	
	public SecondFragment(){
		
	}	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){	
		View view=inflater.inflate(R.layout.fragment_second, container,false);
		
		//三分钟出门穿什么？
		View threeminutesView=view.findViewById(R.id.three_minutes);
		threeminutesView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),ThreeMinutesActivity.class);
				intent.putExtra("title", "三分钟出门穿什么?");
				startActivity(intent);				
			}			
		});		
		
		//一分钟出门摇一摇
		View oneminuteView=view.findViewById(R.id.one_minute);
		oneminuteView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent =new Intent(getActivity(),OneMinuteShakeActivity.class);
				intent.putExtra("title", "一分钟出门摇一摇");
				startActivity(intent);
			}
			
		});
		
		//个人特质分析
		View personal=view.findViewById(R.id.wd_personal);
		personal.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v){
				Intent intent = new Intent(getActivity(),QuestionHomePage.class);
				startActivity(intent);
			}
			
		});
		
		return view;
	}
	
	
	
	
	
	
	
//	@Override
//	public View onCreateView(LayoutInflater inflater,
//			ViewGroup container,Bundle savedInstanceState){
//		
//		initCases();
//		View view=inflater.inflate(R.layout.fragment_second, container,false);
//		ModelAdapter adapter=new ModelAdapter(getActivity(),R.layout.model_item,lstCaseInfo);
//		ListView listView=(ListView) view.findViewById(R.id.listView_models);
//		listView.setAdapter(adapter);	
//		
//		listView.setOnItemClickListener(new OnItemClickListener(){
//
//			@SuppressLint("ShowToast") @Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				CaseInfo caseInfo=lstCaseInfo.get(position);
//				String style=caseInfo.getCase_style();
//				String modelId=caseInfo.getCase_id();
//				
//				//Toast.makeText((MainActivity)getActivity(), style, Toast.LENGTH_LONG).show();
//				//这个插入model_detail详情
//				Intent intent=new Intent((MainActivity)getActivity(),ModelDetailActivity.class);
//				intent.putExtra("title", "详     情");
//				intent.putExtra("modelId", modelId);
//				startActivity(intent);
//			}
//			
//		});
//		
//		return view;
//	}
//
//	private void initCases(){
//		String str="简洁,霸气，款型和细节十分出色,自信、有范、洋气、大牌,让你彻底脱胎换骨";
//		CaseInfo case1=new CaseInfo("case1","欧美风",str);
//		CaseInfo case2=new CaseInfo("case2","日韩风",str);
//		CaseInfo case3=new CaseInfo("case3","田园风",str);
//		CaseInfo case4=new CaseInfo("case4","中国风",str);
//		lstCaseInfo.add(case1);
//		lstCaseInfo.add(case2);		
//		lstCaseInfo.add(case3);
//		lstCaseInfo.add(case4);	
//	}
//	

}
