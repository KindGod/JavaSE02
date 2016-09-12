package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter包装其他的流
 * 
 * @author Administrator
 *
 */
public class PWDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw1.txt");
		/*
		 * 可以直接将字节输出流转换为缓冲字符输出流 这样做的优点在于简单。 缺点在于不能按照指定字符集写出字符串， 只能按照系统默认字符集写出
		 */
		PrintWriter pw = new PrintWriter(fos);

		pw.println("随便吧");

		pw.close();
	}
}
