package com.darling.ui;

import java.util.ArrayList;
import java.util.List;

import com.darling.R;
import com.darling.activity.Recommend;
import com.darling.model.CategoryInfo;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class CategoryFragment extends Fragment {
	
	private List<CategoryInfo> listCategoryInfo = new ArrayList<CategoryInfo>();
	public CategoryFragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){
		
		initData();
		
		View view=inflater.inflate(R.layout.find_category_tab, container,false);
		LinearLayout layout=new LinearLayout(view.getContext());  
		ListView listView = (ListView) view.findViewById(R.id.find_category_list);
		
		CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity());
		listView.setAdapter(categoryAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Toast.makeText(getActivity(), "品类···", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(),Recommend.class);
				startActivity(intent);
			}
		});
		
		return view;
	}

	private void initData() {
		int[] categoryImg = {R.drawable.category_tu1,R.drawable.category_tu2,
				R.drawable.category_tu3,R.drawable.category_tu4,R.drawable.category_tu5,
				R.drawable.category_tu6,R.drawable.category_tu7,R.drawable.category_tu8,};
		
		if(listCategoryInfo.size() == 0){
			for (int i = 0; i < categoryImg.length; i++) {
				CategoryInfo categoryInfo = new CategoryInfo(categoryImg[i]);
				listCategoryInfo.add(categoryInfo);
			}
		}
		
	}
	
	public class CategoryAdapter extends BaseAdapter{
		private Context context;
		
		private CategoryAdapter(Context context){
			this.context = context;
		}
		@Override
		public int getCount() {
			return listCategoryInfo.size();
		}

		@Override
		public Object getItem(int position) {
			return listCategoryInfo.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			CategoryInfo categoryInfo = listCategoryInfo.get(position);
			View view;
			ViewHolder viewHolder;
			try {
				if(convertView == null){		
					LayoutInflater inflater=LayoutInflater.from(context);				
					view=inflater.inflate(R.layout.find_category_item, null);
					viewHolder=new ViewHolder();
					viewHolder.categoryImg = (ImageView) view.findViewById(R.id.find_fashion_category_image);
					
					view.setTag(viewHolder);
				}else{
					view=convertView;
					viewHolder=(ViewHolder) view.getTag();
				}
				viewHolder.categoryImg .setImageResource(categoryInfo.getCategory_image());
				
				return view;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		class ViewHolder{
			ImageView categoryImg;
		}
		
	}

}
