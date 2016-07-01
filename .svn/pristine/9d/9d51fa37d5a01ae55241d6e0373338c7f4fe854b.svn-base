package com.darling.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.darling.R;
import com.darling.util.ImageLoaderTask;
import com.darling.util.TaskParam;
import com.darling.widget.LazyScrollView;
import com.darling.widget.LazyScrollView.OnScrollListener;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 碎片1-2：社区的下部分
 * @author:MushRoom
 * @date:2015-12-4 下午8:34:52
 */
public class FirstFragment02 extends Fragment {
	
	//-----------------------waterfall 瀑布流
	private LazyScrollView waterfall_scroll;
	private LinearLayout waterfall_container;
	private ArrayList<LinearLayout> waterfall_items;
	private Display display;
	private AssetManager assetManager;
	private List<String> image_filenames;
	private final String image_path="icon_images";
	
	private int itemWidth;
	private int column_count=2; //显示列数
	private int page_count=14; //每次加载14张图片
	
	private int current_page=0;
	//----------------------- end
	
	public FirstFragment02(){};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_first02, null);
			initWaterFall(rootView);
			
			return rootView;
		}
	
	/**
	 * 初始化瀑布流
	 * 
	 * @author:MushRoom
	 * @date:2015-12-1 下午11:16:18
	 * @param view
	 */
	@SuppressWarnings("deprecation")
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
				//滑动到最顶端
				// TODO Auto-generated method stub
				Log.d("mushroom", "top");
			}
			
			@Override
			public void onBottom() {
				// 滑動到底端
				AddItemToContainer(++current_page, page_count);
			}

			@Override
			public void onScroll() {
				// TODO Auto-generated method stub
				Log.d("mushroom", "Scroll");
			}

		});

		waterfall_container = (LinearLayout) view
				.findViewById(R.id.waterfall_container);
		waterfall_items = new ArrayList<LinearLayout>();

		for (int i = 0; i < column_count; i++) {
			LinearLayout itemLayout = new LinearLayout(view.getContext());
			LinearLayout.LayoutParams itemParam = new LinearLayout.LayoutParams(
					itemWidth, LayoutParams.WRAP_CONTENT);
			itemLayout.setPadding(2, 2, 2, 2);
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
		RelativeLayout waterfallItem=(RelativeLayout) LayoutInflater.from(this.getActivity())
				.inflate(R.layout.waterfallitem, null);
		ImageView item=(ImageView) waterfallItem.findViewById(R.id.waterfall_image);
//		ImageView item=(ImageView) LayoutInflater.from(this.getActivity()).inflate(
//				R.id.waterfall_image,null);		
//		waterfall_items.get(columnIndex).addView(item);
		waterfall_items.get(columnIndex).addView(waterfallItem);
		
		//根据filename从后台获取发布人、点赞人数等信息。
		
		TaskParam param=new TaskParam();
		param.setAssetManager(assetManager);
		param.setFilename(image_path+"/"+filename);
		param.setItemWidth(itemWidth);
		ImageLoaderTask task=new ImageLoaderTask(item);		
		task.execute(param);		
	}

}
