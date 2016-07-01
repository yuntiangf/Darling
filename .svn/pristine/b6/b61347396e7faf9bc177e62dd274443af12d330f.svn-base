package com.darling.ui;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import com.darling.R;
import com.darling.activity.ItemListActivity;
import com.darling.util.UserInfoUtil;
import com.darling.widget.Camera;
import com.darling.widget.CustomDialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdFragment extends Fragment {

	private int nAll = 0;
	private int nHat = 0;
	private int nScarf = 0;
	private int nUpper = 0;
	private int nBag = 0;
	private int nSkirt = 0;
	private int nTrousers = 0;
	private int nShoes = 0;
	private int nBelt = 0;
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public static final int CAMERA_WITH_DATA = 3023;
	private boolean autoRecycle = true;
	private Bitmap bmpCurr = null;
	private ImageView imgResult; // 返回的图片
	private String clothesType; // 服饰类型
	private View view;

	public ThirdFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_third, container, false);
		map.clear();
		map.put("帽子", R.id.count_hat);
		map.put("围巾", R.id.count_scarf);
		map.put("上衣", R.id.count_upper);
		map.put("包包", R.id.count_bag);
		map.put("裙装", R.id.count_skirt);
		map.put("裤装", R.id.count_trousers);
		map.put("鞋子", R.id.count_shoes);
		map.put("腰带", R.id.count_belt);

		// imgResult=(ImageView) view.findViewById(R.id.img_result);
		initValue();

		initCameraEvent();
		initBtnEvent();

		return view;
	}

	/**
	 * 初始化值
	 * 
	 * @author:MushRoom
	 * @date:2015-12-20 下午12:58:41
	 * @param view
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
		final TextView viewAll = (TextView) view.findViewById(R.id.count_all);
		
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
				
				nAll = nHat + nScarf + nUpper + nBag + nSkirt + nTrousers + nBelt
						+ nShoes;
				
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
				
				viewAll.post(new Runnable(){
					public void run(){
						viewAll.setText(String.valueOf(nAll));
					}
				});
			}
		}.start();

	}

	/**
	 * 初始化事件
	 * 
	 * @author:MushRoom
	 * @date:2015-12-20 下午12:59:13
	 * @param view
	 */
	private void initCameraEvent() {
		Camera.setCameraButtonImage(getActivity(), R.drawable.camera_button);
		Camera.setSwitchButtonImage(getActivity(), R.drawable.switch_button);

		ImageView camera = (ImageView) view.findViewById(R.id.camera);
		camera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 默认为帽子
				Camera.setClothesType(getActivity(), "帽子");
				clothesType = "帽子";

				CustomDialog.Builder builder = new CustomDialog.Builder(
						getActivity());
				builder.setMessage("建议亲先将所有单品拍照完毕再统一录入，会节省好多时间哦。");
				builder.setTitle("温馨提示");
				builder.setPositiveButton("去拍照",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
								// 调取摄像头

								startCamera();
							}
						});
				builder.setNegativeButton("取  消",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						});
				builder.create().show();
			}

		});
	}

	/**
	 * 初始化按钮事件
	 * 
	 * @author:MushRoom
	 * @date:2015-12-28 下午10:55:18
	 */
	@SuppressWarnings("unchecked")
	private void initBtnEvent() {

		View btn_hat = view.findViewById(R.id.btn_hat);
		btn_hat.setOnClickListener(new CustomClickListener() {

		});

		View btn_scarf = view.findViewById(R.id.btn_scarf);
		btn_scarf.setOnClickListener(new CustomClickListener() {

		});

		View btn_upper = view.findViewById(R.id.btn_upper);
		btn_upper.setOnClickListener(new CustomClickListener() {

		});

		View btn_bag = view.findViewById(R.id.btn_bag);
		btn_bag.setOnClickListener(new CustomClickListener() {

		});

		View btn_skirt = view.findViewById(R.id.btn_skirt);
		btn_skirt.setOnClickListener(new CustomClickListener() {

		});

		View btn_trousers = view.findViewById(R.id.btn_trousers);
		btn_trousers.setOnClickListener(new CustomClickListener() {

		});

		View btn_shoes = view.findViewById(R.id.btn_shoes);
		btn_shoes.setOnClickListener(new CustomClickListener() {

		});

		View btn_belt = view.findViewById(R.id.btn_belt);
		btn_belt.setOnClickListener(new CustomClickListener() {

		});

		// Iterator<?> it=map.entrySet().iterator();
		// TextView obj;
		// Map.Entry<String, Integer> entry;
		// while(it.hasNext()){
		// entry=(Entry<String, Integer>) it.next();
		// obj=(TextView) view.findViewById(entry.getValue());
		// obj.setOnClickListener(new CustomClickListener(){
		// });
		// }

	}

	public class CustomClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			ViewGroup group = (ViewGroup) v;
			TextView txtType = (TextView) group.getChildAt(0);
			TextView txtCount = (TextView) group.getChildAt(2);
			String type = (String) txtType.getText();
			int count = Integer.parseInt(((String) txtCount.getText()).replace(
					"件", ""));

			clothesType = type;

			Intent i = new Intent(getActivity(), ItemListActivity.class);
			i.putExtra("clothesType", type);
			i.putExtra("count", count);
			startActivity(i);
		}
	}

	/**
	 * 开启摄像机
	 * 
	 * @author:MushRoom
	 * @date:2015-12-26 下午2:43:02
	 */
	public void startCamera() {
		Intent intentCamera = new Intent(getActivity(),
				com.darling.widget.Camera.class);
		// 判断sd卡是否存在
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		if (!sdCardExist) {
			Toast.makeText(getActivity().getApplicationContext(),
					R.string.alert_no_sdcard, Toast.LENGTH_SHORT).show();
		} else {
			File file = new File(Environment.getExternalStorageDirectory()
					+ "/darling/photos/");
			if (!file.exists()) {
				file.mkdirs();
			}
			String filename = Environment.getExternalStorageDirectory()
					+ "/darling/photos/"
					+ String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS",
							Calendar.getInstance()) + ".jpg";
			intentCamera.putExtra(Camera.EXTRA_AUTO_ADJUST_DIRECTION, true);
			intentCamera.putExtra(Camera.EXTRA_OUTPUT_FILE, filename);

		}
		startActivityForResult(intentCamera, CAMERA_WITH_DATA);
	}

	/**
	 * 更新单品数目
	 * 
	 * @author:MushRoom
	 * @date:2015-12-26 下午9:26:59
	 */
	private void updateCount() {
		if (clothesType.isEmpty())
			return;

		// 当前衣物加一件
		addCount(map.get(clothesType));

		// 单品总数加一件
		addCount(R.id.count_all);
	}

	/**
	 * 根据id获取textview控件中的数值,并递增1
	 * 
	 * @author:MushRoom
	 * @date:2015-12-26 下午9:33:04
	 * @param name
	 * @return
	 */
	private void addCount(int id) {
		TextView v = (TextView) view.findViewById(id);
		int n = Integer.parseInt(((String) v.getText()).replace("件", ""));
		String str = (n + 1) + "件";

		v.setText(str);
	}

	/**
	 * 根据id获取textview控件中的数值
	 * 
	 * @author:MushRoom
	 * @date:2015-12-28 下午11:05:24
	 * @param id
	 * @return
	 */
	private int getCount(int id) {
		TextView v = (TextView) view.findViewById(id);
		int n = Integer.parseInt(((String) v.getText()).replace("件", ""));

		return n;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode != CAMERA_WITH_DATA || resultCode != Activity.RESULT_OK)
			return;
		// 取拍照角度
		// int cameraAngle = data.getExtras().getInt("angle");

		// 取拍照数据
		byte[] bytes = Camera.getCamera(getActivity());

		Bitmap cameraBitmap = BitmapFactory.decodeByteArray(bytes, 0,
				bytes.length);

		// 修改照片大小
		// Bitmap bitmapShow = BitmapUtil
		// .resizeBitmapAndRecycleRawBitmap(cameraBitmap);
		// 调整照片方向
		// bitmapShow = BitmapUtil.adjustDirectionAndRecycleRawBitmap(
		// bitmapShow, cameraAngle);

		this.clothesType = data.getStringExtra("clothesType");

		// 回调获取照片
		onTakeCamera(cameraBitmap);
		afterTakeCamera(cameraBitmap);

		// 更新单品数目
		updateCount();

		// 得到Base64编码的图片数据
		// imageStr = BitmapUtil.encodeBitmap_32000(bitmapShow); // 32KB
	}

	protected void onTakeCamera(Bitmap bitmap) {
		// imgResult.setImageBitmap(bitmap);
		Toast t;
		t = Toast.makeText(getActivity().getApplicationContext(), clothesType
				+ "已上传。", 10);
		t.show();
	}

	protected void afterTakeCamera(Bitmap bitmap) {
		if (isAutoRecycle()) {
			recycleBitmap(bmpCurr);
			bmpCurr = bitmap;
		}
	}

	public boolean isAutoRecycle() {
		return autoRecycle;
	}

	public void recycleBitmap(Bitmap bitmap) {
		if (null != bitmap && !bitmap.isRecycled()) {
			bitmap.recycle();
		}
	}

	public String getClothesType() {
		return clothesType;
	}

	public void setClothesType(String clothesType) {
		this.clothesType = clothesType;
	}
}
