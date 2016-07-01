package com.darling.activity;

import java.util.ArrayList;

import com.darling.R;
import com.darling.adapter.ViewPagerAdapter;
import com.darling.ui.FirstItemDetailItemFrag;
import com.darling.ui.FirstItemDetailMatchFrag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class FirstItemDetailActivity extends FragmentActivity {

	private ArrayList<Fragment> fragments;
	private ViewPager viewPager;
	//单品页
	private TextView tab_item;
	//相关搭配页
	private TextView tab_match;
	
	private int line_width;
	private TextView barline;
	private int currIndex;//当前页卡编号  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_item_detail);
		
		initTxtView();
		initTextBar();
		initViewPager();
	}	
	
	/**
	 * 初始化标签名
	 * @author:MushRoom
	 * @date:2015-12-12 下午1:57:05
	 */
	public void initTxtView(){
		
		tab_item=(TextView) findViewById(R.id.tab_item);
		tab_match=(TextView) findViewById(R.id.tab_match);
		
		tab_item.setOnClickListener(new txListener(0));
		tab_match.setOnClickListener(new txListener(1));
	}
	
	/**
	 * 初始化位移像素
	 * @author:MushRoom
	 * @date:2015-12-12 下午1:56:37
	 */
	public void initTextBar(){
		barline=(TextView) findViewById(R.id.first_item_cursor);
		Display display = getWindow().getWindowManager().getDefaultDisplay();
        // 得到显示屏宽度
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		// 1/2屏幕宽度
		line_width = metrics.widthPixels /2;
		LayoutParams lp = (LayoutParams) barline.getLayoutParams();
		lp.width = line_width;
		
		barline.setLayoutParams(lp);
	}
	
	/**
	 * 初始化viewpager
	 * @author:MushRoom
	 * @date:2015-12-12 下午2:00:15
	 */
	public void initViewPager(){
		viewPager=(ViewPager) findViewById(R.id.first_item_detail_viewPager);
		
		fragments=new ArrayList<Fragment>();
		fragments.add(new FirstItemDetailItemFrag());
		fragments.add(new FirstItemDetailMatchFrag());
		//适配器
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments));
		viewPager.setCurrentItem(0);
		//设置事件监听
		viewPager.setOnPageChangeListener(new PageChangeListener());
	}
	
	public class PageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			LinearLayout.LayoutParams ll=(LayoutParams) barline.getLayoutParams();
			if(currIndex==arg0){
				ll.leftMargin = (int) (currIndex * barline.getWidth() + arg1
                        * barline.getWidth());
           }else if(currIndex > arg0){
           	 	ll.leftMargin = (int) (currIndex * barline.getWidth() - (1 - arg1)* barline.getWidth());
           }
			barline.setLayoutParams(ll);
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
    public class txListener implements View.OnClickListener{  
        private int index=0;  
          
        public txListener(int i) {  
            index =i;  
        }  
        @Override  
        public void onClick(View v) {  
        	viewPager.setCurrentItem(index);  
        }  
    } 
   
}
