package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 * 
 * @author Administrator
 * 
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "r");
		/*
		 * int read() 从文件中当前指针位置处读取一个字节 并以int形式返回。该int值只有"低八位" 有效。
		 * 若返回的int值为-1，表示读取到文件末尾
		 * 
		 * 00000000 00000000 00000000 00000000
		 */
		int d = raf.read();
		System.out.println(d);
		raf.close();
	}
}
