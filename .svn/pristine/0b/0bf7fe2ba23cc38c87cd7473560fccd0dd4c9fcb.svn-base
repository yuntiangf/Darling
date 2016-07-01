package com.darling.ui;

import com.darling.R;
import com.darling.widget.DragLayout;
import com.darling.widget.DragLayout.ShowNextPageNotifier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

	private FirstFragment01 fragment1;
	private FirstFragment02 fragment2;
	private DragLayout draglayout;

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.fragment_first, container,false);
		fragment1=new FirstFragment01();
		fragment2=new FirstFragment02();
		
		this.getActivity().getSupportFragmentManager().beginTransaction()
			.add(R.id.first_draglayout01, fragment1)
			.add(R.id.first_draglayout02, fragment2)
			.commit();
		
		ShowNextPageNotifier nextIntf=new ShowNextPageNotifier(){

			@Override
			public void onDragNext() {
								
			}
		};
		
		draglayout=(DragLayout) view.findViewById(R.id.first_draglayout);
		draglayout.setNextPageListener(nextIntf);
		
		return view;
	}
}
