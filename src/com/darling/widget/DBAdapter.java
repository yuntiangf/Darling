package com.darling.widget;

import java.util.Iterator;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author hemj
 * @date 2011-11-2
 */
final class DBAdapter {
	/**
	 * database name.
	 */
	private static final String DATABASE_NAME = "dog_camera_cache";

	/**
	 * database version.
	 */
	private static int DATABASE_VERSION = 1;

	/**
	 * table for camera.
	 */
	public static final String TB_SYSTEM_CAMERA = "SYS_CAMERA_TEMP";

	private static final String CRT_SYS_CAMERA_TEMP = "create table if not exists SYS_CAMERA_TEMP (_id integer, data blob);";

	private Context context;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;

	/**
	 * 
	 * @param context
	 */
	public DBAdapter(Context context) {
		this.context = context;
		dbHelper = new DatabaseHelper(this.context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		private DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DBAdapter.CRT_SYS_CAMERA_TEMP);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			this.onCreate(db);
		}
	}

	/**
	 * Open a database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public synchronized DBAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	/**
	 * Close a database connection
	 */
	public synchronized void close() {
		dbHelper.close();
		db.close();
	}

	/**
	 * create Operation
	 * 
	 * @param table
	 * @param cols
	 */
	@SuppressWarnings({ "rawtypes" })
	public synchronized void create(String table, Map cols) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE IF NOT EXISTS " + table + " (");

		Iterator it = cols.keySet().iterator();

		while (it.hasNext()) {
			String key = (String) it.next();
			Object val = cols.get(key);
			if (val instanceof Integer) {
				sb.append(key + " INTEGER,");
			} else if (val instanceof String) {
				sb.append(key + " TEXT,");
			} else if (val instanceof byte[]) {
				sb.append(key + " BLOB,");
			} else if (val instanceof Long) {
				sb.append(key + " INTEGER,");
			} else if (val instanceof Short) {
				sb.append(key + " INTEGER,");
			} else if (val instanceof Float) {
				sb.append(key + " REAL,");
			} else if (val instanceof Double) {
				sb.append(key + " REAL,");
			} else if (val instanceof Boolean) {
				sb.append(key + " TEXT,");
			} else {
				sb.append(key + " TEXT,");
			}
		}
		sb.append("EXTRADATA TEXT)");
		db.execSQL(sb.toString());
	}

	/**
	 * execSQL.
	 * 
	 * @param sql
	 */
	public synchronized void execSQL(String sql) {
		db.execSQL(sql);
	}

	/**
	 * add Operation
	 * 
	 * @param table
	 * @param values
	 * @return
	 */
	public synchronized long add(String table, ContentValues values) {
		return db.insert(table, null, values);
	}

	/**
	 * list Operation
	 * 
	 * @param table
	 * @param cols
	 * @param selection
	 * @param selectionArgs
	 * @param orderBy
	 * @return
	 */
	public synchronized Cursor list(String table, String[] cols,
			String selection, String[] selectionArgs, String orderBy) {
		Cursor mCursor = db.query(true, table, cols, selection, selectionArgs,
				null, null, orderBy, null);
		return mCursor;
	}

	/**
	 * 
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return
	 */
	public synchronized boolean modify(String table, ContentValues values,
			String whereClause, String[] whereArgs) {
		return db.update(table, values, whereClause, whereArgs) > 0;
	}

	/**
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return
	 */
	public synchronized boolean remove(String table, String whereClause,
			String[] whereArgs) {
		return db.delete(table, whereClause, whereArgs) > 0;
	}

	/**
	 * clear Operation
	 * 
	 * @param table
	 */
	public synchronized void clear(String table) {
		db.delete(table, null, null);
	}

	/**
	 * drop table
	 * 
	 * @param table
	 */
	public synchronized void drop(String table) {
		db.execSQL("DROP TABLE IF EXISTS " + table);
	}

}