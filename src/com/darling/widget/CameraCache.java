package com.darling.widget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * for save photo, for camera
 * @author:MushRoom
 * @date:2015-12-24 下午9:10:44
 */
public class CameraCache {

	public static boolean clearCamera(Context context) {
		DBAdapter dbAdapter = null;
		try {
			dbAdapter = new DBAdapter(context).open();
			return dbAdapter.remove(DBAdapter.TB_SYSTEM_CAMERA, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != dbAdapter) {
				dbAdapter.close();
				dbAdapter = null;
			}
		}
		return false;
	}

	public static boolean putCamera(Context context, byte[] data) {
		DBAdapter dbAdapter = null;
		try {
			dbAdapter = new DBAdapter(context).open();

			ContentValues values = new ContentValues();
			values.put("_id", 1);
			values.put("data", data);

			return (-1 != dbAdapter.add(DBAdapter.TB_SYSTEM_CAMERA, values));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != dbAdapter) {
				dbAdapter.close();
				dbAdapter = null;
			}
		}
		return false;
	}

	public static byte[] getCamera(Context context) {
		DBAdapter dbAdapter = null;
		Cursor cursor = null;
		try {
			dbAdapter = new DBAdapter(context).open();

			cursor = dbAdapter.list(DBAdapter.TB_SYSTEM_CAMERA,
					new String[] { "data" }, "_id=?", new String[] { "1" },
					null);

			if (cursor.moveToFirst()) {
				byte[] data = cursor.getBlob(0);
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != cursor) {
				cursor.close();
				cursor = null;
			}
			if (null != dbAdapter) {
				dbAdapter.close();
				dbAdapter = null;
			}
		}
		return null;
	}
}
