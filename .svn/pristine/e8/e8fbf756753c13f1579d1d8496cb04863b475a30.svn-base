package com.darling.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.darling.R;
import com.darling.util.ImageLoaderTask;
import com.darling.util.TaskParam;
import com.darling.widget.LazyScrollView;
import com.darling.widget.LazyScrollView.OnScrollListener;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 我的衣橱中点击单品进入我的单品列表
 * @author:MushRoom
 * @date:2015-12-28 下午9:52:49
 */
public class ItemListActivity extends BaseFragmentActivity  {
	
	private String clothesType;
	private int nCount;

	private LazyScrollView waterfall_scroll;
	private LinearLayout waterfall_container;
	private ArrayList<LinearLayout> waterfall_items;
	private Display display;
	private AssetManager assetManager;
	private List<String> image_filenames;
	private final String image_path = "icon_images";

	private int itemWidth;

	private int column_count = 2;// 显示列数
	private int page_count = 15;// 每次加载15张图片

	private int current_page = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		Intent i=getIntent();		
		clothesType=i.getStringExtra("clothesType");
		nCount=i.getIntExtra("count", 0);		
		setmTitleName(clothesType+"列表");
		setContentView(R.layout.item_list);
		
		TextView count=(TextView) findViewById(R.id.count);
		count.setText(nCount+"件");		

		display = this.getWindowManager().getDefaultDisplay();
		itemWidth = display.getWidth() / column_count;// 根据屏幕大小计算每列大小
		assetManager = this.getAssets();

		InitLayout();
	}
	
	private void InitLayout() {
		waterfall_scroll = (LazyScrollView) findViewById(R.id.itemlist_waterfall);
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

		waterfall_container = (LinearLayout) this
				.findViewById(R.id.itemlist_container);
		waterfall_items = new ArrayList<LinearLayout>();

		for (int i = 0; i < column_count; i++) {
			LinearLayout itemLayout = new LinearLayout(this);
			LinearLayout.LayoutParams itemParam = new LinearLayout.LayoutParams(
					itemWidth, LayoutParams.WRAP_CONTENT);
			 itemParam.width = itemWidth;
			 itemParam.height = LayoutParams.WRAP_CONTENT;
			itemLayout.setPadding(2, 2, 2, 2);
			itemLayout.setOrientation(LinearLayout.VERTICAL);

			itemLayout.setLayoutParams(itemParam);
			waterfall_items.add(itemLayout);
			waterfall_container.addView(itemLayout);
		}

		// 加载所有图片路径

		try {
			image_filenames = Arrays.asList(assetManager.list(image_path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 第一次加载
		AddItemToContainer(current_page, page_count);
	}

	private void AddItemToContainer(int pageindex, int pagecount) {
		int j = 0;
		int imagecount = image_filenames.size();
		for (int i = pageindex * pagecount; i < pagecount * (pageindex + 1)
				&& i < imagecount; i++) {
			if(i>=nCount) return;
			j = j >= column_count ? j = 0 : j;
			AddImage(image_filenames.get(i), j++);

		}

	}

	private void AddImage(String filename, int columnIndex) {
//		ImageView item = (ImageView) LayoutInflater.from(this).inflate(
//				R.layout.waterfallitem, null);
		
		ImageView item=new ImageView(this.getApplicationContext());
		LayoutParams params=new LayoutParams(
				LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		item.setLayoutParams(params);		
		waterfall_items.get(columnIndex).addView(item);

		TaskParam param = new TaskParam();
		param.setAssetManager(assetManager);
		param.setFilename(image_path + "/" + filename);
		param.setItemWidth(itemWidth);
		ImageLoaderTask task = new ImageLoaderTask(item);
		task.execute(param);

	}

}
