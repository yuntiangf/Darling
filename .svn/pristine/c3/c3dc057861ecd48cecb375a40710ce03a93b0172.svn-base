package com.darling.ui;


import java.util.ArrayList;
import java.util.List;

import com.darling.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstItemDetailMatchFrag extends Fragment {
    private TextView txtZR;
    private TextView txtZX;
    private TextView txtJL;

	private TextView txtShow;	
	private List<TextView> lstView;
	
	//按钮颜色
	private int colorSelected=Color.rgb(255, 0, 0);
	private int colorNormal=Color.rgb(102,102,102);	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view= View.inflate(getActivity(), R.layout.first_item_detail_match, null);
		initTxtView(view);
		return view;
	}
	
	public void initTxtView(View view){
		lstView=new ArrayList<TextView>();
		txtZR=(TextView) view.findViewById(R.id.txtZR);
		txtZX=(TextView) view.findViewById(R.id.txtZX);
		txtJL=(TextView) view.findViewById(R.id.txtJL);
		lstView.add(txtZR);
		lstView.add(txtZX);
		lstView.add(txtJL);
		
		txtShow=(TextView) view.findViewById(R.id.match_value);
		txtZR.setOnClickListener(new txtClickListener(0));
		txtZX.setOnClickListener(new txtClickListener(1));
		txtJL.setOnClickListener(new txtClickListener(2));
	}
	
	public class txtClickListener implements View.OnClickListener{
		private int index=0;
		
		public txtClickListener(int n){
			index=n;
		}
		@Override
		public void onClick(View v) {
			resetColor(index);
			switch(index){
			case 0:
				txtShow.setText("搭配按最热排序");
				break;
			case 1:
				txtShow.setText("搭配按最新排序");
				break;
			case 2:
				txtShow.setText("搭配按距离排序");
				break;
			default:
				break;
			}
		}		
	}
	/**
	 * 背景颜色设置
	 * @author:MushRoom
	 * @date:2015-12-12 下午4:17:57
	 * @param selected 选中按钮
	 */
	public void resetColor(int selected){
		for(int i=0;i<lstView.size();i++){
			TextView txt=lstView.get(i);
			if(i==selected) {
				txt.setTextColor(colorSelected);
			}
			else{
				txt.setTextColor(colorNormal);
			}
		}
	}
}
