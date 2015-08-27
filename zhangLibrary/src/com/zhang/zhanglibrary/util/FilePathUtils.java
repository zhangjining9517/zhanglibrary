package com.zhang.zhanglibrary.util;

import java.io.File;

import android.os.Environment;

/**
 * 
 * 类名：FilePathUtils 说明: 获取路径的几个方法
 * 
 * @author zjn
 */
public class FilePathUtils {

	/**
	 * 获取sd卡根目录
	 * 
	 * @return
	 */
	public static String getSDRootPath() {
		return Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator;
	}
}
