package com.darling.activity;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import com.darling.R;

/**
 * 欢迎界面
 * @author:MushRoom
 * @date:2015-11-22 下午7:50:42
 */
public class WelcomeActivity extends BaseActivity {

	@Override
	public int getLayoutId() {
		return R.layout.activity_welcome;
	}

	@Override
	public void onInitial() {
//		if(GlobalVariable.userData.getBoolean("IS_LOGIN", false)){
//			GlobalVariable.userInfo.setId(GlobalVariable.userData.getString("id", -1+""));
//			GlobalVariable.userInfo.setName(GlobalVariable.userData.getString(
//					"USER_NAME", ""));
//			GlobalVariable.userInfo.setPassword(GlobalVariable.userData
//					.getString("PASSWORD", ""));
//		}
		//下载数据
		downLoadDBFromAssets();
		
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				Intent intent=new Intent(WelcomeActivity.this,
						MainActivity.class);
				startActivity(intent);
				WelcomeActivity.this.finish();				
			}
			
		}, 1*1000);
	}
	
	/**
	 * 从assets下载DB文件
	 */
	protected void downLoadDBFromAssets(){
//		String sDatabasePath=StorageUtil.getWorkFilePath()+"/Darling.db";
//		File dbFile=new File(sDatabasePath);
//		if(!dbFile.exists()){
//			try{
//				AssetHelper.CopyAsset(WelcomeActivity.this,StorageUtil.getWorkFilePath(), "Darling.db");
//			}
//			catch(IOException e){
//				ActivityHelper.showAlert(WelcomeActivity.this, e.toString());
//			}
//		}
		
	}

}
