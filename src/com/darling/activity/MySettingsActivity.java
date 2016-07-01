package com.darling.activity;

import com.darling.R;
import com.darling.util.CommonTools;
import com.darling.widget.ToggleButton;
import com.darling.widget.ToggleButton.OnToggleChanged;

import android.os.Bundle;
import android.view.Window;

public class MySettingsActivity extends BaseFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_settings);
		setmTitleName("设置");		
		
		initialEvent();				
	}
	
	private void initialEvent(){
		//分享设置
		ToggleButton tbtn_share=(ToggleButton) this.findViewById(R.id.tbtn_share); 	
		tbtn_share.toggleOn();
		tbtn_share.setOnToggleChanged(new OnToggleChanged(){
			@Override
			public void onToggle(boolean on) {
				if(on){
					CommonTools.showMsg(getApplicationContext(), "on", 1);
				}
				else{
					CommonTools.showMsg(getApplicationContext(), "off", 1);
				}
				
			}
			
		});
		//银行卡设置
		ToggleButton tbtn_card=(ToggleButton) this.findViewById(R.id.tbtn_card); 	
		tbtn_card.toggleOn();
		tbtn_card.setOnToggleChanged(new OnToggleChanged(){
			@Override
			public void onToggle(boolean on) {
				if(on){
					CommonTools.showMsg(getApplicationContext(), "on", 1);
				}
				else{
					CommonTools.showMsg(getApplicationContext(), "off", 1);
				}
				
			}
			
		});
		
	}
	
}
