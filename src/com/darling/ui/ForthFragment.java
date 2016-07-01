package com.darling.ui;

import java.util.ArrayList;

import com.darling.R;
import com.darling.adapter.ViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ForthFragment extends Fragment implements OnClickListener ,OnPageChangeListener{

	private String mTitle = "Default";
	private FragmentManager fragmentManager;

	private ArrayList<Fragment> fragments;
	private ViewPager viewPager;
	// 推荐、潮品、品类标签
	private ImageView tab_recommend;
	private ImageView tab_fashion;
	private ImageView tab_category;
	
	private ImageView tab_zero;
	private ImageView tab_scan;
	public ForthFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){
		
		//获取传递参数
		if(getArguments()!=null){
			mTitle=getArguments().getString("title");			
		}
		
		View view=inflater.inflate(R.layout.fragment_forth, container,false);
		initViewPager(view);
		initViews(view);
		return view;
	}
	
	
	public void initViews(View view) {
		
		tab_recommend = (ImageView) view.findViewById(R.id.find_tab_one);
		tab_fashion = (ImageView) view.findViewById(R.id.find_tab_two);
		tab_category = (ImageView) view.findViewById(R.id.find_tab_three);
		
		tab_recommend.setOnClickListener(this);
		tab_fashion.setOnClickListener(this);
		tab_category.setOnClickListener(this);
		
		tab_zero = (ImageView) view.findViewById(R.id.find_tab_zero);
		tab_scan = (ImageView) view.findViewById(R.id.find_tab_scan);
		
		tab_zero.setOnClickListener(this);
		tab_scan.setOnClickListener(this);
	}

	public void initViewPager(View view) {
		fragmentManager = getChildFragmentManager();
		viewPager = (ViewPager) view.findViewById(R.id.find_view_pager);

		fragments = new ArrayList<Fragment>();
		fragments.add(new RecommendFragment());
		fragments.add(new FashionFragment());
		fragments.add(new CategoryFragment());
		
		viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),fragments));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(this);
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.find_tab_one:
			TabClean();
			tab_recommend.setImageResource(R.drawable.recommend_1);
			viewPager.setCurrentItem(0);
			break;
		case R.id.find_tab_two:
			TabClean();
			tab_fashion.setImageResource(R.drawable.fashion_1);
			viewPager.setCurrentItem(1);
			break;
		case R.id.find_tab_three:
			TabClean();
			tab_category.setImageResource(R.drawable.category_1);
			viewPager.setCurrentItem(2);
			break;
		case R.id.find_tab_scan:
			Toast.makeText(getActivity(), "扫一扫 Click", Toast.LENGTH_SHORT).show();
			break;
		}
	}
	
	private void TabClean(){
		tab_recommend.setImageResource(R.drawable.recommend_2);
		tab_fashion.setImageResource(R.drawable.fashion_2);
		tab_category.setImageResource(R.drawable.category_2);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int arg0) {
		TabClean();
		switch(arg0){
		case 0:
			tab_recommend.setImageResource(R.drawable.recommend_1);
			break;
		case 1:
			tab_fashion.setImageResource(R.drawable.fashion_1);
			break;
		case 2:
			tab_category.setImageResource(R.drawable.category_1);
			break;
		}
	}
	
}
