package com.darling.ui;

import com.darling.R;
import com.darling.activity.ConcernedUserActivity;
import com.darling.activity.MySettingsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class FifthFragment extends Fragment {

public FifthFragment(){
		
	}	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){

		View view=inflater.inflate(R.layout.fragment_fifth, container,false);
		initialEvents(view);
		return view;
	}
	
	private void initialEvents(View view){
		TextView mySetting=(TextView) view.findViewById(R.id.my_settings);
		mySetting.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//请求activity
				Intent intent=new Intent(getActivity(),MySettingsActivity.class);
				startActivity(intent);
			}
			
		});
		
		View concerned=view.findViewById(R.id.my_concerned);
		concerned.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),ConcernedUserActivity.class);
				intent.putExtra("title", "我关注的用户");
				
				startActivity(intent);				
			}			
		});
	}
	

}
