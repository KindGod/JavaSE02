package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 思路:创建两个RandomAccessFile 一个用来从原文件读取，另一个用来写到目标文件中
		 */
		// 创建一个RAF读取原文件
		RandomAccessFile src = new RandomAccessFile("music.m4r", "r");
		// //创建一个RAF用于向目标文件写出数据
		RandomAccessFile desc = new RandomAccessFile("music_copy.m4r", "rw");
		// 保存每次读取的一个字节
		int d = -1;

		long start = System.currentTimeMillis();
		/*
		 * 复制效率低，原因在于一次读写的数据少 导致硬盘频繁读写。 想提高读写效率就要提高读写的数据量，减少 读写的次数从而提高效率。
		 */
		while ((d = src.read()) != -1) {
			desc.write(d);
		}

		long end = System.currentTimeMillis();

		System.out.println("复制完毕!耗时:" + (end - start) + "ms");

		src.close();
		desc.close();
	}
}
