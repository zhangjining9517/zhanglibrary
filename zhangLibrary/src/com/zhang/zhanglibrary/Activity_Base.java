package com.zhang.zhanglibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zhang.zhanglibrary.util.ExitUtil;

/**
 * 
 * 类名：Activity_Base 说明：Activity的基类
 * 
 */
public abstract class Activity_Base extends Activity {

	protected final String TAG = this.getClass().getSimpleName();
	protected Context m_ctx;

	/**
	 * 第一次点击退出键的时间
	 */
	private long m_firstTime;

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	/**
	 * 功能：是否隐藏软键盘
	 * 
	 * @return
	 */
	protected boolean hideSoftKeybord() {
		return true;
	}

	/**
	 * 功能：是否是Diaolog样式的
	 * 
	 * @return
	 */
	protected boolean isDialog() {
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	/**
	 * 设置返回按钮是否点击之后是finish()
	 * 
	 * @return
	 */
	protected boolean isBackBtnClickFinish() {
		return true;
	}

	/**
	 * 功能：设置顶部菜单是否隐藏
	 * 
	 * @return
	 */
	protected boolean topViewHide() {
		return false;
	}

	/******************* Toast *********************/
	protected final void toastShort(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	protected final void toastLong(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

	// private void initConfig() {
	// if(hideSoftKeybord()){
	// getWindow().setSoftInputMode(// 设置不自动弹出软键盘
	// WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	// }else{
	// getWindow().setSoftInputMode(// 设置不自动弹出软键盘
	// WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
	// }
	// requestWindowFeature(Window.FEATURE_NO_TITLE);
	// }

	/**
	 * 功能：点击返回键退出app？
	 * 
	 * @return
	 */
	protected boolean pressBackExitApp() {
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (!pressBackExitApp()) {
			return super.onKeyDown(keyCode, event);
		}
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			long secondTime = System.currentTimeMillis();
			if (secondTime - m_firstTime > 2000) {
				// 如果两次按键时间间隔大于2秒，则不退出
				toastShort("再按一次退出程序");
				m_firstTime = secondTime;// 更新firstTime
				return true;
			} else { // 两次按键小于2秒时，退出应用
				ExitUtil.getInstant().exitApp(m_ctx);
			}
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// 点击返回键之后的动画效果
		overridePendingTransition(R.anim.unzoom_in, R.anim.unzoom_out);
	}

}
