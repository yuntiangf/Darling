package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.adapter.ConcernedUserAdapter;
import com.darling.model.UserInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

/**
 * 我关注的用户信息
 * @author:MushRoom
 * @date:2015-12-13 下午1:30:20
 */
public class ConcernedUserActivity extends BaseFragmentActivity {

	private List<UserInfo> lstUserInfo=new ArrayList<UserInfo>();	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		
		setContentView(R.layout.user_list);		
		
		initUsers();
		ConcernedUserAdapter adapter=new ConcernedUserAdapter(
				this,R.layout.user_list_item,lstUserInfo);
		ListView lstView=(ListView) findViewById(R.id.listView_users);
		lstView.setAdapter(adapter);
		
	}
	
	private void initUsers(){
		UserInfo info=new UserInfo();
		info.setId("head");
		info.setName("user001");
		info.setSex("中学生");
		
		UserInfo info2=new UserInfo();
		info2.setId("head_other");
		info2.setName("user002");
		info2.setSex("大学生");
		
		UserInfo info3=new UserInfo();
		info3.setId("login");
		info3.setName("user003");
		info3.setSex("高中生");
		
		lstUserInfo.add(info);
		lstUserInfo.add(info2);
		lstUserInfo.add(info3);
	}
	
}
