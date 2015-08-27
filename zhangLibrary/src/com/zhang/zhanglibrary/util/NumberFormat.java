package com.zhang.zhanglibrary.util;

/**
 * 
 * 类名：NumberFormat 说明: 数字格式转换工具
 * 
 * @author zjn
 */
public class NumberFormat {

	/**
	 * 把字符串转数字
	 * 
	 * @param strValue
	 * @return 字符串为 空 返回-1
	 */
	public static int parseInt(String strValue) {
		int i = -1;
		if (StringUtils.isEmpty(strValue)) {
			return i;
		}
		try {
			i = Integer.parseInt(strValue);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return i;
		}
		return i;
	}

	/**
	 * 把字符串转数字
	 * 
	 * @param strValue
	 * @return 字符串为 空 返回-1
	 */
	public static double parseDouble(String strValue) {
		double i = -1;
		if (StringUtils.isEmpty(strValue)) {
			return i;
		}
		try {
			i = Double.parseDouble(strValue);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return i;
		}
		return i;
	}

	/**
	 * 把字符串转数字
	 * 
	 * @param strValue
	 * @return 字符串为 空 返回-1
	 */
	public static float parseFloat(String strValue) {
		float i = -1;
		if (StringUtils.isEmpty(strValue)) {
			return i;
		}
		try {
			i = Float.parseFloat(strValue);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return i;
		}
		return i;
	}

}
