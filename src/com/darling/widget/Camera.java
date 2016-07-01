package com.darling.widget;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.darling.util.BitmapUtil;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义拍照
 * @author:MushRoom
 * @date:2015-12-24 下午9:10:04
 */
public class Camera extends Activity {

	private static final String LOGTAG = "mushroom";
	private static final String MAX_CAMERA_SIZE = "MAX_CAMERA_SIZE";
//	private static final int MAX_CAMERA_SIZE1 = 448 * 1024; // KB
//	private static final int MAX_CAMERA_SIZE2 = 384 * 1024; // KB
//	private static final int MAX_CAMERA_SIZE3 = 320 * 1024; // KB
	private static final int MAX_CAMERA_SIZE1 = 5 * 1024 * 1024; // MB
	private static final int MAX_CAMERA_SIZE2 = 4 * 1024 * 1024; // MB
	private static final int MAX_CAMERA_SIZE3 = 3 * 1024 * 1024; // MB
	private static final String SHARED_PREFERENCES_NAME = "dog_camera";
	private static final String CAMERA_BUTTON_IMAGE = "CAMERA_BUTTON_IMAGE";
	private static final String SWITCH_BUTTON_IMAGE = "SWITCH_BUTTON_IMAGE";
	private static final String CLOTHES_TYPE="clothes_type";

	/**
	 * intent filter name.
	 */
	public static final String ACTION_CAPTURE = "com.darling.activity.CameraActivity";

	/**
	 * output data to file.
	 */
	public static final String EXTRA_OUTPUT_FILE = "extra_output_file";
	public static final String EXTRA_AUTO_ADJUST_DIRECTION = "EXTRA_AUTO_ADJUST_DIRECTION";

	private Camera context;
	private SharedPreferences sharedPrefs;
	private PreviewView cameraView;
	private TextView focusView;
	private ImageButton cameraButton;
	private ImageButton switchButton;
	private ClothesTypeVertical clothesType;
	// 重力感应
	private SensorManager sensorMgr;
	private Sensor sensor;
	@SuppressWarnings("unused")
	private int x, y, z;
	private int cameraAngle;

	@Override
	protected void onDestroy() {
		cameraButton = null;
		focusView = null;
		cameraView = null;
		sensorMgr = null;
		sensor = null;
		sharedPrefs = null;
		context = null;		
		clothesType=null;
		super.onDestroy();
	}

	private void initSensor() {
		try {
			sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
			SensorEventListener lsn = new SensorEventListener() {
				@Override
				public void onSensorChanged(SensorEvent e) {
					x = (int) e.values[SensorManager.DATA_X];
					y = (int) e.values[SensorManager.DATA_Y];
					z = (int) e.values[SensorManager.DATA_Z];
				}

				@Override
				public void onAccuracyChanged(Sensor s, int accuracy) {
				}
			};
			sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			// 注册listener，第三个参数是检测的精确度
			sensorMgr.registerListener(lsn, sensor,
					SensorManager.SENSOR_DELAY_NORMAL);
		} catch (Exception e) {
		}
	}

