package com.zhang.zhanglibrary.util;

import android.widget.TextView;

/**
 * 
 * Class Name：TextViewUtils Description: use textview edittext and so widget
 * 
 * @author zhang
 */
public class TextViewUtils {

	/**
	 * access widget value
	 * 
	 * @param tv
	 * @return
	 */
	public static String getTextViewValue(TextView tv) {
		return tv.getText().toString();
	}

	/**
	 * set widget value
	 * 
	 * @param tv
	 *            contains TextView or EditText or Button
	 * @param strDefault
	 *            set default value
	 */
	public static void setTextViewValue(TextView tv, String strDefault) {
		tv.setText(strDefault);
	}
}
