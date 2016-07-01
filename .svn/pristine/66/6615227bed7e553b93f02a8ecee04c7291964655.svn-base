package com.darling.activity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.ui.FifthFragment;
import com.darling.ui.FirstFragment01;
import com.darling.ui.ForthFragment;
import com.darling.ui.SecondFragment;
import com.darling.ui.ThirdFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements
		OnPageChangeListener,OnClickListener{
	private LinearLayout title_Layout;
	private ViewPager mViewPager;
	public ViewPager getViewPager(){
		return mViewPager;
	}
	
	private List<Fragment> mTabs=new ArrayList<Fragment>();
	private FragmentPagerAdapter mAdapter;
	private String[] mTitles=new String[]{
			"社区","我的衣橱","我穿我搭","发现","我的"
	};
	
	private Integer[] nIcons=new Integer[]{
			R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five
	};
	private Integer[] nIconsSel=new Integer[]{
			R.drawable.one_sel,R.drawable.two_sel,R.drawable.three_sel,R.drawable.four_sel,R.drawable.five_sel
	};
	ThirdFragment thirdFragment;
	
	private List<ImageView> mTabIndicator =new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        setOverflowShowingAlways();
        //getActionBar().setDisplayShowHomeEnabled(false);
        title_Layout = (LinearLayout) findViewById(R.id.title_layout);
        mViewPager=(ViewPager)findViewById(R.id.id_viewpager);
        
        initDatas();
        
        mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);        
    }

    private void setOverflowShowingAlways(){
    	try{
    		//true:if a permanent menu key is present
    		//false:otherwise
    		ViewConfiguration config=ViewConfiguration.get(this);
    		Field menuKeyField=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
    		menuKeyField.setAccessible(true);
    		menuKeyField.setBoolean(config, false);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    private void initDatas(){
    	//加载碎片
    	//1.社区
    	FirstFragment01 firstFragment=new FirstFragment01();    	
    	Bundle args1=new Bundle();
    	args1.putString("title", "社区");
    	firstFragment.setArguments(args1);
		mTabs.add(firstFragment); 
		
		//2.我的衣橱
		thirdFragment=new ThirdFragment();
		Bundle args3=new Bundle();
    	args3.putString("title", "我的衣橱");
		mTabs.add(thirdFragment); 
		
		//3。我穿我搭
		SecondFragment secondFragment=new SecondFragment();    	
    	Bundle args2=new Bundle();
    	args2.putString("title", "我穿我搭");
    	secondFragment.setArguments(args2);
		mTabs.add(secondFragment); 
		
		//4.发现		
		ForthFragment forthFragment=new ForthFragment();
		Bundle args4=new Bundle();
    	args4.putString("title", "发现");
    	forthFragment.setArguments(args4);
		mTabs.add(forthFragment); 	
		
		//5.我的
		FifthFragment fifthFragment=new FifthFragment();
		mTabs.add(fifthFragment);		 
    	
    	mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){

    		@Override
			public int getCount()
			{
				return mTabs.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mTabs.get(arg0);
			}
    	};
    	initTabIndicator();
    	
    	//fragment01的参数
    	firstFragment.setParentViewPager(mViewPager);
    	firstFragment.setmTabIndicator(mTabIndicator);
    }
    
    private void initTabIndicator()
	{
    	ImageView one = (ImageView) findViewById(R.id.id_indicator_one);
    	ImageView two = (ImageView) findViewById(R.id.id_indicator_two);
    	ImageView three = (ImageView) findViewById(R.id.id_indicator_three);
    	ImageView four = (ImageView) findViewById(R.id.id_indicator_four);
    	ImageView five = (ImageView) findViewById(R.id.id_indicator_five);
		
		mTabIndicator.add(one);
		mTabIndicator.add(two);
		mTabIndicator.add(three);
		mTabIndicator.add(four);
		mTabIndicator.add(five);
		
		View view_one=findViewById(R.id.view_indicator_one);
		View view_two=findViewById(R.id.view_indicator_two);
		View view_three=findViewById(R.id.view_indicator_three);
		View view_four=findViewById(R.id.view_indicator_four);
		View view_five=findViewById(R.id.view_indicator_five);
		
		view_one.setOnClickListener(this);
		view_two.setOnClickListener(this);
		view_three.setOnClickListener(this);
		view_four.setOnClickListener(this);
		view_five.setOnClickListener(this);

//		one.setOnClickListener(this);
//		two.setOnClickListener(this);
//		three.setOnClickListener(this);
//		four.setOnClickListener(this);
//		five.setOnClickListener(this);

		one.setImageResource(R.drawable.one_sel);
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.darling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetOtherTabs();
		
		switch (v.getId())
		{
		case R.id.view_indicator_one:
//			mTabIndicator.get(0).setIconAlpha(1.0f);
			mTabIndicator.get(0).setImageResource(R.drawable.one_sel);
			mViewPager.setCurrentItem(0, false);
			break;
		case R.id.view_indicator_two:
			mTabIndicator.get(1).setImageResource(R.drawable.two_sel);
			mViewPager.setCurrentItem(1, false);
			break;
		case R.id.view_indicator_three:
			mTabIndicator.get(2).setImageResource(R.drawable.three_sel);
			mViewPager.setCurrentItem(2, false);
			break;
		case R.id.view_indicator_four:
			mTabIndicator.get(3).setImageResource(R.drawable.four_sel);
			mViewPager.setCurrentItem(3, false);
			break;
		case R.id.view_indicator_five:
			mTabIndicator.get(4).setImageResource(R.drawable.five_sel);					
			mViewPager.setCurrentItem(4, false);
			break;
			
		}
	}
	
	private void resetOtherTabs()
	{
		for (int i = 0; i < mTabIndicator.size(); i++)
		{
			mTabIndicator.get(i).setImageResource(nIcons[i]);
		}		
	}
	
	/**
	 * 重置其他的icon
	 * @author:MushRoom
	 * @date:2016-1-3 下午4:46:52
	 * @param nExcept 排除的index
	 */
	private void resetOtherTabsExcept(int nExcept){
		for (int i = 0; i < mTabIndicator.size(); i++)
		{
			if(i==nExcept){
				mTabIndicator.get(i).setImageResource(nIconsSel[i]);
			}
			else{
				mTabIndicator.get(i).setImageResource(nIcons[i]);
			}
			if(nExcept == 3){
				title_Layout.setVisibility(View.GONE);
			}else{
				title_Layout.setVisibility(View.VISIBLE);
			}
		}
		
	}

	@Override
	public boolean onMenuOpened(int featureId,Menu menu){
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null)
		{
			if (menu.getClass().getSimpleName().equals("MenuBuilder"))
			{
				try
				{
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e)
				{
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}
	
	/**
	 * 界面滑动状态发生变化时调用
	 * arg=0:什么都没有发生
	 * arg=1:表示正在滑动
	 * arg=2:表示滑动完成
	 */
	@Override
	public void onPageScrollStateChanged(int arg) {
		
		
	}

	/**
	 * 界面滑动的过程中
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
//		if (positionOffset > 0)
//		{
//			ChangeColorIconWithTextView left = mTabIndicator.get(position);
//			ChangeColorIconWithTextView right = mTabIndicator.get(position + 1);
//
//			left.setIconAlpha(1 - positionOffset);
//			right.setIconAlpha(positionOffset);				
//		}
	}

	/**
	 * 界面滑动终止
	 */
	@Override
	public void onPageSelected(int position) {
		resetOtherTabsExcept(position);		
	}
	
	
}
