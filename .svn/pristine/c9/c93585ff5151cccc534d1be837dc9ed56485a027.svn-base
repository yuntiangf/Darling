package com.darling.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.darling.R;
import com.darling.adapter.DetailBuyInfo;
import com.darling.model.ItemInfo;
import com.darling.util.GsonTools;
import com.darling.util.ImageLoaderTask;
import com.darling.util.ImageService;
import com.darling.util.TaskParam;
import com.darling.widget.LazyScrollView;
import com.darling.widget.LazyScrollView.OnScrollListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class RecommendActivity extends Activity implements OnClickListener{
	private LinearLayout layout;
//	private AssetManager assetManager;
//	private List<String> image_filenames;
//	private final String image_path="icon_images";
	//必买选项属性
	private ImageView detail_buy,detail_item,detail_match;
	private List<DetailBuyInfo> detail_buy_listInfo=new ArrayList<DetailBuyInfo>();
	private ListView detail_buy_list;
	//单品选项属性
	private ImageView screen_item;
	private ImageView item_new,item_price,item_discount;
	private GridView item_grid;
	private LazyScrollView item_scroll;
	private LinearLayout item_container;
	//单品选项属性
//	private GridView match_grid;
	private LazyScrollView match_scroll;
	private LinearLayout match_container;
	//瀑布流
	private LazyScrollView waterfall_scroll;
	private LinearLayout waterfall_container;
	private ArrayList<LinearLayout> waterfall_items;
	private Display display;
	private AssetManager assetManager;
	private List<String> image_filenames;
	private final String image_path="icon_images";
	
	private int itemWidth;
	private int page_count=18; //每次加载14张图片
	private int current_page=0;
//	private Context mContext;
	
//	public RecommendActivity(Context context) {
//		this.mContext = context;
//	}
	private String src = null;
	private List<Map<String, ItemInfo>> users;
	private Map<String, ItemInfo> user;
	private ImageService imageService;
	private String path = "http://1zou.me/images/";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recommend_detail2);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		initData();
		assetManager = this.getAssets();
		initView();
	}

	private void initView() {
		ImageView img = (ImageView) findViewById(R.id.title_back);
		img.setOnClickListener(this);
		
		detail_buy = (ImageView) findViewById(R.id.detail_buy);
		detail_item = (ImageView) findViewById(R.id.detail_item);
		detail_match = (ImageView) findViewById(R.id.detail_match);
		screen_item = (ImageView) findViewById(R.id.screen_item);
		
		detail_buy.setOnClickListener(this);
		detail_item.setOnClickListener(this);
		detail_match.setOnClickListener(this);
		
		initBuy();
	}

	private void initBuy() {
		layout = (LinearLayout) findViewById(R.id.layout_buy);
		layout.setVisibility(View.VISIBLE);
		if(detail_buy_listInfo.size() == 0){
			initBuyData();
		}
		detail_buy.setImageResource(R.drawable.detail_buy1);
		detail_buy_list = (ListView) findViewById(R.id.detail_buy_list);
		NecessaryBuyAdapter adapter = new NecessaryBuyAdapter(RecommendActivity.this);
		detail_buy_list.setAdapter(adapter);
		detail_buy_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(RecommendActivity.this, "必买单品。。。", Toast.LENGTH_SHORT).show();	
			}
		});
		
	}
	
	private void initBuyData(){
		
//		String[] buy_Name = { "蓝破洞牛仔裤", "纯色蝙蝠毛衣", "套头连体毛衣", "潮版人头平底鞋", 
//							  "蓝破洞牛仔裤", "纯色蝙蝠毛衣", "套头连体毛衣", "潮版人头平底鞋"};
		
		int[] buy_Img = { R.drawable.buy_item1, R.drawable.buy_item2,R.drawable.buy_item3, 
							R.drawable.buy_item4,R.drawable.buy_item1, R.drawable.buy_item2, 
							R.drawable.buy_item3, R.drawable.buy_item4};
		
		for (int i = 0; i < buy_Img.length; i++) {
			DetailBuyInfo buyInfo = new DetailBuyInfo(buy_Img[i]);
			detail_buy_listInfo.add(buyInfo);
		}
	}
	
	public class NecessaryBuyAdapter extends BaseAdapter{
		private Context mContext;
		public NecessaryBuyAdapter(Context context){
			this.mContext = context;
		}
		@Override
		public int getCount() {
			return detail_buy_listInfo.size();
		}

		@Override
		public Object getItem(int position) {
			return detail_buy_listInfo.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			DetailBuyInfo buyInfo = detail_buy_listInfo.get(position);
			View view;
			ViewHolder viewHolder;
			try {
				if(convertView == null){
					
					LayoutInflater inflater=LayoutInflater.from(mContext);				
					view=inflater.inflate(R.layout.detail_buy_list_item, null);
					viewHolder=new ViewHolder();
					viewHolder.buy_Img = (ImageView) view.findViewById(R.id.detail_buy_clothes_image);
					
					view.setTag(viewHolder);
				}else{
					view=convertView;
					viewHolder=(ViewHolder) view.getTag();
				}
				
				viewHolder.buy_Img .setImageResource(buyInfo.getDetail_buy_image());
				
				return view;
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		class ViewHolder{
			ImageView buy_Img;
		}
	}
	
	private void initItem(){
		layout = (LinearLayout) findViewById(R.id.layout_item);
		layout.setVisibility(View.VISIBLE);

//		initData();
		detail_item.setImageResource(R.drawable.detail_item1);
		screen_item.setOnClickListener(this);
		
		item_new = (ImageView) findViewById(R.id.item_new);
		item_price = (ImageView) findViewById(R.id.item_price);
		item_discount = (ImageView) findViewById(R.id.item_discount);
		
		item_new.setOnClickListener(this);
		item_price.setOnClickListener(this);
		item_discount.setOnClickListener(this);
//		initItemGrid();
		item_scroll = (LazyScrollView) findViewById(R.id.item_scroll);
		item_container = (LinearLayout) findViewById(R.id.item_container);
		
		initWaterFall(item_scroll,item_container,2);
	}
	
	private void initData(){
//		src = HttpUtils.getJsonContent("http://1zou.me/api/listeshopitems/upper");
		System.out.println("-->"+src);
		users = new ArrayList<Map<String,ItemInfo>>();
		users = GsonTools.listMap(src);
		System.out.println("-->"+users.size());
		for (int i = 0; i < users.size(); i++) {
			System.out.println("-->"+users.get(i).toString());
			user = users.get(i);
			System.out.println("-->"+user.get("id")); 
			System.out.println("-->"+user.get("image_path")); 
		}
//		String sr=HttpUtils.getJsonContent("http://1zou.me/api/listeshopitems/upper");
//		System.out.println("-->"+sr.toString());
////		List<User> users = GsonTools.getPersons(sr, User.class);
//		List<Map<String, ItemInfo>> users = GsonTools.listMap(sr);
//		System.out.println("-->"+users.size());
//		for (int i = 0; i < users.size(); i++) {
//			System.out.println("-->"+users.get(i).toString());
//			Map<String, ItemInfo> user = users.get(i);
//			System.out.println("-->"+user.get("id")); 
//			System.out.println("-->"+user.get("image_path")); 
//		}
	}
	
	private void initItemGrid() {
		item_grid = (GridView) findViewById(R.id.item_grid);
		
		try {
			image_filenames = Arrays.asList(assetManager.list(image_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		item_grid.setAdapter(new ItemGridAdapter(this));
		item_grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(RecommendActivity.this, "单品-->"+image_filenames.get(position), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public class ItemGridAdapter extends BaseAdapter{
		private Context mContext;
		public ItemGridAdapter(Context context) {  
            this.mContext=context;  
        }  
		@Override
		public int getCount() {
			return image_filenames.size();
		}

		@Override
		public Object getItem(int position) {
			return image_filenames.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;  
            if(convertView==null){  
//                imageView=new ImageView(mContext);  
                View view = LayoutInflater.from(mContext).inflate(R.layout.gridview_item, null);
                int width = mContext.getResources().getDisplayMetrics().widthPixels;
                int params = (width - 50) / 2;
                imageView = (ImageView) view.findViewById(R.id.item_image);
                imageView.setLayoutParams(new GridView.LayoutParams(params, params));  
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);  
                imageView.setPadding(8, 8, 8, 8);  
            }else{  
                imageView = (ImageView) convertView;  
            }  
//            imageService = new ImageService();
//            try {
//            	System.out.println("-->"+path+user.get("image_path"));
//				imageView.setImageBitmap(imageService.getImage(path+user.get("image_path")));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
            imageView.setImageDrawable(RecommendActivity.this.getDrawableFromAssets(mContext, 
            		image_path+"/"+image_filenames.get(position)));
            return imageView;  
		}
		
	}
	
	public Drawable getDrawableFromAssets(Context context,String imageFileName) {
        Drawable result = null;
        AssetManager assetManager = context.getAssets();
        InputStream is = null;
        try {
            is = assetManager.open(imageFileName);
            result = Drawable.createFromStream(is, null);
            is.close();
            is = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	private void initMatch(){
		layout = (LinearLayout) findViewById(R.id.layout_match);
		layout.setVisibility(View.VISIBLE);
		detail_match.setImageResource(R.drawable.detail_match1);
		
		match_scroll = (LazyScrollView) findViewById(R.id.match_scroll);
		match_container = (LinearLayout) findViewById(R.id.match_container);
		
		initWaterFall(match_scroll,match_container,3);
	}
	
private void initWaterFall(LazyScrollView waterfall_scroll, LinearLayout waterfall_container,final int column_count) {
		
		display = RecommendActivity.this.getWindowManager().getDefaultDisplay();
		itemWidth = display.getWidth() / column_count; // 根据屏幕大小计算每一列的宽度
		assetManager = this.getAssets();

//		waterfall_scroll = (LazyScrollView)findViewById(R.id.item_scroll);
		waterfall_scroll.getView();
		waterfall_scroll.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onTop() {
				//滑动到最顶端
				Log.d("mushroom", "top");
			}
			
			@Override
			public void onBottom() {
				// 滑动到底端
				AddItemToContainer(++current_page, page_count,column_count);
			}

			@Override
			public void onScroll() {
				Log.d("mushroom", "Scroll");
			}

		});

//		waterfall_container = (LinearLayout) findViewById(R.id.item_container);
		waterfall_items = new ArrayList<LinearLayout>();

		for (int i = 0; i < column_count; i++) {
			LinearLayout itemLayout = new LinearLayout(this.getApplicationContext());
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
			e.printStackTrace();
		}
		// 第一次加载
		AddItemToContainer(current_page, page_count,column_count);
	}

	//添加图片到容器中
	private void AddItemToContainer(int pageindex,int pagecount,int column_count){
		int j = 0;
		int imagecount = image_filenames.size();
		for (int i = pageindex * pagecount; i < pagecount * (pageindex + 1)
				&& i < imagecount; i++) {
			j = j >= column_count ? j = 0 : j;
			AddImage(image_filenames.get(i), j++);
		}
	}
	
	//添加指定图片到指定列
	private void AddImage(String filename,int columnIndex){
		int id = layout.getId();
		LinearLayout waterfallItem = null;
		ImageView item = null;
		if(id == R.id.layout_item){
			waterfallItem=(LinearLayout) LayoutInflater.from(RecommendActivity.this)
					.inflate(R.layout.item_waterfall, null);
			item=(ImageView) waterfallItem.findViewById(R.id.item_image);
//			imageService = new ImageService();
//			try {
//				item.setImageBitmap(imageService.getImage(path+users.get(0).get("image_path")));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			item.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(RecommendActivity.this,RecItemDetailActivity.class);
					intent.putExtra("title", "单品详情");
//					intent.putExtra("userid", "head_other");
					startActivity(intent);	
				}
			});
			
		}else if(id == R.id.layout_match){
			waterfallItem=(LinearLayout) LayoutInflater.from(RecommendActivity.this)
					.inflate(R.layout.match_waterfall, null);
			item=(ImageView) waterfallItem.findViewById(R.id.match_image);
			item.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent2=new Intent(RecommendActivity.this,MatchDetailActivity.class);
					intent2.putExtra("title", "搭配详情");
//					intent2.putExtra("userid", "head_other");
					startActivity(intent2);	
				}
			});
		}
		
		waterfall_items.get(columnIndex).addView(waterfallItem);
		
		//根据filename从后台获取发布人、点赞人数等信息。
		
		TaskParam param=new TaskParam();
		param.setAssetManager(assetManager);
		param.setFilename(image_path+"/"+filename);
		param.setItemWidth(itemWidth);
		ImageLoaderTask task=new ImageLoaderTask(item);		
		task.execute(param);		
	}
	
	//清除选项卡
	private void clearSelect(){
		detail_buy.setImageResource(R.drawable.detail_buy2);
		detail_item.setImageResource(R.drawable.detail_item2);
		detail_match.setImageResource(R.drawable.detail_match2);
	}
	
	private void clearSelect2(){
		item_new.setImageResource(R.drawable.item_new2);
		item_price.setImageResource(R.drawable.item_price2);
		item_discount.setImageResource(R.drawable.item_discount2);
	}
	
	@Override
	public void onClick(View v) {
		layout.setVisibility(View.GONE);
		clearSelect();
		switch (v.getId()) {
		case R.id.title_back:
			RecommendActivity.this.finish();
			break;
		case R.id.detail_buy:
			screen_item.setVisibility(View.INVISIBLE);
			initBuy();
			break;
		case R.id.detail_item:
			screen_item.setVisibility(View.VISIBLE);
			initItem();
			break;
		case R.id.detail_match:
			screen_item.setVisibility(View.INVISIBLE);
			initMatch();
			break;
		case R.id.screen_item:
			initItem();
			Toast.makeText(RecommendActivity.this, "筛选单品", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_new:
			clearSelect2();
			item_new.setImageResource(R.drawable.item_new1);
			initItem();
			Toast.makeText(RecommendActivity.this, "最新单品", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_price:
			clearSelect2();
			item_price.setImageResource(R.drawable.item_price1);
			initItem();
			Toast.makeText(RecommendActivity.this, "按价格排序", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_discount:
			clearSelect2();
			item_discount.setImageResource(R.drawable.item_discount1);
			initItem();
			Toast.makeText(RecommendActivity.this, "折扣单品", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
