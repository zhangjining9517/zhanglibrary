package com.zhang.zhanglibrary.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流的io操作的测试 实际上字节流在操作完文件流时不用关闭或者flush 都是可以的。 
 * 字节流实际上是对文件的直接操作，字符流是对内存缓冲区的操作.字符流首先读取数据到
 * 内存缓冲区，只有flush之后才能写入文件
 * 
 * @author zhang
 * 
 */
public class ByteStreamTest {

	public static void main(String[] args) {

	}

	public static void createByteStream() {
		try {
			File file = new File("d:/abc/文章.txt");
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(new File("d:/abc/文章1.txt"));
			int len = -1;
			byte[] buffer = new byte[512];
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
				// out.flush();
			}
			// out.close();
			// in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void createCharcterStream() {
		File file = new File("d:/abc/文章.txt");
		try {
			FileReader reader = new FileReader(file);
			FileWriter fileWriter = new FileWriter(new File("d:/abc/文章1.txt"));
			char[] buffer = new char[512];
			int len = -1;
			while ((len = reader.read(buffer)) != -1) {
				fileWriter.write(buffer, 0, len);
				fileWriter.flush();
			}
			fileWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
