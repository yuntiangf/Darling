package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.adapter.ViewPagerAdapter;
import com.darling.ui.Fragment1_start;
import com.darling.ui.Fragment2_start;
import com.darling.ui.Fragment3_start;
import com.darling.ui.Fragment4_start;
import com.darling.ui.Fragment5_start;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 引导页
 * @author:MushRoom
 * @date:2015-11-22 下午7:50:29
 */
public class LeaderActivity extends FragmentActivity {

	private ViewPager viewPage;
	private Fragment1_start mFragment1;
	private Fragment2_start mFragment2;
	private Fragment3_start mFragment3;
	private Fragment4_start mFragment4;
	private Fragment5_start mFragment5;
	private PagerAdapter mPgAdapter;
	private RadioGroup dotLayout;
	private List<Fragment> mListFragment = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_webview);

		initView();
		viewPage.setOnPageChangeListener(new MyPagerChangeListener());

	}

	private void initView() {
		//dotLayout = (RadioGroup) findViewById(R.id.advertise_point_group);
		viewPage = (ViewPager) findViewById(R.id.viewpager);
		mFragment1 = new Fragment1_start();
		mFragment2 = new Fragment2_start();
		mFragment3 = new Fragment3_start();
		mFragment4 = new Fragment4_start();
		mFragment5 = new Fragment5_start();
		mListFragment.add(mFragment1);
		mListFragment.add(mFragment2);
		mListFragment.add(mFragment3);
		mListFragment.add(mFragment4);
		mListFragment.add(mFragment5);
		mPgAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
				mListFragment);
		viewPage.setAdapter(mPgAdapter);

	}

	public class MyPagerChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int position) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			//((RadioButton) dotLayout.getChildAt(position)).setChecked(true);
		}

	}
}
