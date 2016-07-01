package com.darling.ui;


import com.darling.R;
import com.darling.util.UserInfoUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThreeMFragment_item extends Fragment {

	private int nHat = 0;
	private int nScarf = 0;
	private int nUpper = 0;
	private int nBag = 0;
	private int nSkirt = 0;
	private int nTrousers = 0;
	private int nShoes = 0;
	private int nBelt = 0;
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		view =inflater.inflate(R.layout.three_minutes_tab_item, container, false);
		initValue();
		return  view;
	}
	
	/**
	 * 初始化值
	 */
	private synchronized void initValue() {
		
		final TextView viewHat = (TextView) view.findViewById(R.id.count_hat);
		final TextView viewScarf = (TextView) view.findViewById(R.id.count_scarf);
		final TextView viewUpper = (TextView) view.findViewById(R.id.count_upper);
		final TextView viewBag = (TextView) view.findViewById(R.id.count_bag);
		final TextView viewSkirt = (TextView) view.findViewById(R.id.count_skirt);
		final TextView viewTrousers = (TextView) view.findViewById(R.id.count_trousers);
		final TextView viewShoes = (TextView) view.findViewById(R.id.count_shoes);
		final TextView viewBelt = (TextView) view.findViewById(R.id.count_belt);
		
		final UserInfoUtil util = new UserInfoUtil(1);
		new Thread() {
			@Override
			public void run() {
				nHat = util.getCountByType("hat");
				nScarf = util.getCountByType("scarf");
				nUpper = util.getCountByType("upper");
				nBag = util.getCountByType("bag");
				nSkirt = util.getCountByType("skirt");
				nTrousers = util.getCountByType("trouser");
				nShoes = util.getCountByType("shoe");
				nBelt = util.getCountByType("waist");
								
				viewHat.post(new Runnable(){
					public void run(){
						viewHat.setText(String.valueOf(nHat));
					}
				});
				viewScarf.post(new Runnable(){

					@Override
					public void run() {
						viewScarf.setText(String.valueOf(nScarf));						
					}
					
				});
				viewUpper.post(new Runnable(){
					public void run(){
						viewUpper.setText(String.valueOf(nUpper));
					}
				});
				viewBag.post(new Runnable(){
					public void run(){
						viewBag.setText(String.valueOf(nBag));
					}
				});
				viewSkirt.post(new Runnable(){
					public void run(){
						viewSkirt.setText(String.valueOf(nSkirt));
					}
				});
				viewTrousers.post(new Runnable(){
					public void run(){
						viewTrousers.setText(String.valueOf(nTrousers));
					}
				});
				viewShoes.post(new Runnable(){
					public void run(){
						viewShoes.setText(String.valueOf(nShoes));
					}
				});
				viewBelt.post(new Runnable(){
					public void run(){
						viewBelt.setText(String.valueOf(nBelt));
					}
				});			
				
			}
		}.start();

	}

}
