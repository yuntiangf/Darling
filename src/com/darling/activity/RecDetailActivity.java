package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecDetailActivity extends BaseFragmentActivity implements OnClickListener{
	
	//列表
	private ImageView detail_category;
	private List<String> list_item = new ArrayList<String>();
	private ListView cg_list; 
	private int cg_flog = 0;
	
	//单品视图控件
	private LinearLayout layout;
	private TextView detail_item , detail_match; 
	private GridView gridView ;
	private int src;
	private int length;
	//搭配界面控件
	private ImageView match_clothes;
	private ImageView match_buy1,match_buy2;
	private TextView match_chuanda;
	private LinearLayout match_like;
	private ImageView match_image;
	private GridView match_grid;
	private TextView match_order,match_buynow;
	private int match_src;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.recommend_detail);
		initView();
		
	}

	
	private void initView() {
		Intent intent = getIntent();
		src = intent.getIntExtra("image", R.drawable.model1_item1);
		length = intent.getIntExtra("size", 6);
		
		for (int i = 0; i <length*2; i++) {
			list_item.add("单品 "+(i+1));
		}
		
		
		detail_category = (ImageView) findViewById(R.id.detail_category);
		detail_item = (TextView) findViewById(R.id.detail_item);
		detail_match = (TextView) findViewById(R.id.detail_match);
		cg_list = (ListView) findViewById(R.id.cg_listview);
		layout = (LinearLayout) findViewById(R.id.detail_match_view);
		ListAdapter adapter = new ListAdapter(RecDetailActivity.this);
		cg_list.setAdapter(adapter);
		
		detail_category.setOnClickListener(this);
		detail_item.setOnClickListener(this);
		detail_match.setOnClickListener(this);
		
		cg_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(RecDetailActivity.this, "123-->"+list_item.get(position).toString(), 
						Toast.LENGTH_SHORT).show();
				src = mThumbIds[position];
				initGridView();
				initMatchView();
			}
		});
		
		initGridView();
	}
	
	
	private void initGridView(){
		gridView = (GridView) findViewById(R.id.detail_grid);
		gridView.setAdapter(new ImageAdapter(this));
		//单击GridView元素的响应
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(RecDetailActivity.this, "123-->"+list_item.get(position), 
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(RecDetailActivity.this,RecItemDetailActivity.class);
				intent.putExtra("image", src);
				intent.putExtra("size", list_item.size());
				startActivity(intent);
			}
		});
	}
	
	//初始化搭配界面
	private void initMatchView(){
		match_clothes = (ImageView) findViewById(R.id.match_clothes);
		match_buy1 = (ImageView) findViewById(R.id.match_buy1);
		match_chuanda = (TextView) findViewById(R.id.chuanda);
		match_like = (LinearLayout) findViewById(R.id.like);
		match_image = (ImageView) findViewById(R.id.match_image);
		match_grid = (GridView) findViewById(R.id.match_grid);
		match_order = (TextView) findViewById(R.id.match_order);
		match_buy2 = (ImageView) findViewById(R.id.match_buy2);
		match_buynow = (TextView) findViewById(R.id.buy_now);
		
		match_buy1.setOnClickListener(this);
		match_chuanda.setOnClickListener(this);
		match_like.setOnClickListener(this);
		match_order.setOnClickListener(this);
		match_buy2.setOnClickListener(this);
		match_buynow.setOnClickListener(this);
		
		match_image.setImageResource(src);
		match_clothes.setImageResource(match_src);
		
		match_grid.setAdapter(new MatchAdapter(this));
		match_grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				match_src = match_others[position];
				initMatchView();
			}
		});
		
	}
	
	class ListAdapter extends BaseAdapter{
		private Context context;
		public ListAdapter(Context context){
			this.context = context;
		}
		
		@Override
		public int getCount() {
			return list_item.size();
		}

		@Override
		public Object getItem(int position) {
			return list_item.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			String name = list_item.get(position);
			View view;
			ViewHolder viewHolder;
			try {
				if (convertView == null) {
					LayoutInflater inflater = LayoutInflater.from(context);
					view = inflater.inflate(R.layout.cg_list_item, null);
					viewHolder = new ViewHolder();
					viewHolder.item_name = (TextView) view.findViewById(R.id.item_text);
					
					view.setTag(viewHolder);
				}else{
					view = convertView;
					viewHolder = (ViewHolder) view.getTag();
				}
				viewHolder.item_name.setText(name.toString());
				
				return view;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		class ViewHolder{
			TextView item_name;
		}
		
	}

	//单品GridView
	class ImageAdapter extends BaseAdapter{
		private Context mContext;
		public ImageAdapter(Context context) {  
            this.mContext=context;  
        }  
		@Override
		public int getCount() {
			return list_item.size();
		}

		@Override
		public Object getItem(int position) {
			return list_item.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			//定义一个ImageView,显示在GridView里  
            ImageView imageView;  
            if(convertView==null){  
                imageView=new ImageView(mContext);  
                
                int width = mContext.getResources().getDisplayMetrics().widthPixels;
                int params = 0;
                if(cg_flog == 0){
                	params = ((width * 4 / 5) - 50) / 2;
                }else if(cg_flog == 1){
                	params = (width - 50) / 2;
                }
                
                imageView.setLayoutParams(new GridView.LayoutParams(params, params));  
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);  
                imageView.setPadding(8, 8, 8, 8);  
            }else{  
                imageView = (ImageView) convertView;  
            }  
//            imageView.setImageResource(mThumbIds[position]);  
            imageView.setImageResource(src);  
            return imageView;  
		}
		
	}
	
	//搭配GridView
	class MatchAdapter extends BaseAdapter{
		private Context mContext;
		public MatchAdapter(Context context) {  
            this.mContext=context;  
        }  
		@Override
		public int getCount() {
			return match_others.length;
		}

		@Override
		public Object getItem(int position) {
			return match_others[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			//定义一个ImageView,显示在GridView里  
            ImageView imageView;  
            if(convertView==null){  
                imageView=new ImageView(mContext);  
                
                int width = mContext.getResources().getDisplayMetrics().widthPixels;
                int params = 0;
                if(cg_flog == 0){
                	params = ((width * 4 / 5) - 50) / 3;
                }else if(cg_flog == 1){
                	params = (width - 50) / 3;
                }
                
                imageView.setLayoutParams(new GridView.LayoutParams(params, params));  
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);  
                imageView.setPadding(8, 8, 8, 8);  
            }else{  
                imageView = (ImageView) convertView;  
            }  
            imageView.setImageResource(match_others[position]);  
            return imageView;  
		}
		
	}
	private int[] mThumbIds = {
			R.drawable.model1_item1,R.drawable.model1_item2,
			R.drawable.model2_item1,R.drawable.model2_item2,
			R.drawable.model3_item1,R.drawable.model3_item2,
			R.drawable.model1_item1,R.drawable.model1_item2,
			R.drawable.model2_item1,R.drawable.model2_item2,
			R.drawable.model3_item1,R.drawable.model3_item2,
	};
	
	private int[] match_others = {
			R.drawable.item1,R.drawable.item2,
			R.drawable.item3,R.drawable.item4,
			R.drawable.item5
	};
	
	@Override
//	@SuppressLint("ResourceAsColor")
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_category:
			if(cg_flog == 0){
				cg_list.setVisibility(View.GONE);
				cg_flog = 1;
				detail_category.setImageResource(R.drawable.category_normal);
				initGridView();
				initMatchView();
			}else if(cg_flog == 1){
				cg_list.setVisibility(View.VISIBLE);
				cg_flog = 0;
				detail_category.setImageResource(R.drawable.category_selected);
				initGridView();
				initMatchView();
			}
			break;

		case R.id.detail_item:
			detail_item.setTextColor(Color.RED);
			detail_match.setTextColor(Color.BLACK);
			layout.setVisibility(View.GONE);
			gridView.setVisibility(View.VISIBLE);	
			initGridView();
			
			Toast.makeText(RecDetailActivity.this, "123-->单品", 
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.detail_match:
			detail_match.setTextColor(Color.RED);
			detail_item.setTextColor(Color.BLACK);
			layout.setVisibility(View.VISIBLE);	
			gridView.setVisibility(View.GONE);		

			initMatchView();
			
			Toast.makeText(RecDetailActivity.this, "123-->搭配", 
					Toast.LENGTH_SHORT).show();
			
			break;
		case R.id.match_buy1:
		case R.id.match_buy2:
			Toast.makeText(RecDetailActivity.this, "加入购物车！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.chuanda:
			Toast.makeText(RecDetailActivity.this, "我穿我搭！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.like:
			Toast.makeText(RecDetailActivity.this, "放入我的衣橱！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.match_order:
			Toast.makeText(RecDetailActivity.this, "预约试穿……", Toast.LENGTH_SHORT).show();
			break;
		case R.id.buy_now:
			Toast.makeText(RecDetailActivity.this, "立即购买！", Toast.LENGTH_SHORT).show();
			break;
		
		}
	}
}
