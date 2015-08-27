package com.zhang.zhanglibrary.util;

import java.io.DataOutputStream;
import java.io.IOException;

import android.content.Context;
import android.widget.Toast;

/**
 * Class name : PhoneSetUitls description：phone set tools
 * 
 */
public class PhoneSetUitls {
	public static final String COMMAND_SU = "su";
	public static final String COMMAND_SH = "sh";
	public static final String COMMAND_EXIT = "exit\n";
	public static final String COMMAND_LINE_END = "\n";

	/**
	 * restart the phone
	 */
	public static void rebboot() {
		try {
			Runtime.getRuntime().exec("su -c reboot");
		} catch (IOException e) {
		}
	}

	/**
	 * change the system time
	 * 
	 * @param ctx
	 * @param datetime
	 *            date formatter yyyyMMdd.HHmmss
	 */
	public static void updateTime(Context ctx, String datetime) {
		try {
			Process process = Runtime.getRuntime().exec("su");
			DataOutputStream os = new DataOutputStream(
					process.getOutputStream());
			os.writeBytes("setprop persist.sys.timezone GMT\n");
			os.writeBytes("/system/bin/date -s " + datetime + "\n");
			os.writeBytes("clock -w\n");
			os.writeBytes("exit\n");
			os.flush();
			os.close();
			Toast.makeText(ctx, "系统时间同步成功", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(ctx, "系统时间同步失败", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

}
