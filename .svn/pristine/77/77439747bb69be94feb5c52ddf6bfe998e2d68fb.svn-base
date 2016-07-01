package com.darling.ui;

import com.darling.R;
import com.darling.ui.ThreeMFragment_style.RequestCallBack;
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

public class ThreeMFragment_scene extends Fragment implements OnClickListener {

	private String _httpUrl = "http://1zou.me/api/style/1";
	private String _selectedScene = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.three_minutes_tab_scene,
				container, false);
		initilEvents(view);

		return view;
	}

	private void initilEvents(View v) {
		ImageView btnScene1 = (ImageView) v
				.findViewById(R.id.threeminutes_scene1);
		ImageView btnScene2 = (ImageView) v
				.findViewById(R.id.threeminutes_scene2);
		ImageView btnScene3 = (ImageView) v
				.findViewById(R.id.threeminutes_scene3);
		ImageView btnScene4 = (ImageView) v
				.findViewById(R.id.threeminutes_scene4);
		ImageView btnScene5 = (ImageView) v
				.findViewById(R.id.threeminutes_scene5);
		ImageView btnScene6 = (ImageView) v
				.findViewById(R.id.threeminutes_scene6);
		ImageView btnScene7 = (ImageView) v
				.findViewById(R.id.threeminutes_scene7);
		ImageView btnScene8 = (ImageView) v
				.findViewById(R.id.threeminutes_scene8);
		ImageView btnScene9 = (ImageView) v
				.findViewById(R.id.threeminutes_scene9);
		ImageView btnScene10 = (ImageView) v
				.findViewById(R.id.threeminutes_scene10);
		ImageView btnScene11 = (ImageView) v
				.findViewById(R.id.threeminutes_scene11);
		ImageView btnScene12 = (ImageView) v
				.findViewById(R.id.threeminutes_scene12);
		ImageView btnScene13 = (ImageView) v
				.findViewById(R.id.threeminutes_scene13);
		ImageView btnScene14 = (ImageView) v
				.findViewById(R.id.threeminutes_scene14);
		ImageView btnScene15 = (ImageView) v
				.findViewById(R.id.threeminutes_scene15);
		ImageView btnScene16 = (ImageView) v
				.findViewById(R.id.threeminutes_scene16);
		ImageView btnScene17 = (ImageView) v
				.findViewById(R.id.threeminutes_scene17);

		btnScene1.setOnClickListener(this);
		btnScene2.setOnClickListener(this);
		btnScene3.setOnClickListener(this);
		btnScene4.setOnClickListener(this);
		btnScene5.setOnClickListener(this);
		btnScene6.setOnClickListener(this);
		btnScene7.setOnClickListener(this);
		btnScene8.setOnClickListener(this);
		btnScene9.setOnClickListener(this);
		btnScene10.setOnClickListener(this);
		btnScene11.setOnClickListener(this);
		btnScene12.setOnClickListener(this);
		btnScene13.setOnClickListener(this);
		btnScene14.setOnClickListener(this);
		btnScene15.setOnClickListener(this);
		btnScene16.setOnClickListener(this);
		btnScene17.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String url = "";
		switch (v.getId()) {
		case R.id.threeminutes_scene1:
			url = this._httpUrl + "/yjkh";
			_selectedScene = "约见客户";
			break;
		case R.id.threeminutes_scene2:
			url = this._httpUrl + "/rcbg";
			_selectedScene = "日常办公";
			break;
		case R.id.threeminutes_scene3:
			url = this._httpUrl + "/tqzs";
			_selectedScene = "通勤专属";
			break;
		case R.id.threeminutes_scene4:
			url = this._httpUrl + "/zyzb";
			_selectedScene = "重要长辈";
			break;
		case R.id.threeminutes_scene5:
			url = this._httpUrl + "/jtjh";
			_selectedScene = "家庭聚会";
			break;
		case R.id.threeminutes_scene6:
			url = this._httpUrl + "/zswc";
			_selectedScene = "正式晚餐";
			break;
		case R.id.threeminutes_scene7:
			url = this._httpUrl + "/lryh";
			_selectedScene = "恋人约会";
			break;
		case R.id.threeminutes_scene8:
			url = this._httpUrl + "/sfgj";
			_selectedScene = "舒服逛街";
			break;
		case R.id.threeminutes_scene9:
			url = this._httpUrl + "/jpdr";
			_selectedScene = "街拍达人";
			break;
		case R.id.threeminutes_scene10:
			url = this._httpUrl + "/jmxj";
			_selectedScene = "姐妹小聚";
			break;
		case R.id.threeminutes_scene11:
			url = this._httpUrl + "/hft";
			_selectedScene = "PARTY嗨翻天";
			break;
		case R.id.threeminutes_scene12:
			url = this._httpUrl + "/ygst";
			_selectedScene = "阳光沙滩";
			break;
		case R.id.threeminutes_scene13:
			url = this._httpUrl + "/qsdj";
			_selectedScene = "轻松度假";
			break;
		case R.id.threeminutes_scene14:
			url = this._httpUrl + "/yxgl";
			_selectedScene = "有型赶路";
			break;
		case R.id.threeminutes_scene15:
			url = this._httpUrl + "/ctbs";
			_selectedScene = "长途跋涉";
			break;
		case R.id.threeminutes_scene16:
			url = this._httpUrl + "/hgxq";
			_selectedScene = "换个心情";
			break;
		case R.id.threeminutes_scene17:
			url = "http://1zou.me/api/shake/1";
			_selectedScene = "随便摇摇";
			break;

		}

		RequestCallBack callback = new RequestCallBack();
		HttpUtils.doGetAsyn(url, callback);

	}

	class RequestCallBack implements CallBack {

		@Override
		public void onRequestComplete(String result) {
			if (result.isEmpty()) {
				Looper.prepare();
				Toast.makeText(getActivity().getApplicationContext(),
						"网络不佳，请再试一次吧。", Toast.LENGTH_LONG).show();
				Looper.loop();
				Log.i("mushroom", "没有数据");
				return;
			}
			try {
				Looper.prepare();
				Log.i("mushroom", result);
				HttpResultAnalysisUtil analysisUtil = new HttpResultAnalysisUtil(
						2, result, _selectedScene, "forthisstyle",
						getActivity());
				Intent intent = analysisUtil.AnalysisResult();
				if (intent != null) {
					startActivityForResult(intent, 1);
				} else {
					Looper.prepare();
					Toast.makeText(getActivity().getApplicationContext(),
							"网络不佳，请再试一次吧。", Toast.LENGTH_LONG).show();
					Looper.loop();
				}
				Looper.loop();
			} catch (Exception e) {
				Log.i("mushroom", e.getMessage());
				return;
			}

		}
	}

}
