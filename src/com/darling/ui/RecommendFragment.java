package com.darling.ui;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.activity.Recommend;
import com.darling.model.RecommendInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class RecommendFragment extends Fragment{
	
	private List<RecommendInfo> listRecInfo=new ArrayList<RecommendInfo>();
	private Intent intent;
	
	public RecommendFragment(){
	}
	
	@Override
	public View onCreateView(final LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){
		
		initCases();
		
		View view = inflater.inflate(R.layout.find_recommend_tab, container, false);
		RecommendAdapter recAdapter = new RecommendAdapter(getActivity());
		ListView listView=(ListView) view.findViewById(R.id.find_recommend_list);
		listView.setAdapter(recAdapter);	
		
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Toast.makeText(getActivity(), "专属推荐。。。", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(),Recommend.class);
				startActivity(intent);
			}
			
		});
		
		return view;
	}
	
	private void initCases(){
		int[] modelImg = {R.drawable.model1,R.drawable.model2};
		
		int[] item1Img = {R.drawable.model1_item1,R.drawable.model2_item1};
		
		int[] item2Img = {R.drawable.model1_item2,R.drawable.model2_item2};
		
		if(listRecInfo.size() == 0){
			for (int i = 0; i < modelImg.length; i++) {
				RecommendInfo recommendInfo = new RecommendInfo(modelImg[i], item1Img[i], item2Img[i]);
				listRecInfo.add(recommendInfo);
			}
		}
	}
	
	private class RecommendAdapter extends BaseAdapter{
		private Context context;
		
		private RecommendAdapter(Context context){
			this.context = context;
		}
		@Override
		public int getCount() {
			return listRecInfo.size();
		}

		@Override
		public Object getItem(int position) {
			return listRecInfo.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			RecommendInfo recInfo = listRecInfo.get(position);
			View view ;
			ViewHolder viewHolder;
			try {
				if(convertView == null){	
					LayoutInflater inflater=LayoutInflater.from(context);				
					view=inflater.inflate(R.layout.find_recommend_item, null);
					viewHolder=new ViewHolder();
					viewHolder.modelImg = (ImageView) view.findViewById(R.id.find_recommend_model_image);
					viewHolder.item1Img = (ImageView) view.findViewById(R.id.find_recommend_model_item1);
					viewHolder.item2Img = (ImageView) view.findViewById(R.id.find_recommend_model_item2);
					
					view.setTag(viewHolder);
				}else{
					view=convertView;
					viewHolder=(ViewHolder) view.getTag();
				}
				
				viewHolder.modelImg.setImageResource(recInfo.getRec_image());
				viewHolder.item1Img.setImageResource(recInfo.getRec_item1());
				viewHolder.item2Img.setImageResource(recInfo.getRec_item2());
				
				final int p = position;
//				viewHolder.modelImg.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						intent = new Intent(getActivity(),RecDetailActivity.class);
//						intent.putExtra("image", listRecInfo.get(p).getRec_image());
//						intent.putExtra("size", listRecInfo.size());
//						startActivity(intent);
//					}
//				});
//				viewHolder.item1Img.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						intent = new Intent(getActivity(),RecDetailActivity.class);
//						intent.putExtra("image", listRecInfo.get(p).getRec_item1());
//						intent.putExtra("size", listRecInfo.size());
//						startActivity(intent);
//					}
//				});
//				viewHolder.item2Img.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						intent = new Intent(getActivity(),RecDetailActivity.class);
//						intent.putExtra("image", listRecInfo.get(p).getRec_item2());
//						intent.putExtra("size", listRecInfo.size());
//						startActivity(intent);
//					}
//				});
				return view;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		class ViewHolder{
			ImageView modelImg;
			ImageView item1Img;
			ImageView item2Img;
		}
			
	} 

}
