package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.adapter.ViewPagerAdapter;
import com.darling.ui.ThreeMFragment_item;
import com.darling.ui.ThreeMFragment_scene;
import com.darling.ui.ThreeMFragment_style;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeMinutesActivity extends BaseFragmentActivity implements
	OnPageChangeListener,OnClickListener{
	
	
	private ViewPager viewPager;
	private ImageView tab_style; //风格
	private ImageView tab_scene; //场景
	private ImageView tab_item; //定番
	private List<Fragment> lstFragments;
	private FragmentPagerAdapter mAdapter;
	
	private ImageView backView; //返回键

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		
		setContentView(R.layout.three_minutes);
		
		initialPager();
		initialViews();
	}
	
	private void initialPager(){
		viewPager=(ViewPager) findViewById(R.id.threeminutes_view_pager);
		lstFragments=new ArrayList<Fragment>();
		lstFragments.add(new ThreeMFragment_style());
		lstFragments.add(new ThreeMFragment_scene());
		lstFragments.add(new ThreeMFragment_item());
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){

    		@Override
			public int getCount()
			{
				return lstFragments.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return lstFragments.get(arg0);
			}
    	};
		
		viewPager.setAdapter(mAdapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(this);
	}
	private void initialViews(){
		tab_style=(ImageView) findViewById(R.id.threeminutes_tab_style);
		tab_scene=(ImageView) findViewById(R.id.threeminutes_tab_scene);
		tab_item=(ImageView) findViewById(R.id.threeminutes_tab_item);
		
		tab_style.setOnClickListener(this);
		tab_scene.setOnClickListener(this);
		tab_item.setOnClickListener(this);
		
		backView=(ImageView) findViewById(R.id.title_back);
		backView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();				
			}
			
		});
	}
	
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int arg0) {
		ClearSelection();
		switch(arg0){
		case 0:
			tab_style.setImageResource(R.drawable.threeminutes_tab_style1);
			break;
		case 1:
			tab_scene.setImageResource(R.drawable.threeminutes_tab_scene1);
			break;
		case 2:
			tab_item.setImageResource(R.drawable.threeminutes_tab_item1);
			break;
		}
	}
	
	//清除原来的选中状态
	private void ClearSelection(){
		tab_style.setImageResource(R.drawable.threeminutes_tab_style);
		tab_scene.setImageResource(R.drawable.threeminutes_tab_scene);
		tab_item.setImageResource(R.drawable.threeminutes_tab_item);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.threeminutes_tab_style:
			ClearSelection();
			tab_style.setImageResource(R.drawable.threeminutes_tab_style1);
			viewPager.setCurrentItem(0);
			break;
		case R.id.threeminutes_tab_scene:
			ClearSelection();
			tab_scene.setImageResource(R.drawable.threeminutes_tab_scene1);
			viewPager.setCurrentItem(1);
			break;	
		case R.id.threeminutes_tab_item:
			tab_item.setImageResource(R.drawable.threeminutes_tab_item1);
			viewPager.setCurrentItem(2);
			break;				
		}
	}
	
	/**
	 * 选件定番
	 * @author:MushRoom
	 * @date:2015-12-19 下午9:51:41
	 * @param view
	 */
	public void decideByOne(View view){
		TextView v=(TextView)view;
		String s=(String) v.getText();
		Toast.makeText(getApplicationContext(), "You have clicked "+s, Toast.LENGTH_SHORT).show();
	}
	
}
