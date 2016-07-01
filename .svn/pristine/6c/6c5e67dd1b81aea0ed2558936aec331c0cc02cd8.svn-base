package com.darling.activity;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.adapter.DetailBuyInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Recommend extends Activity implements OnClickListener{
	private LinearLayout layout;
	//必买选项属性
	private ImageView detail_buy,detail_item,detail_match;
	private List<DetailBuyInfo> detail_buy_listInfo=new ArrayList<DetailBuyInfo>();
	private ListView detail_buy_list;
	//单品选项属性
	private ImageView screen_item;
	private ImageView item_new,item_price,item_discount;
	private ImageView clothes_item1,clothes_item2,clothes_item3,clothes_item4;
	//搭配选项属性
	private ImageView clothes_match1,clothes_match2,clothes_match3,clothes_match4,
			clothes_match5,clothes_match6,clothes_match7,clothes_match8,clothes_match9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recommend_detail3);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
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
		
		initItem();
	}

	private void initBuy() {
		layout = (LinearLayout) findViewById(R.id.layout_buy);
		layout.setVisibility(View.VISIBLE);
		if(detail_buy_listInfo.size() == 0){
			initBuyData();
		}
		detail_buy.setImageResource(R.drawable.detail_buy1);
		detail_buy_list = (ListView) findViewById(R.id.detail_buy_list);
		NecessaryBuyAdapter adapter = new NecessaryBuyAdapter(Recommend.this);
		detail_buy_list.setAdapter(adapter);
		detail_buy_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(Recommend.this, "必买单品。。。", Toast.LENGTH_SHORT).show();	
			}
		});
		
	}
	
	private void initBuyData(){
		
		int[] buy_Img = { R.drawable.buy_item1, R.drawable.buy_item2,R.drawable.buy_item3, 
							R.drawable.buy_item4};
		
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

		detail_item.setImageResource(R.drawable.detail_item1);
		screen_item.setOnClickListener(this);
		
		item_new = (ImageView) findViewById(R.id.item_new);
		item_price = (ImageView) findViewById(R.id.item_price);
		item_discount = (ImageView) findViewById(R.id.item_discount);
		
		item_new.setOnClickListener(this);
		item_price.setOnClickListener(this);
		item_discount.setOnClickListener(this);
		
		clothes_item1 = (ImageView) findViewById(R.id.clothes_item1);
		clothes_item2 = (ImageView) findViewById(R.id.clothes_item2);
		clothes_item3 = (ImageView) findViewById(R.id.clothes_item3);
		clothes_item4 = (ImageView) findViewById(R.id.clothes_item4);
		
		clothes_item1.setOnClickListener(this);
		clothes_item2.setOnClickListener(this);
		clothes_item3.setOnClickListener(this);
		clothes_item4.setOnClickListener(this);
	}
		
	private void initMatch(){
		layout = (LinearLayout) findViewById(R.id.layout_match);
		layout.setVisibility(View.VISIBLE);
		detail_match.setImageResource(R.drawable.detail_match1);
		
		clothes_match1 = (ImageView) findViewById(R.id.clothes_match1);
		clothes_match2 = (ImageView) findViewById(R.id.clothes_match2);
		clothes_match3 = (ImageView) findViewById(R.id.clothes_match3);
		clothes_match4 = (ImageView) findViewById(R.id.clothes_match4);
		clothes_match5 = (ImageView) findViewById(R.id.clothes_match5);
		clothes_match6 = (ImageView) findViewById(R.id.clothes_match6);
		clothes_match7 = (ImageView) findViewById(R.id.clothes_match7);
		clothes_match8 = (ImageView) findViewById(R.id.clothes_match8);
		clothes_match9 = (ImageView) findViewById(R.id.clothes_match9);
		
		clothes_match1.setOnClickListener(this);
		clothes_match2.setOnClickListener(this);
		clothes_match3.setOnClickListener(this);
		clothes_match4.setOnClickListener(this);
		clothes_match5.setOnClickListener(this);
		clothes_match6.setOnClickListener(this);
		clothes_match7.setOnClickListener(this);
		clothes_match8.setOnClickListener(this);
		clothes_match9.setOnClickListener(this);
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
			Recommend.this.finish();
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
			Toast.makeText(Recommend.this, "筛选单品", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_new:
			clearSelect2();
			item_new.setImageResource(R.drawable.item_new1);
			initItem();
			Toast.makeText(Recommend.this, "最新单品", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_price:
			clearSelect2();
			item_price.setImageResource(R.drawable.item_price1);
			initItem();
			Toast.makeText(Recommend.this, "按价格排序", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_discount:
			clearSelect2();
			item_discount.setImageResource(R.drawable.item_discount1);
			initItem();
			Toast.makeText(Recommend.this, "折扣单品", Toast.LENGTH_SHORT).show();
			break;
		case R.id.clothes_item1:
		case R.id.clothes_item2:
		case R.id.clothes_item3:
		case R.id.clothes_item4:
			Intent intent = new Intent(Recommend.this,RecItemDetailActivity.class);
			intent.putExtra("title", "单品详情");
			startActivity(intent);
			initItem();
			break;
		case R.id.clothes_match1:
		case R.id.clothes_match2:
		case R.id.clothes_match3:
		case R.id.clothes_match4:
		case R.id.clothes_match5:
		case R.id.clothes_match6:
		case R.id.clothes_match7:
		case R.id.clothes_match8:
		case R.id.clothes_match9:
			Intent intent2 = new Intent(Recommend.this,MatchDetailActivity.class);
			intent2.putExtra("title", "搭配详情");
			startActivity(intent2);
			initMatch();
			break;
		}
	}


}
