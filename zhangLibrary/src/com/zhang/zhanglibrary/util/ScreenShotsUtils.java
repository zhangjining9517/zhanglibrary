package com.zhang.zhanglibrary.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;

/**
 * 
 * Class name：ScreenShotsUtils description: screenshots utils
 * 
 * @author zhang ji ning
 */
public class ScreenShotsUtils {

	/**
	 * get screenshots view
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap getScreenShots(Activity activity) {
		// get screenshots view
		View screenshotsView = activity.getWindow().getDecorView();
		screenshotsView.setDrawingCacheEnabled(true);
		screenshotsView.setDrawingCacheQuality(40);
		screenshotsView.buildDrawingCache();
		Bitmap screenshotsBitmap = screenshotsView.getDrawingCache();
		Rect outRect = new Rect();
		activity.getWindow().getDecorView()
				.getWindowVisibleDisplayFrame(outRect);
		int frameHeight = outRect.top;
		// get activtiy width and height
		int width = activity.getWindowManager().getDefaultDisplay().getWidth();
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(screenshotsBitmap, 0, frameHeight,
				width, height - frameHeight);
		screenshotsView.destroyDrawingCache();
		return bitmap;
	}

	/**
	 * save bitmap to sd card
	 * 
	 * @param bm
	 * @param strFilePath
	 * @return
	 */
	public static boolean saveToSdCard(Bitmap bm, String strFilePath) {
		boolean isSuccess = false;
		try {
			FileOutputStream outStream = new FileOutputStream(strFilePath);
			if (outStream != null) {
				isSuccess = bm.compress(CompressFormat.PNG, 40, outStream);
				outStream.flush();
				outStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}

}
