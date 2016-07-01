package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecItemDetailActivity extends BaseFragmentActivity implements OnClickListener{
	
//	private ImageView detail_clothes;		//商品详情图片
//	private ImageView item_category;		//分类下拉列表图标
	private List<String> list_item = new ArrayList<String>();
	private ListView cg_list; 
	private int cg_flog = 0;
	private int src;
	private int length;
	private ImageView item_buy1, item_buy2;			//购物车图标1,2
	private TextView item_chuanda;					//我穿我搭 
	private LinearLayout item_like;					//like
	private TextView goods_name;					//商品名称
	private TextView item_price1,item_price2, only_phone, other;	//现价，原价，手机专享，参考多件折扣
	private TextView item_sales,item_review_rate;		//销量 ，好评率
	private GridView gridView ;
	private TextView item_order,item_buynow;		//试穿预约，立即购买
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		
		setContentView(R.layout.item_detail);
		
		initView();
	}

	private void initView() {
		Intent intent = getIntent();
		src = intent.getIntExtra("image", R.drawable.model1_item1);
		length = intent.getIntExtra("size", 6);
		
		for (int i = 0; i <length; i++) {
			list_item.add("单品 "+(i+1));
		}
		
		
		initView1();
		
		initView2();
		
		initView3();
		
		initView4();
	}

	private void initView1() {
//		detail_clothes = (ImageView) findViewById(R.id.detail_clothes);
//		item_category = (ImageView) findViewById(R.id.item_category);
		cg_list = (ListView) findViewById(R.id.cg_listview);
		item_buy1 = (ImageView) findViewById(R.id.item_buy1);
		item_chuanda = (TextView) findViewById(R.id.chuanda);
		item_like = (LinearLayout) findViewById(R.id.like);
		
//		detail_clothes.setImageResource(src);
//		item_category.setOnClickListener(this);
		
//		ListAdapter adapter = new ListAdapter(RecItemDetailActivity.this);
//		cg_list.setAdapter(adapter);
//		
//		cg_list.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				Toast.makeText(RecItemDetailActivity.this, "123-->"+list_item.get(position).toString(), 
//						Toast.LENGTH_SHORT).show();
//				src = mThumbIds[position];
//				
//			}
//		});
		
		item_buy1.setOnClickListener(this);
		item_chuanda.setOnClickListener(this);
		item_like.setOnClickListener(this);
	}

	private void initView2() {
		goods_name = (TextView) findViewById(R.id.goods_name);
		item_price1 = (TextView) findViewById(R.id.price1);
		item_price2 = (TextView) findViewById(R.id.price2);
		only_phone = (TextView) findViewById(R.id.only_phone);
		other = (TextView) findViewById(R.id.other);
		item_sales = (TextView) findViewById(R.id.sales);
		item_review_rate = (TextView) findViewById(R.id.review_rate);
		
		only_phone.setOnClickListener(this);
		other.setOnClickListener(this);
	}

	private void initView3() {
		gridView = (GridView) findViewById(R.id.item_grid);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(RecItemDetailActivity.this, "123-->"+list_item.get(position), 
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}
	
	private void initView4() {
		item_order = (TextView) findViewById(R.id.item_order);
		item_buy2 = (ImageView) findViewById(R.id.item_buy2);
		item_buynow = (TextView) findViewById(R.id.buy_now);
		
		item_order.setOnClickListener(this);
		item_buy2.setOnClickListener(this);
		item_buynow.setOnClickListener(this);
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
                int params = (width - 200) / 3;
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

	private int[] mThumbIds = {
			R.drawable.model1_item1,R.drawable.model1_item2,
			R.drawable.model2_item1,R.drawable.model2_item2,
			R.drawable.model3_item1,R.drawable.model3_item2,
			R.drawable.model1_item1,R.drawable.model1_item2,
			R.drawable.model2_item1,R.drawable.model2_item2,
			R.drawable.model3_item1,R.drawable.model3_item2,
	};
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
//		case R.id.item_category:
//			if(cg_flog == 0){
//				cg_list.setVisibility(View.VISIBLE);
//				cg_flog = 1;
//				item_category.setImageResource(R.drawable.category_selected);
//			}else if(cg_flog == 1){
//				cg_list.setVisibility(View.GONE);
//				cg_flog = 0;
//				item_category.setImageResource(R.drawable.category_normal);
//			}
//			break;
		case R.id.item_buy1:
		case R.id.item_buy2:
			Toast.makeText(RecItemDetailActivity.this, "加入购物车！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.chuanda:
			Toast.makeText(RecItemDetailActivity.this, "我穿我搭！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.like:
			Toast.makeText(RecItemDetailActivity.this, "放入我的衣橱！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_order:
			Toast.makeText(RecItemDetailActivity.this, "预约试穿……", Toast.LENGTH_SHORT).show();
			break;
		case R.id.buy_now:
			Toast.makeText(RecItemDetailActivity.this, "立即购买！", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
