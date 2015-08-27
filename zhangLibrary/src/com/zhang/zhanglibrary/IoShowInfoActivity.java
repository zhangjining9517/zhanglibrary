package com.zhang.zhanglibrary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
/**
 * 1.文件目录显示例子
 * 2.io操作的例子
 * @author zhang
 *
 */
public class IoShowInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * 创建并返回一个目录，应用程序在该目录下存储数据文件
		 * /data/data/com.zjn.iooperatordemo/files
		 */
		File f = getFilesDir();
		System.out.println("filesDir " + f.toString());
		/*
		 * 创建并返回一个目录，应用程序在该目录下存储缓存数据文件
		 * /data/data/com.zjn.iooperatordemo/cache
		 */
		File f2 = getCacheDir();
		System.out.println("cacheDir "+f2.toString());
		/*
		 * 创建并返回一个指定名称的目录
		 * /data/data/com.zjn.iooperatordemo/app_abc
		 */
		File f3 = getDir("abc", MODE_PRIVATE);
		System.out.println("Dir "+ f3.toString());
		/*
		 * 4 用于返回数据库中指定名字的文件路径，在内部存储中应该保存的路径/data/data/com.zjn.iooperatordemo/databases/stu.db
		 */
		File f4 = getDatabasePath("stu.db");
		System.out.println("DatabasePath " + f4.toString());
		/*
		 *5  打开输出流对象，像文件中写入数据
		 */
		try {
			FileOutputStream out = openFileOutput("aba.txt", MODE_PRIVATE);
			out.write("正在进入io操作测试".getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DatabasePath " + f4.toString());
		/*
		 * 6.获取一个输入流对象，通过这个输入流对象读取指定文件
		 */
		try {
			FileInputStream in = openFileInput("aba.txt");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int len =0;
			byte[] buffer = new byte[1024];
			while((len = in.read(buffer))!= -1){
				out.write(buffer, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			System.out.println("inputStream "+ out.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*
		 * 7.获取内部存储的目录
		 *  /data
		 */
		File f7 = Environment.getDataDirectory();
		System.out.println("dataDirectory "+f7.toString());
		/*
		 * 8.获取内部存储缓冲的目录，隐藏的目录
		 *   /cache
		 */
		File f8 = Environment.getDownloadCacheDirectory();
		System.out.println("DownLoadCacheDirectory " + f8.toString());
		/*
		 * 9.获取内部下载系统的目录/system
		 */
		File f9 = Environment.getRootDirectory();
		System.out.println("rootDirectory " + f9.toString());
		/*
		 * 10.创建并返回外部存储目录，需要在sd卡上写入权限
		 * /storage/sdcard0/Android/data/com.zjn.iooperatordemo/files/Music
		 */
		File f10 = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
		System.out.println("ExternalFilesDir  "+ f10.toString());
		/*
		 * 11.创建并返回外部存储目录
		 * /storage/sdcard0/Android/data/com.zjn.iooperatordemo/cache
		 */
		File f11 = getExternalCacheDir();
		System.out.println("ExternalCacheDir "+ f11.toString());
		/*
		 * 12.返回sd卡的根目录
		 * /storage/sdcard0
		 */
		File f12 = Environment.getExternalStorageDirectory();
		System.out.println("externalStorageDirectory " + f12.toString());
		/*
		 * 13.返回sd卡公共存储目录/storage/sdcard0/Music
		 */
		File f13 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		System.out.println("ExternalStoragePublicDirectory " + f13.toString());
		/*
		 * 14.返回sd卡的状态，每次使用时，都要检查sd卡的状态mounted
		 */
		String state = Environment.getExternalStorageState();
		System.out.println("外部存储卡的状态 "+ state);
		/*
		 * 15.对源生资源的访问，在asset下面放一个数据库 ，读取并写入存储目录数据文件下
		 */
		File dir = getDatabasePath("stu.db");
		try {
			if(!dir.exists()){
				if(!dir.getParentFile().exists()){
					dir.mkdirs();
				}
				AssetManager manager = getAssets();
				InputStream in = manager.open("stu.db");
				FileOutputStream out = new FileOutputStream(dir);
				byte[] buffer = new byte[512];
				int len = -1;
				while((len = in.read(buffer))!= -1){
					out.write(buffer, 0, len);
				}
				out.flush();
				out.close();
				in.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
