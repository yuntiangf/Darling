package com.darling.ui;


import com.darling.R;
import com.darling.activity.MainActivity;
import com.darling.activity.WelcomeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment5_start extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.fragment5_start, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		TextView textView = (TextView) getView().findViewById(R.id.tvInNew);

		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 保存数据到SharePreference中以此判断是不是第一次登陆
				// getActivity().finish();
				
				//引导页完成之后应当进入欢迎界面。暂时按照CEO的要求改成直接进入系统 
				//2016年2月5日   mushroom 
				FragmentActivity mActivity=getActivity();
				Intent intent = new Intent();
				//intent.setClass(getActivity(), WelcomeActivity.class);
				intent.setClass(getActivity(), MainActivity.class);
				mActivity.startActivity(intent);
				mActivity.finish();
			}
		});
	}

}