	private void calcSensor() {
		if (y <= -6) {
			cameraAngle = 4;
		} else if (x <= -6) {
			cameraAngle = 3;
		} else if (x >= 5) {
			cameraAngle = 1;
		} else {
			cameraAngle = 2;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			Log.i(LOGTAG, "onCreate()...");

			context = this;
			sharedPrefs = getSharedPreferences(SHARED_PREFERENCES_NAME,
					Context.MODE_PRIVATE);

			getWindow()
					.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // 不锁屏
			getWindow().setFormat(PixelFormat.TRANSLUCENT); // 半透明
			requestWindowFeature(Window.FEATURE_NO_TITLE); // 夫标题
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 使预览正常成像
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN); // 全屏
			
			setContentView(createContentView());

			initSensor();
			initView();
		} catch (Exception e) {
			Log.e(LOGTAG, "onCreate()...", e);
		}
	}

	private View createContentView() {
		Log.i(LOGTAG, "createContentView()...");
		RelativeLayout frame = new RelativeLayout(context);
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		frame.setLayoutParams(params1);
		frame.setGravity(Gravity.CENTER);
		// Preview
		cameraView = new PreviewView(context);
		RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		cameraView.setLayoutParams(params2);
		// Focus
		focusView = new TextView(context);
		RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params3.addRule(RelativeLayout.CENTER_IN_PARENT);
		focusView.setLayoutParams(params3);
		focusView.setTextSize(20);
		focusView.setText("+");
		focusView.setGravity(Gravity.CENTER);
		// cameraButton
		cameraButton = new ImageButton(context);
		RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params4.addRule(RelativeLayout.CENTER_VERTICAL);
		params4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		cameraButton.setLayoutParams(params4);
		cameraButton.setBackgroundColor(0x00000000);
		cameraButton.setScaleType(ScaleType.CENTER_INSIDE);
		cameraButton.setRotation(-90);		
		int resId = sharedPrefs.getInt(CAMERA_BUTTON_IMAGE, 0);
		if (0 != resId)
			cameraButton.setImageResource(resId);
		// switchButton
		switchButton = new ImageButton(context);
		RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT, 
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params5.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		params5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		switchButton.setLayoutParams(params5);
		switchButton.setBackgroundColor(0x00000000);
		switchButton.setScaleType(ScaleType.CENTER_INSIDE);
		switchButton.setRotation(-90);
		int resSwitchId = sharedPrefs.getInt(SWITCH_BUTTON_IMAGE, 0);
		if (0 != resSwitchId)
			switchButton.setImageResource(resSwitchId);
		
		// 类型选择器clothestype radiogroup
		String type=sharedPrefs.getString(CLOTHES_TYPE, "");
		clothesType=new ClothesTypeVertical(context,type);
		RelativeLayout.LayoutParams params6=new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params6.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params6.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//		params6.leftMargin=5;
		params6.bottomMargin=-420;
		clothesType.setBackgroundColor(0x00000000);		
		clothesType.setRotation(-90);		
		clothesType.setLayoutParams(params6);
		
		//here 为什么摄像头是横着的
		// add...
		frame.addView(cameraView);
		frame.addView(focusView);
		frame.addView(cameraButton);
		frame.addView(clothesType);
		if (cameraView.getNumberOfCameras() > 1)
			frame.addView(switchButton);
		// ......
		return frame;
	}

	/**
	 * 设置拍照按钮的图片。<br/>
	 * 
	 * @param context
	 * @param resId
	 */
	public static void setCameraButtonImage(Context context, int resId) {
		Editor editor = context.getSharedPreferences(SHARED_PREFERENCES_NAME,
				Context.MODE_PRIVATE).edit();
		editor.putInt(CAMERA_BUTTON_IMAGE, resId);
		editor.commit();
	}
	
	/**
	 * 设置切换按钮的图片。<br/>
	 * 
	 * @param context
	 * @param resId
	 */
	public static void setSwitchButtonImage(Context context, int resId) {
		Editor editor = context.getSharedPreferences(SHARED_PREFERENCES_NAME,
				Context.MODE_PRIVATE).edit();
		editor.putInt(SWITCH_BUTTON_IMAGE, resId);
		editor.commit();
	}	
	
	/**
	 * 初始化服装类型
	 * @author:MushRoom
	 * @date:2015-12-24 下午11:23:51
	 */
	public static void setClothesType(Context context,String clothesType){
		Editor editor = context.getSharedPreferences(SHARED_PREFERENCES_NAME,
				Context.MODE_PRIVATE).edit();
		editor.putString(CLOTHES_TYPE, clothesType);
		editor.commit();
	}

	
	/**
	 * 读取拍照的数据。<br/>
	 * 
	 * @param context
	 * @return
	 */
	public static byte[] getCamera(Context context) {
		byte[] data = CameraCache.getCamera(context);
		@SuppressWarnings("unused")
		boolean state = CameraCache.clearCamera(context);
		if (null == data) {
			// 如果是因照片太大无法读取，则修改最大图片数据大小限制。
			SharedPreferences sp = context.getSharedPreferences(
					SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
			int maxCameraSize = sp.getInt(MAX_CAMERA_SIZE, MAX_CAMERA_SIZE1);
			if (MAX_CAMERA_SIZE1 == maxCameraSize) {
				Editor editor = sp.edit();
				editor.putInt(MAX_CAMERA_SIZE, MAX_CAMERA_SIZE2);
				editor.commit();
			} else if (MAX_CAMERA_SIZE2 == maxCameraSize) {
				Editor editor = sp.edit();
				editor.putInt(MAX_CAMERA_SIZE, MAX_CAMERA_SIZE3);
				editor.commit();
			} else {
				// 不继续减小了
			}

			String filename = Environment.getExternalStorageDirectory()
					.getPath() + "/mycamera.jpg";
			File cameraFile = new File(filename);
			if (cameraFile.exists()) {
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(cameraFile);
					int length = fis.available();
					byte[] buf = new byte[length];
					fis.read(buf);
					data = buf;
				} catch (IOException e) {
					Log.e(LOGTAG, "getCamera()...", e);
				} finally {
					if (null != fis) {
						try {
							fis.close();
						} catch (IOException e) {
							Log.e(LOGTAG, "getCamera()...", e);
						}
						fis = null;
					}
				}
			}
		}
		return data;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.i(LOGTAG, "onKeyDown()...");
		try {
			switch (keyCode) {
			case KeyEvent.KEYCODE_BACK: // 返回键
				Log.v(LOGTAG, "KeyEvent.KEYCODE_BACK");
				cancelCamera();
				return true;
			case KeyEvent.KEYCODE_CAMERA: // 拍照键
				Log.v(LOGTAG, "KeyEvent.KEYCODE_CAMERA");
			case KeyEvent.KEYCODE_DPAD_CENTER: // 中间确认键
				takePicture();
				return true;
			default:
				break;
			}
		} catch (Exception e) {
			Log.e(LOGTAG, "onKeyDown()...", e);
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		try {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				autoFocus();
			}
		} catch (Exception e) {
			Log.e(LOGTAG, "onTouchEvent()...", e);
		}
		return super.onTouchEvent(event);
	}

	private void initView() {
		cameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				takePicture();
			}
		});
		switchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switchCamera();
			}
		});
	}

	// 创建一个PictureCallback对象，并实现其中的onPictureTaken方法
	private PictureCallback pictureCallback = new PictureCallback() {
		// 该方法用于处理拍摄后的照片数据
		@Override
		public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
			savePicture(data);
		}
	};

	private void savePicture(byte[] data) {
		try {
			Log.i(LOGTAG, "data size: " + (data.length / 1024) + "KB");
			calcSensor(); // 计算方向
			
			// 用于前置摄像头的方向判断
			int r = cameraAngle;

			boolean adjust = getIntent().getBooleanExtra(
					EXTRA_AUTO_ADJUST_DIRECTION, false);

			Bitmap bmpOld = null;
			Bitmap bmpNew = null;

			int maxCameraSize = sharedPrefs.getInt(MAX_CAMERA_SIZE,
					MAX_CAMERA_SIZE1);
			// 如果图片数据太大，则进行图片大小的转换
			// 如果图片方向校准，则进行图片方向的校准
			if (data.length > maxCameraSize) {
				bmpOld = BitmapFactory.decodeByteArray(data, 0, data.length);
				// 修改照片大小
				bmpNew = BitmapUtil.resizeBitmapAndRecycleRawBitmap(bmpOld);
				if (adjust) {
					bmpNew = BitmapUtil.adjustDirectionAndRecycleRawBitmap(
							bmpNew, cameraAngle);
					cameraAngle = 1;
				}
			} else if (adjust) {
				bmpOld = BitmapFactory.decodeByteArray(data, 0, data.length);
				bmpNew = BitmapUtil.adjustDirectionAndRecycleRawBitmap(bmpOld,
						cameraAngle);
				cameraAngle = 1;
			}
			// 如果为前置摄像头的话做180度旋转调整
			if ("front".equals(cameraView.getCameraState()) && r%2 == 0) {
				if (null != bmpNew) {
					bmpNew = BitmapUtil.adjustDirectionAndRecycleRawBitmap(bmpNew, 3);
				} else {
					bmpOld = BitmapFactory.decodeByteArray(data, 0, data.length);
					bmpNew = BitmapUtil.adjustDirectionAndRecycleRawBitmap(bmpOld, 3);
				}
			}
			// 重新生成数据
			if (null != bmpNew) {
				if (bmpNew != bmpOld)
					data = BitmapUtil
							.compressBitmap(bmpNew, maxCameraSize, 100);
				if (!bmpNew.isRecycled()) {
					bmpNew.recycle();
				}
				bmpOld = null;
				bmpNew = null;
			}
			
			getIntent().putExtra("angle", cameraAngle);
			
			//mushroom 将当前的衣服类型传递回去
			String strType=clothesType.getClothesType();
			getIntent().putExtra("clothesType", strType);

			Log.i(LOGTAG, "data size: " + (data.length / 1024) + "KB");

			// 将照片保存在文件中
			String filename = getIntent().getStringExtra(EXTRA_OUTPUT_FILE);
			if (null != filename) {
				outputDataToFile(filename, data);
			}
			
			// photo data save to camera table
			if (CameraCache.putCamera(context, data)) {
				setResult(Activity.RESULT_OK, getIntent());
			} else if (outputDataToFile(Environment
					.getExternalStorageDirectory().getPath() + "/mycamera.jpg",
					data)) {
				setResult(Activity.RESULT_OK, getIntent());
			} else {
				setResult(Activity.RESULT_CANCELED);
			}
		} catch (Exception e) {
			Log.e(LOGTAG, "savePicture()...", e);
			setResult(Activity.RESULT_CANCELED);
		} finally {
			// 关闭当前的Activity
			finish();
		}
	}

	private boolean outputDataToFile(String filename, byte[] data) {
		// 将照片保存在文件中
		BufferedOutputStream bos = null;
		try {
			if (null != filename) {
				File cameraFile = new File(filename);
				bos = new BufferedOutputStream(new FileOutputStream(cameraFile));
				bos.write(data);
				bos.flush();
				return true;
			}
		} catch (Exception e) {
			Log.e(LOGTAG, "outputDataToFile()...", e);
		} finally {
			if (null != bos) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	private void autoFocus() {
		if (null != focusView)
			focusView.setVisibility(View.VISIBLE);
		if (null != cameraView)
			cameraView.autoFocus(new AutoFocusCallback() {
				@Override
				public void onAutoFocus(boolean success,
						android.hardware.Camera camera) {
					if (success && null != focusView) {
						focusView.setVisibility(View.INVISIBLE);
					}
				}
			});
	}

	// 停止拍照，并将拍摄的照片传入PictureCallback接口的onPictureTaken方法
	private void takePicture() {
		Log.d(LOGTAG, "takePicture()...");
		if (null != cameraView)
			cameraView.takePicture(pictureCallback);
	}
	
	// 切换前后摄像头
	private void switchCamera() {
		Log.d(LOGTAG, "takePicture()...");
		if (null != cameraView)
			cameraView.switchCamera();
	}

	// 取消拍照
	private void cancelCamera() {
		Log.d(LOGTAG, "cancelCamera()...");
		setResult(Activity.RESULT_CANCELED, getIntent());
		finish();
	}
	
}