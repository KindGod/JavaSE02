package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile提供了可以一次性 读取若干字节的方法
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "r");
		raf.read();
		byte[] data = new byte[100];
		/*
		 * int read(byte[] d) 该方法会试图一次性读取给定的字节数组总长度 的字节量，并将这些字节顺序的存入给定的字节数组中。
		 * 返回值为实际读取到的字节量，若返回值为 -1，则表示读取到文件末尾了。
		 */
		int len = raf.read(data);
		System.out.println("实际读取了:" + len + "个字节");
		/*
		 * 将给定的字节数组中从给定的下标对应的字节开始连续 len个字节按照给定的字符集转换为字符串。
		 */
		String str = new String(data, 20, len, "utf-8");
		System.out.println(str);
		raf.close();
	}
}
