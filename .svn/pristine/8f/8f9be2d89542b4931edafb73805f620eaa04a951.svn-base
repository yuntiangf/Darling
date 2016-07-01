package com.darling.activity;

import com.darling.R;
import com.darling.widget.DragLayout;
import com.darling.widget.DragLayout.ShowNextPageNotifier;
import com.darling.widget.VerticalFragment1;
import com.darling.widget.VerticalFragment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;


@SuppressLint("ShowToast") public class ModelDetailActivity extends BaseFragmentActivity {

	private VerticalFragment1 fragment1;
	private VerticalFragment3 fragment3;
	private DragLayout draglayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		setContentView(R.layout.model_detail);
		Intent intent=getIntent();		
		setmTitleName(intent.getStringExtra("title"));
		String id=intent.getStringExtra("modelId");
		Toast.makeText(getApplicationContext(), id+"号用户", Toast.LENGTH_SHORT).show();
		
		initView();
	}

	/**
	 * 初始化View
	 */
	private void initView() {
		fragment1 = new VerticalFragment1();
		fragment3 = new VerticalFragment3();
		getSupportFragmentManager().beginTransaction()
				.add(R.id.first, fragment1).add(R.id.second, fragment3)
				.commit();

		ShowNextPageNotifier nextIntf = new ShowNextPageNotifier() {
			@Override
			public void onDragNext() {
				fragment3.initView();
			}
		};
		draglayout = (DragLayout) findViewById(R.id.draglayout);
		draglayout.setNextPageListener(nextIntf);
	}

}
