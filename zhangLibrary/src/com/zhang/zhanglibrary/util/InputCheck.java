package com.zhang.zhanglibrary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类名：InputCheck 说明：输入内容的检查工具类
 * 
 */
public class InputCheck {
	/**
	 * java 验证端口号是否合法
	 * 
	 * @param port
	 *            端口号
	 * @return
	 */
	public static boolean checkPort(String port) {
		boolean flag = false;
		Pattern pattern = Pattern
				.compile("([0-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])");
		Matcher m = pattern.matcher(port);
		flag = m.matches();
		return flag;
	}

	/** Java 验证Ip是否合法 */
	public static boolean checkIp(String ip) {
		boolean flag = false;
		Pattern pattern = Pattern
				.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher m = pattern.matcher(ip);
		flag = m.matches();
		return flag;
	}

}
