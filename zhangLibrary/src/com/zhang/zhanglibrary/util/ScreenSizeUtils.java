package com.zhang.zhanglibrary.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;

/**
 * 
 * ����ScreenUtils ˵��: ��Ļ�����ȡ������
 */
public class ScreenSizeUtils {

	private static SharedPreferences getPreferences(Context ctx) {
		return ctx.getSharedPreferences("Screen", 0);
	}

	public static void init(Activity ctx) {
		DisplayMetrics metrics = new DisplayMetrics();
		ctx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		saveScreen(ctx, metrics.widthPixels, metrics.heightPixels);
	}

	public static void saveScreen(Context ctx, int width, int hight) {
		getPreferences(ctx).edit().putInt("width", width)
				.putInt("hight", hight).commit();
	}

	public static int getWidth(Context ctx) {
		return getPreferences(ctx).getInt("width", 0);
	}

	public static int getHight(Context ctx) {
		return getPreferences(ctx).getInt("hight", 0);
	}
}
