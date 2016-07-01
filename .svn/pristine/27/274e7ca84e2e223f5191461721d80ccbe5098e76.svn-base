package com.darling.ui;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.activity.Recommend;
import com.darling.model.FashionInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class FashionFragment extends Fragment {

	private List<FashionInfo> listFashionInfo = new ArrayList<FashionInfo>();
	
	private ListView listView;

	public FashionFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.find_fashion_tab, null);
		listView = (ListView) view.findViewById(R.id.find_fashion_list);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		initData();

		FashionAdapter fashionAdapter = new FashionAdapter(getActivity());
		listView.setAdapter(fashionAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Toast.makeText(getActivity(), "潮品···", Toast.LENGTH_SHORT).show();
//				FashionInfo fashion = listFashionInfo.get(position);

				 Intent intent = new Intent(getActivity(),Recommend.class);
				 startActivity(intent);
			}
		});
	}

	private void initData() {
		int[] clothesImg = { R.drawable.fashion_tu1,R.drawable.fashion_tu2,
				R.drawable.fashion_tu3,R.drawable.fashion_tu4,R.drawable.fashion_tu5,
				R.drawable.fashion_tu6};
		if(listFashionInfo.size() == 0){
			for (int i = 0; i < clothesImg.length; i++) {
				FashionInfo fashionInfo = new FashionInfo(clothesImg[i]);
				listFashionInfo.add(fashionInfo);
			}
		}
		
	}
	
	public class FashionAdapter extends BaseAdapter{
		private Context context;
		
		public FashionAdapter(Context context){
			this.context = context;
		}
		@Override
		public int getCount() {
			return listFashionInfo.size();
		}

		@Override
		public Object getItem(int position) {
			return listFashionInfo.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			FashionInfo fashionInfo = listFashionInfo.get(position);
			View view;
			ViewHolder viewHolder;
			try {
				if(convertView == null){
					
					LayoutInflater inflater=LayoutInflater.from(context);				
					view=inflater.inflate(R.layout.find_fashion_item, null);
					viewHolder=new ViewHolder();
					viewHolder.clothesImg = (ImageView) view.findViewById(R.id.find_fashion_clothes_image);
					
					view.setTag(viewHolder);
				}else{
					view=convertView;
					viewHolder=(ViewHolder) view.getTag();
				}
				viewHolder.clothesImg .setImageResource(fashionInfo.getFashion_image());
				
				return view;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		class ViewHolder{
			ImageView clothesImg;
		}
	}

}
