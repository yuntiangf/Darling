package com.darling.ui;


import com.darling.R;
import com.darling.util.HttpResultAnalysisUtil;
import com.darling.util.HttpUtils;
import com.darling.util.HttpUtils.CallBack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ThreeMFragment_style 
	extends Fragment implements OnClickListener {

	private String _httpUrl="http://1zou.me/api/style/1";
	private String _selectedStyle="";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view=inflater.inflate(R.layout.three_minutes_tab_style, container, false);
		
		initilEvents(view);
		
		return view;
	}

	private void initilEvents(View v){
		ImageView btnStyle1=(ImageView) v.findViewById(R.id.threeminutes_style1);
		ImageView btnStyle2=(ImageView) v.findViewById(R.id.threeminutes_style2);
		ImageView btnStyle3=(ImageView) v.findViewById(R.id.threeminutes_style3);
		ImageView btnStyle4=(ImageView) v.findViewById(R.id.threeminutes_style4);
		ImageView btnStyle5=(ImageView) v.findViewById(R.id.threeminutes_style5);
		ImageView btnStyle6=(ImageView) v.findViewById(R.id.threeminutes_style6);
		ImageView btnStyle7=(ImageView) v.findViewById(R.id.threeminutes_style7);
		ImageView btnStyle8=(ImageView) v.findViewById(R.id.threeminutes_style8);
		ImageView btnStyle9=(ImageView) v.findViewById(R.id.threeminutes_style9);
		ImageView btnStyle10=(ImageView) v.findViewById(R.id.threeminutes_style10);
		ImageView btnStyle11=(ImageView) v.findViewById(R.id.threeminutes_style11);
		ImageView btnStyle12=(ImageView) v.findViewById(R.id.threeminutes_style12);
		ImageView btnStyle13=(ImageView) v.findViewById(R.id.threeminutes_style13);
		ImageView btnStyle14=(ImageView) v.findViewById(R.id.threeminutes_style14);
		ImageView btnStyle15=(ImageView) v.findViewById(R.id.threeminutes_style15);
		ImageView btnStyle16=(ImageView) v.findViewById(R.id.threeminutes_style16);
		ImageView btnStyle17=(ImageView) v.findViewById(R.id.threeminutes_style17);
		
		btnStyle1.setOnClickListener(this);
		btnStyle2.setOnClickListener(this);
		btnStyle3.setOnClickListener(this);
		btnStyle4.setOnClickListener(this);
		btnStyle5.setOnClickListener(this);
		btnStyle6.setOnClickListener(this);
		btnStyle7.setOnClickListener(this);
		btnStyle8.setOnClickListener(this);
		btnStyle9.setOnClickListener(this);
		btnStyle10.setOnClickListener(this);
		btnStyle11.setOnClickListener(this);
		btnStyle12.setOnClickListener(this);
		btnStyle13.setOnClickListener(this);
		btnStyle14.setOnClickListener(this);
		btnStyle15.setOnClickListener(this);
		btnStyle16.setOnClickListener(this);
		btnStyle17.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		String url="";
		switch(v.getId())
		{
		case R.id.threeminutes_style1:
			url=this._httpUrl+"/oumei";
			_selectedStyle="欧美风格";
			break;
		case R.id.threeminutes_style2:
			url=this._httpUrl+"/rihan";
			_selectedStyle="日韩风格";
			break;
		case R.id.threeminutes_style3:
			url=this._httpUrl+"/sennv";
			_selectedStyle="森女风格";
			break;
		case R.id.threeminutes_style4:
			url=this._httpUrl+"/shunv";
			_selectedStyle="淑女风格";
			break;
		case R.id.threeminutes_style5:
			url=this._httpUrl+"/keai";
			_selectedStyle="可爱风格";
			break;
		case R.id.threeminutes_style6:
			url=this._httpUrl+"/xinggan";
			_selectedStyle="性感风格";
			break;
		case R.id.threeminutes_style7:
			url=this._httpUrl+"/youya";
			_selectedStyle="优雅风格";
			break;
		case R.id.threeminutes_style8:
			url=this._httpUrl+"/qingxin";
			_selectedStyle="清新风格";
			break;
		case R.id.threeminutes_style9:
			url=this._httpUrl+"/xueyuan";
			_selectedStyle="学院风格";
			break;
		case R.id.threeminutes_style10:
			url=this._httpUrl+"/fugu";
			_selectedStyle="复古风格";
			break;
		case R.id.threeminutes_style11:
			url=this._httpUrl+"/jianyue";
			_selectedStyle="简约风格";
			break;
		case R.id.threeminutes_style12:
			url=this._httpUrl+"/minzu";
			_selectedStyle="民族风格";
			break;
		case R.id.threeminutes_style13:
			url=this._httpUrl+"/jueshi";
			_selectedStyle="爵士风格";
			break;
		case R.id.threeminutes_style14:
			url=this._httpUrl+"/tianmei";
			_selectedStyle="甜美风格";
			break;
		case R.id.threeminutes_style15:
			url=this._httpUrl+"/menghuan";
			_selectedStyle="梦幻风格";
			break;
		case R.id.threeminutes_style16:
			url=this._httpUrl+"/nvshen";
			_selectedStyle="女神风格";
			break;
		case R.id.threeminutes_style17:
			url=this._httpUrl+"/shuaiqi";
			_selectedStyle="帅气风格";
			break;
			
		}
		
		RequestCallBack callback=new RequestCallBack();
		HttpUtils.doGetAsyn(url, callback);
		
	}
	
	class RequestCallBack implements CallBack{

		@Override
		public void onRequestComplete(String result) {			
			if(result.isEmpty()){
				Looper.prepare();
				Toast.makeText(getActivity().getApplicationContext(), "网络不佳，请再试一次吧。", Toast.LENGTH_LONG).show();
				Looper.loop();
				Log.i("mushroom","没有数据");
				return;
			}
			try{
				Looper.prepare();
				Log.i("mushroom",result);
				HttpResultAnalysisUtil analysisUtil = 
						new HttpResultAnalysisUtil(2,result,_selectedStyle,"forthisstyle",getActivity());
				Intent intent=analysisUtil.AnalysisResult();
				if(intent != null){
					startActivityForResult(intent,1);
				}
				else{
					Looper.prepare();					
					Toast.makeText(getActivity().getApplicationContext(), "网络不佳，请再试一次吧。", Toast.LENGTH_LONG).show();
					Looper.loop();
				}
				Looper.loop();
			}
			catch(Exception e){
				Log.i("mushroom",e.getMessage());
				return;
			}
			
			
		}
		
	}

}
