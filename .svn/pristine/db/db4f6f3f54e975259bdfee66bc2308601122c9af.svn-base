package com.darling.widget;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.PictureCallback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;
import android.widget.Toast;

/**
 * 调用系统自带相机类
 * @author:MushRoom
 * @date:2015-12-26 下午4:09:37
 */
public class PreviewView extends SurfaceView implements Callback {

	private static final String LOGTAG = "Camera_Preview";
	private Object mLock = new Object();
	private SurfaceHolder mSurfaceHolder;
	private Camera mCamera;
	private boolean mPreviewRunning;
	private boolean mHasTaken;
	private int[] mSupportHeight;
	private int bestHeight;
	private Map<Integer, Integer> mSupportSize = new HashMap<Integer, Integer>();
	// 当前摄像头设备ID
	private int defaultCameraId;
	// 摄像头个数
	private int numberOfCameras;
	// 全局变量保存当前使用的是前置摄像头还是后置摄像头
	private int cameraState = 0;

	public PreviewView(Context context) {
		super(context);
		init();
	}

	public PreviewView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PreviewView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		// 获得SurfaceHolder对象
		mSurfaceHolder = getHolder();
		// 指定用于捕捉拍照事件的SurfaceHolder.Callback对象
		mSurfaceHolder.addCallback(this);
		// 设置SurfaceHolder对象的类型
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.i(LOGTAG, "surfaceCreated()...");
		int version = getSDKVersionNumber();
		if (version > 8) {
			numberOfCameras = this.getNumberOfCameras();
			// Find the ID of the default camera
			CameraInfo cameraInfo = new CameraInfo();
			for (int i = 0; i < numberOfCameras; i++) {
				Camera.getCameraInfo(i, cameraInfo);
				if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
					defaultCameraId = i;
					cameraState = i;//此时保存后置摄像头的状态位
				}
			}
		}
		openCamera();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i(LOGTAG, "surfaceChanged()...");
		startCamera();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i(LOGTAG, "surfaceDestroyed()...");
		releaseCamera();
	}

	private void openCamera() {
		Log.i(LOGTAG, "openCamera()...");
		synchronized (mLock) {
			try {
				mCamera = Camera.open();
			} catch (Exception e) {
				Toast t = Toast.makeText(getContext().getApplicationContext(),
						"连接摄像头失败！\r\n请检查是否在其他地方打开了摄像头。\r\n然后返回重新拍照。",
						Toast.LENGTH_LONG);
				t.setGravity(Gravity.CENTER, 0, 0);
				t.show();
				mCamera = null;
			}
		}
	}

	private void releaseCamera() {
		Log.i(LOGTAG, "releaseCamera()...");
		synchronized (mLock) {
			try {
				if (null != mCamera) {
					if (mPreviewRunning) {
						mCamera.stopPreview();
						mPreviewRunning = false;
					}
					mCamera.release();
					mCamera = null;
				}
			} catch (Exception e) {
				Log.e(LOGTAG, "releaseCamera()...", e);
			}
		}
	}

	private void startCamera() {
		Log.i(LOGTAG, "startCamera()...");
		synchronized (mLock) {
			try {
				if (null == mCamera)
					return;
				if (mPreviewRunning)
					mCamera.stopPreview();
				
				setCamera(mCamera);
				
				// 开始拍照
				mCamera.startPreview();
				mPreviewRunning = true;
			} catch (Exception e) {
				Log.e(LOGTAG, "startCamera()...", e);
				releaseCamera();
			}
		}
	}
	
	// 设置参数加异常处理
	private void setCamera(Camera camera) {
		mCamera = camera;
		if (mCamera != null) {
			Camera.Parameters parameters = null;

			// 设置照片格式
			try {
				parameters = mCamera.getParameters();
				parameters.setPictureFormat(PixelFormat.JPEG);
				mCamera.setParameters(parameters);
				// 设置用于显示拍照影像的SurfaceHolder对象
				try {
					mCamera.setPreviewDisplay(mSurfaceHolder);
				} catch (Exception e) {
					Log.e(LOGTAG, "startCamera()...setPreviewDisplay...", e);
				}

				// 设置用于显示拍照影像的异常处理
				try {
					mCamera.setErrorCallback(new ErrorCallback() {
						@Override
						public void onError(int error, Camera camera) {
							Log.e(LOGTAG, "onError()..." + error);
							releaseCamera();
							Toast t = Toast.makeText(getContext().getApplicationContext(), "拍照时错误:"
									+ error, Toast.LENGTH_SHORT);
							t.setGravity(Gravity.CENTER, 0, 0);
							t.show();
						}
					});
				} catch (Exception e) {
					Log.e(LOGTAG, "startCamera()...setErrorCallback...", e);
				}
			} catch (Exception e) {
				Log.e(LOGTAG, "startCamera()...setPictureFormat...", e);
			}
		}
	}

	@SuppressWarnings("unused")
	private void getSupportPictureSize(Camera.Parameters parameters) {
		// 取得相机所支持多少图片大小的个数
		if (mSupportHeight != null)
			return;
		List<Camera.Size> pszize = parameters.getSupportedPictureSizes();
		if (null != pszize && 0 < pszize.size()) {
			mSupportHeight = new int[pszize.size()]; // 声明一个数组
			mSupportSize = new HashMap<Integer, Integer>();
			for (int i = 0; i < pszize.size(); i++) {
				Camera.Size size = pszize.get(i);
				int sizeheight = size.height;
				int sizewidth = size.width;
				mSupportHeight[i] = sizeheight;
				mSupportSize.put(sizeheight, sizewidth);

			}
			Arrays.sort(mSupportHeight);
			bestHeight = mSupportHeight[0];
			for (int i = 1; i < mSupportHeight.length; i++) {
				if (bestHeight >= 600 || mSupportHeight[i] >= 800)
					break;
				bestHeight = mSupportHeight[i];
			}
		}
	}

	public void autoFocus(AutoFocusCallback autoFocusCallback) {
		Log.i(LOGTAG, "autoFocus()...");
		synchronized (mLock) {
			try {
				if (null != mCamera) {
					mCamera.autoFocus(autoFocusCallback);
				}
			} catch (Exception e) {
				Log.e(LOGTAG, "autoFocus()...", e);
			}
		}
	}

	public void takePicture(PictureCallback pictureCallback) {
		Log.i(LOGTAG, "takePicture()...");
		synchronized (mLock) {
			try {
				if (null != mCamera && !mHasTaken) {
					mHasTaken = true;
					mCamera.takePicture(null, null, pictureCallback);
				}
			} catch (Exception e) {
				Log.e(LOGTAG, "takePicture()...", e);
			}
		}
	}
	
	// 切换前后摄像头
	public void switchCamera() {
		Log.e("switchCamera=", "in switch: " + Thread.currentThread().getId());
		if (mCamera != null) {
			mCamera.stopPreview();
			mCamera.release();
			mCamera = null;
		}
		mCamera = Camera.open((defaultCameraId + 1) % numberOfCameras);
		defaultCameraId = (defaultCameraId + 1) % numberOfCameras;
		setCamera(mCamera);
		requestLayout();
		mPreviewRunning = true;
		mCamera.startPreview();
	}
	
	// 返回摄像头个数
	public int getNumberOfCameras() {
		int version = getSDKVersionNumber();
		if (version > 8)
			return Camera.getNumberOfCameras();
		else 
			return 1;
	}
	
	// 获取当前手机端SDK版本号
	public int getSDKVersionNumber() {
		int sdkVersion;
		try {
			sdkVersion = Integer.valueOf(android.os.Build.VERSION.SDK);
		} catch (NumberFormatException e) {
			sdkVersion = 0;
		}
		return sdkVersion;
	}
	
	//返回摄像头状态为前置或者后置
	public String getCameraState() {
		if (defaultCameraId == cameraState)
			return "back";
		else
			return "front";
	}
}
