package com.darling.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;

/**
 * 此类主要用于获得内存卡路径，用户保存数据路径获取等操作
 * **/

@SuppressLint("DefaultLocale")
public class StorageUtil {

	private static final String WROK_FILE = "/darling";
	private static final String PHOTOINFO_FILE= "/riverInfo/riverPhoto";
	private static final String RECORDERINFO_FILE= "/riverInfo/riverRecorder";
	private static String cmd = "cat /proc/mounts";
	private static String format = "sdcard";
	private static final String APK_FILE="/update.apk";
	private static String sdCard = Environment.getExternalStorageDirectory()
			.getAbsolutePath();
	private static final int MB = 1024 * 1024;
	private static final String QSH_FILE = "/darling.db";


	/**
	 * 获取设备的SDCard的根目录
	 * 
	 * @return SDCard的根目录
	 */
	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {

			sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
		}
		return sdDir.toString();

	}

	/**
	 * 獲取外置SDCard的絕對路徑
	 * 
	 * @return
	 */
	public static String getExternalPath() {
		BufferedReader read = null;
		String external_SDCard = sdCard;
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(cmd);
			read = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line;
			while ((line = read.readLine()) != null) {
				// if (line.toLowerCase().contains(format) &&
				// line.contains(".android-secure")) {
				if (line.toLowerCase().contains(format)) {
					String[] array = line.split(" ");
					if (array != null && array.length >= 5) {
						String temp = array[1].replace("/.android_secure", "");
						if (!sdCard.equals(temp)) {
							external_SDCard = temp;
						}
					}
				}
			}
		} catch (Exception e) {
			external_SDCard = sdCard;
			e.printStackTrace();
		} finally {

		}
		return external_SDCard;
	}

	/**
	 * 获取系统存工作的文件夹路径，如果不存在，则创建后再返回
	 * 
	 * @return
	 */
	public static String getWorkFilePath() {

		String workfile = getSDPath() + WROK_FILE;
		File file = new File(workfile);
		if (!file.exists()) {
			file.mkdirs();
		}
		return workfile;
	}

	public static String getPhotoInfoPath() {
		
		String photoinfofile = getUserInfoPath() + PHOTOINFO_FILE;
		File file = new File(photoinfofile);
		if (!file.exists()) {
			file.mkdirs();
		}
		return photoinfofile;
	}


	public static String getRecorderInfoPath() {
	
		String recorderinfofile = getUserInfoPath() + RECORDERINFO_FILE;
		File file = new File(recorderinfofile);
		if (!file.exists()) {
			file.mkdirs();
		}
		return recorderinfofile;
	}

	/**
	 * 获取当前用户的工作目录
	 * @return
	 */
	public static String getUserInfoPath() {
		
		String userInfoFile = getWorkFilePath() + "/User" + GlobalVariable.userInfo.getId();
		File file = new File(userInfoFile);
		if (!file.exists()) {
			file.mkdirs();
		}
		return userInfoFile;
	}

	/**
	 * 获取SDCard的剩余空间
	 * @author wanglg
	 * @return 单位： MB
	 */
	public static int getFreeSpaceOnSDCard(){
		StatFs statFs = new StatFs(sdCard);
		double sdFreeMB = (double)statFs.getAvailableBlocks() * (double) statFs.getBlockSize()/MB;
		return (int)sdFreeMB;
	}

	public static String getQSHDBFile() {
		String DBfile = getWorkFilePath() + QSH_FILE;
		return DBfile;
	}

	public static String getApkFile() {
		String APKfile = getWorkFilePath() + APK_FILE;
		return APKfile;
	}
}
