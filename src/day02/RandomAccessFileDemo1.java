package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile提供了一个 可以一次性写出很多字节的方法
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		String str = "摩擦摩擦，是魔鬼的步伐！";
		/*
		 * String提供了可以用来将当前内容转换为对应 的一组字节的方法:
		 * 
		 * byte[] getByte() 将当前字符串按照当前系统默认字符集转换为 对应的一组字节，这里不同的操作系统可能存在
		 * 差异。windows是GBK，linux是UTF-8
		 * 
		 * byte[] getBytes(String charset) 将当前字符串按照给定的字符集转换为 一组字节 常用的字符集:
		 * GBK:国标编码 UTF-8:unicode的子集，俗称万国码。 互联网常用字符集编码 常见的: ISO8859-1：欧洲编码，不支持中文
		 */
		byte[] data = str.getBytes("UTF-8");
		// 将给定的一组字节全部一次性写出
		raf.write(data);
		raf.close();
	}
}
