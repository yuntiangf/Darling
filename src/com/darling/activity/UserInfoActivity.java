package com.darling.activity;

import com.darling.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class UserInfoActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	
		
		setContentView(R.layout.user_info);
		
		initialEvent();
		
	}
	
	private void initialEvent(){
		ImageView btnBack=(ImageView) findViewById(R.id.title_back);
		btnBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();				
			}
			
		});
	}
}
