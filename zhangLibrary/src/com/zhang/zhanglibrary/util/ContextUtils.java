/*
 * Copyright (C) 2012 YIXIA.COM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhang.zhanglibrary.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

@SuppressLint("SdCardPath")
public class ContextUtils {

	/**
	 * get version code
	 * 
	 * @param ctx
	 * @return
	 */
	public static int getVersionCode(Context ctx) {
		int version = 0;
		try {
			version = ctx.getPackageManager().getPackageInfo(
					ctx.getApplicationInfo().packageName, 0).versionCode;
		} catch (Exception e) {
			Log.e("getVersionInt", e.getLocalizedMessage());
		}
		return version;
	}

	/**
	 * get data dir
	 * 
	 * @param ctx
	 * @return
	 */
	public static String getDataDir(Context ctx) {
		ApplicationInfo ai = ctx.getApplicationInfo();
		if (ai.dataDir != null)
			return fixLastSlash(ai.dataDir);
		else
			return "/data/data/" + ai.packageName + "/";
	}

	/**
	 * get fix last slash
	 * 
	 * @param str
	 * @return
	 */
	public static String fixLastSlash(String str) {
		String res = str == null ? "/" : str.trim() + "/";
		if (res.length() > 2 && res.charAt(res.length() - 2) == '/')
			res = res.substring(0, res.length() - 1);
		return res;
	}

	/**
	 * get version name
	 * 
	 * @param ctx
	 * @param apkPath
	 *            apk path
	 * @return
	 */
	public static String getAPKFileVersonName(Context ctx, String apkPath) {
		String version = "";
		PackageManager pm = ctx.getPackageManager();
		PackageInfo info = pm.getPackageArchiveInfo(apkPath,
				PackageManager.GET_ACTIVITIES);
		if (info != null) {
			version = info.versionName; // get version name
		}
		return version;
	}

	/**
	 * 
	 * get current application versionName
	 * 
	 * @return
	 */
	public String getCurrentAppVersionName(Context ctx) {
		// TODO Auto-generated method stub
		String strVersion = "";
		PackageManager pm = null;
		PackageInfo info = null;
		try {
			pm = ctx.getPackageManager();
			info = pm.getPackageInfo(ctx.getPackageName(), 0);
			if (info != null) {
				strVersion = info.versionName;
			}
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strVersion;
	}

}
