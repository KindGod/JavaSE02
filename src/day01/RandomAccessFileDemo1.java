package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile 用于读写文件数据的类 创建时有两种模式： 只读模式：对文件只进行读取操作 读写模式:可以对文件进行编辑
 * 
 * @author Administrator
 * 
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 向文件demo.dat中写入数据
		 */
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		/*
		 * void write(int d) 该方法会向文件当前指针指向位置写出 1个字节，该字节写的是给定的int值 的"低八位"
		 * 
		 * 00000000 00000000 00000000 00000010
		 * 
		 * 编码 解码
		 */
		raf.write(256);
		/*
		 * RAF = RandomAccessFile 使用RAF读写完文件后，一定要记得close 释放底层资源
		 */
		raf.close();
	}
}
