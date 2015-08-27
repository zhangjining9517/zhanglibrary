package com.zhang.zhanglibrary.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;

/**
 * 退出的工具类
 * 
 */
public class ExitUtil {

	private static ExitUtil mExitUtil;
	// Activity的对象池
	private List<Activity> activityPools;

	public static ExitUtil getInstant() {
		if (mExitUtil == null)
			mExitUtil = new ExitUtil();
		return mExitUtil;
	}

	/**
	 * 将一个Activity放入对象池
	 * 
	 * @param act
	 */
	public void addToPool(Activity act) {
		if (activityPools == null)
			activityPools = new ArrayList<Activity>();
		activityPools.add(act);
	}

	/**
	 * 清空对象池
	 */
	public void clearPool() {
		if (activityPools == null)
			return;
		activityPools.clear();
		activityPools = null;
	}

	/**
	 * 退出程序
	 */
	public void exitApp(Context c) {
		if (activityPools == null)
			return;
		for (Activity act : activityPools) {
			act.finish();
		}
		clearPool();
	}
}
