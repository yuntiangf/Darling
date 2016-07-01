package com.darling.activity;

import com.darling.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author:hj
 * @date:2016-1-7 下午10:04:48
 */
public class MatchDetailActivity extends BaseFragmentActivity implements OnClickListener{

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

		Intent intent=getIntent();
		setmTitleName(intent.getStringExtra("title"));
		
		setContentView(R.layout.match_detail);
		
		initMatchView();
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
			
//			match_image.setImageResource(src);
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
	                int params = (width - 50) / 3;
	                
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
		
		private int[] match_others = {
				R.drawable.item1,R.drawable.item2,
				R.drawable.item3,R.drawable.item4,
				R.drawable.item5
		};
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.match_buy1:
		case R.id.match_buy2:
			Toast.makeText(this, "加入购物车！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.chuanda:
			Toast.makeText(this, "我穿我搭！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.like:
			Toast.makeText(this, "放入我的衣橱！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.match_order:
			Toast.makeText(this, "预约试穿……", Toast.LENGTH_SHORT).show();
			break;
		case R.id.buy_now:
			Toast.makeText(this, "立即购买！", Toast.LENGTH_SHORT).show();
			break;
		

		default:
			break;
		}
	}
		
}
