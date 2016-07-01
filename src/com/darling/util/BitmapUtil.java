package com.darling.util;

import java.io.ByteArrayOutputStream;

import org.apache.commons.codec.binary.Base64;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * 
 * Bitmap 工具
 * 
 * @author hemj
 * 
 */
public class BitmapUtil {

	public static final int COMPRESSFORMAT_JPG = 0;
	public static final int COMPRESSFORMAT_PNG = 1;

	/**
	 * Base64编码照片。<br/>
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBitmap_32000(Bitmap bitmap) {
		return encodeBitmap(bitmap, 32000);
	}

	/**
	 * Base64编码照片。<br/>
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBitmap_64000(Bitmap bitmap) {
		return encodeBitmap(bitmap, 64000);
	}

	/**
	 * Base64编码照片。<br/>
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBitmap_96000(Bitmap bitmap) {
		return encodeBitmap(bitmap, 96000);
	}

	/**
	 * Base64编码照片。<br/>
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBitmap(Bitmap bitmap, int maxSize) {
		int quality = 60;
		if (maxSize > 128000) {
			quality = 75;
		} else if (maxSize > 96000) {
			quality = 75;
		} else if (maxSize > 64000) {
			quality = 70;
		} else if (maxSize > 32000) {
			quality = 65;
		}
		byte[] bytes = BitmapUtil.compressBitmap(bitmap, maxSize, quality);
		String data = new String(Base64.encodeBase64(bytes));
		return data;
	}

	/**
	 * 压缩照片。<br/>
	 * 
	 * @param bitmap
	 * @return
	 */
	public static byte[] compressBitmap(Bitmap bitmap, int maxSize, int quality) {
		byte[] code = null;
		try {
			do {
				ByteArrayOutputStream dataOut = new ByteArrayOutputStream();
				if (bitmap.compress(Bitmap.CompressFormat.JPEG, quality,
						dataOut)) {
					code = dataOut.toByteArray();
				}
				dataOut.close();
				if (quality < 21)
					break;
				if (code.length < maxSize)
					break;
				quality -= 5;
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * 调整照片大小到（800x600）。<br/>
	 * 
	 * @param bmpRaw
	 * @return
	 */
	public static Bitmap resizeBitmapAndRecycleRawBitmap(Bitmap bmpRaw) {
		int width = bmpRaw.getWidth();
		int height = bmpRaw.getHeight();
		Bitmap bmpNew = bmpRaw;
		if (height > 600) {
			width = width * 600 / height;
			height = (600);
			bmpNew = BitmapUtil.resizeBitmapAndRecycleRawBitmap(bmpRaw, width,
					height);
			// recycle
			if (bmpRaw != bmpNew && !bmpRaw.isRecycled()) {
				bmpRaw.recycle();
				bmpRaw = null;
			}
		}
		return bmpNew;
	}

	/**
	 * 调整照片大小。<br/>
	 * 
	 * @param bmpRaw
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static Bitmap resizeBitmapAndRecycleRawBitmap(Bitmap bmpRaw,
			int newWidth, int newHeight) {
		int width = bmpRaw.getWidth();
		int height = bmpRaw.getHeight();

		newWidth -= newWidth % 10;
		newHeight -= newHeight % 10;

		System.out.println("old-size:" + width + "," + height);
		System.out.println("new-size:" + newWidth + "," + newHeight);

		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// createa matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap
		Bitmap bmpNew = Bitmap.createBitmap(bmpRaw, 0, 0, width, height,
				matrix, true);
		// recycle
		if (bmpRaw != bmpNew && !bmpRaw.isRecycled()) {
			bmpRaw.recycle();
			bmpRaw = null;
		}
		return bmpNew;
	}

	/**
	 * 调整照片方向。<br/>
	 * 
	 * @param bmpRaw
	 * @param cameraAngle
	 * @return
	 */
	public static Bitmap adjustDirectionAndRecycleRawBitmap(Bitmap bmpRaw,
			int cameraAngle) {
		Bitmap bmpNew = bmpRaw;
		Matrix matrix = new Matrix();
		switch (cameraAngle) {
		case 4:
			matrix.setRotate(270);
			bmpNew = Bitmap.createBitmap(bmpRaw, 0, 0, bmpRaw.getWidth(),
					bmpRaw.getHeight(), matrix, true);
			break;
		case 3:
			matrix.setRotate(180);
			bmpNew = Bitmap.createBitmap(bmpRaw, 0, 0, bmpRaw.getWidth(),
					bmpRaw.getHeight(), matrix, true);
			break;
		case 1:
			break;
		default:
			matrix.setRotate(90);
			bmpNew = Bitmap.createBitmap(bmpRaw, 0, 0, bmpRaw.getWidth(),
					bmpRaw.getHeight(), matrix, true);
			break;
		}
		// recycle
		if (bmpRaw != bmpNew && !bmpRaw.isRecycled()) {
			bmpRaw.recycle();
			bmpRaw = null;
		}
		return bmpNew;
	}

	/**
	 * 释放图片内存。
	 * 
	 * @param bitmap
	 */
	public static void recycleBitmap(Bitmap bitmap) {
		if (null != bitmap && !bitmap.isRecycled()) {
			bitmap.recycle();
		}
	}
}
