package com.darling.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

/**
 * @author:hj
 * @date:2015-12-26 下午8:50:44
 */
@SuppressWarnings("deprecation")
public class GalleryView extends Gallery {

	public GalleryView(Context context) {
		super(context);
	}

	public GalleryView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public GalleryView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	private static final int timerAnimation = 1;
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case timerAnimation:
				int position = getSelectedItemPosition();
				Log.i("msg", "position:" + position);
				if (position >= (getCount() - 1)) {
					onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null);
				} else {
					onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
				}
				break;

			default:
				break;
			}
		};
	};

	private boolean isScrollingLeft(MotionEvent paramMotionEvent1,
			MotionEvent paramMotionEvent2) {
		float f2 = paramMotionEvent2.getX();
		float f1 = paramMotionEvent1.getX();
		if (f2 > f1)
			return true;
		
		return false;
	}

	@Override
	public boolean onFling(MotionEvent paramMotionEvent1,
			MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
		int keyCode;
		if (isScrollingLeft(paramMotionEvent1, paramMotionEvent2)) {
			keyCode = KeyEvent.KEYCODE_DPAD_LEFT;
		} else {
			keyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
		}
		onKeyDown(keyCode, null);
		return true;
	}

}
