package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流来完成复制文件的操作
 * 
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 思路： 使用FIS从原文件中读取字节，在通过FOS 将字节写入目标文件，从而完成复制操作。
		 */
		FileInputStream fis = new FileInputStream("wnwb.exe");
		FileOutputStream fos = new FileOutputStream("wnwb_copy2.exe");
		byte[] buf = new byte[1024 * 10];
		int len = -1;

		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		System.out.println("复制完毕！");

		fis.close();
		fos.close();
	}
}
