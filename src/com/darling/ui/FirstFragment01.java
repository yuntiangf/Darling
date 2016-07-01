package com.darling.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.darling.R;
import com.darling.activity.BrandActivity;
import com.darling.activity.FirstModelDetailActivity;
import com.darling.activity.MainActivity;
import com.darling.activity.QuestionHomePage;
import com.darling.adapter.FlowImageAdapter;
import com.darling.util.ImageLoaderTask;
import com.darling.util.TaskParam;
import com.darling.widget.CircleFlowIndicator;
import com.darling.widget.LazyScrollView;
import com.darling.widget.LazyScrollView.OnScrollListener;
import com.darling.widget.ViewFlow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
/**
 * 碎片1-1：社区上面部分
 * @author:MushRoom
 * @date:2015-10-25 下午1:55:54
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" }) 
public class FirstFragment01 extends Fragment implements OnClickListener{

	private ScrollView parentScrollView;
	//-----------------------滚动播放的图片 imageview 图片流
	//第一个viewflow 推广与专题
	private ViewFlow viewFlow01;
	//第二个viewflow 每日惊喜
	private ViewFlow viewFlow02;
	//-----------------------end	
	
	//-----------------------waterfall 瀑布流
	private LazyScrollView waterfall_scroll;
	private LinearLayout waterfall_container;
	private ArrayList<LinearLayout> waterfall_items;
	private Display display;
	private AssetManager assetManager;
	private List<String> image_filenames;
	private final String image_path="icon_images";
	
	//女士专区的瀑布流参数
	private int itemWidth;
	private int itemHeight=800;
	private int column_count=2; //显示列数
	private int page_count=14; //每次加载14张图片
	
	private int current_page=0;
	//----------------------- end
	
	//----主窗体的参数
	private ViewPager parentViewPager;
	public ViewPager getParentViewPager() {
		return parentViewPager;
	}

	public void setParentViewPager(ViewPager parentViewPager) {
		this.parentViewPager = parentViewPager;
	}
	private List<ImageView> mTabIndicator;
	public List<ImageView> getmTabIndicator() {
		return mTabIndicator;
	}

	public void setmTabIndicator(List<ImageView> mTabIndicator) {
		this.mTabIndicator = mTabIndicator;
	}
	//------主窗体参数  end
	
	//问卷调查
	private View imageButton;
	
	public FirstFragment01(){
		
	}	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){
		
		View view=inflater.inflate(R.layout.fragment_first01, container,false);
		parentScrollView=(ScrollView) view.findViewById(R.id.scrollView);
		
		//由于父scrollview控件中嵌套的瀑布流也是scrollview，难以监听子控件的事件，尝试通过父控件监听
		parentScrollView.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				return false;
			}
			
		});
		
		initImageButton(view);
		initImageFlow(view);
		initWaterFall(view);
		
		return view;
	}
	
	private void initImageButton(View view) {
		//我的衣橱
		View btnMyAlmirah=view.findViewById(R.id.theme01);
		btnMyAlmirah.setOnClickListener(new OnClickListener(){

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				//here
				//ImageView btnTwo=(ImageView) getActivity().findViewById(R.id.id_indicator_two);
				parentViewPager.setCurrentItem(1, false);
				mTabIndicator.get(1).setImageResource(R.drawable.two_sel);
				
			}
			
		});
		
		
		//我的专属造型师
		imageButton = view.findViewById(R.id.theme02);
		imageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),QuestionHomePage.class);
				startActivity(intent);
			}
		});
		
		//品牌搭不停
		ImageView zara=(ImageView) view.findViewById(R.id.brand5);
		zara.setOnClickListener(this);
		
		
	}
	
	/**
	 * 初始化imageflow信息
	 * 两组图片流
	 * @author:MushRoom
	 * @date:2015-12-1 下午11:14:00
	 * @param view
	 */
	private void initImageFlow(View view){
		ViewPager viewpager=((MainActivity)getActivity()).getViewPager();
		
		
		//1.推广与专题
		viewFlow01 = (ViewFlow) view.findViewById(R.id.viewflow01);
		int[] imgs={R.drawable.header01,R.drawable.header02,R.drawable.header01};
		viewFlow01.setAdapter(new FlowImageAdapter(this.getActivity().getApplicationContext(),imgs));
		
		viewFlow01.setViewPager(viewpager);
		viewFlow01.setScrollView(parentScrollView);
		viewFlow01.setmSideBuffer(3); // 实际图片张数， 我的ImageAdapter实际图片张数为3

		CircleFlowIndicator indic01 = (CircleFlowIndicator) view.findViewById(R.id.viewflowindic01);
		viewFlow01.setFlowIndicator(indic01);
		viewFlow01.setTimeSpan(4500);
		viewFlow01.setSelection(3 * 1000); // 设置初始位置
		viewFlow01.startAutoFlowTimer(); // 启动自动播放
		
		//2.每日惊喜
		viewFlow02=(ViewFlow) view.findViewById(R.id.viewflow02);
		int[] imgs2={R.drawable.everyday0,R.drawable.everyday1,R.drawable.everyday2};
		viewFlow02.setAdapter(new FlowImageAdapter(this.getActivity().getApplicationContext(),imgs2));
		viewFlow02.setViewPager(viewpager);
		viewFlow02.setScrollView(parentScrollView);
		viewFlow02.setmSideBuffer(3);
		
		CircleFlowIndicator indic02=(CircleFlowIndicator) view.findViewById(R.id.viewflowindic02);
		viewFlow02.setFlowIndicator(indic02);
		viewFlow02.setTimeSpan(4500);
		viewFlow02.setSelection(3*1000);
		viewFlow02.startAutoFlowTimer();
		
	}
	
	/**
	 * 初始化瀑布流
	 * 
	 * @author:MushRoom
	 * @date:2015-12-1 下午11:16:18
	 * @param view
	 */
	@SuppressLint("ClickableViewAccessibility") @SuppressWarnings("deprecation")
	private void initWaterFall(View view) {
		display = getActivity().getWindowManager().getDefaultDisplay();
		itemWidth = display.getWidth() / column_count; // 根据屏幕大小计算每一列的宽度
		assetManager = this.getActivity().getAssets();

		waterfall_scroll = (LazyScrollView) view
				.findViewById(R.id.waterfall_scroll);
		waterfall_scroll.getView();
		waterfall_scroll.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onTop() {
				// 滚动到最顶端
				Log.d("LazyScroll", "Scroll to top");
			}

			@Override
			public void onScroll() {
				// 滚动中
				Log.d("LazyScroll", "Scroll");
			}

			@Override
			public void onBottom() {
				// 滚动到最低端
				AddItemToContainer(++current_page, page_count);
			}
		});

		waterfall_container = (LinearLayout) view
				.findViewById(R.id.waterfall_container);
		waterfall_items = new ArrayList<LinearLayout>();

		for (int i = 0; i < column_count; i++) {
			LinearLayout itemLayout = new LinearLayout(view.getContext());
			LinearLayout.LayoutParams itemParam = new LinearLayout.LayoutParams(
					itemWidth, LayoutParams.WRAP_CONTENT);
			
			//这是针对我们万搭的瀑布流只有两行的显示
			if(i==0){
				itemLayout.setPadding(12, 0, 6, 0);
			}
			else{
				itemLayout.setPadding(6, 0, 12, 0);
			}			
			itemLayout.setOrientation(LinearLayout.VERTICAL);

			itemLayout.setLayoutParams(itemParam);
			waterfall_items.add(itemLayout);
			waterfall_container.addView(itemLayout);
		}

		try {
			// 加载所有图片的路径
			image_filenames = Arrays.asList(assetManager.list(image_path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 第一次加载
		AddItemToContainer(current_page, page_count);
	}
	
	/**
	 * 添加图片到容器中
	 * @author:MushRoom
	 * @date:2015-12-2 下午10:03:16
	 * @param pageindex
	 * @param pagecount
	 */
	private void AddItemToContainer(int pageindex,int pagecount){
		int j = 0;
		int imagecount = image_filenames.size();
		for (int i = pageindex * pagecount; i < pagecount * (pageindex + 1)
				&& i < imagecount; i++) {
			j = j >= column_count ? j = 0 : j;
			AddImage(image_filenames.get(i), j++);
		}
	}
	
	/**
	 * 添加指定图片到指定列
	 * @author:MushRoom
	 * @date:2015-12-2 下午10:06:05
	 * @param filename
	 * @param columnIndex
	 */
	private void AddImage(String filename,int columnIndex){
		View waterfallItem=LayoutInflater.from(this.getActivity())
				.inflate(R.layout.waterfallitem, null);
		ImageView item=(ImageView) waterfallItem.findViewById(R.id.waterfall_image);

		item.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String imgSrc=(String)v.getTag();
				Intent intent=new Intent(getActivity(),FirstModelDetailActivity.class);
				intent.putExtra("title", "搭配详情");
				intent.putExtra("userid", "lady_head1");
				intent.putExtra("imgSrc", imgSrc);
				
				startActivity(intent);				
			}
			
		});
		
		
		waterfall_items.get(columnIndex).addView(waterfallItem);
		
		//根据filename从后台获取发布人、点赞人数等信息。
		
		TaskParam param=new TaskParam();
		param.setAssetManager(assetManager);
		param.setFilename(image_path+"/"+filename);
		param.setItemWidth(itemWidth);
		param.setItemHeight(itemHeight);
		ImageLoaderTask task=new ImageLoaderTask(item);		
		task.execute(param);		
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch(v.getId()){
		case R.id.brand5:
			//zara
			intent=new Intent(getActivity(),BrandActivity.class);
			intent.putExtra("brand", "zara");					
			break;
			
		}
		startActivity(intent);	
		
	}


}
