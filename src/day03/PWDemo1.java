package day03;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter 缓冲字符输出流，可以以"行"为单位写出字符串 缓冲功能其实是靠BufferedWriter实现的，PW除此
 * 之外还有一个好功能：自动"行"刷新。
 * 
 * @author Administrator
 *
 */
public class PWDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 对文件直接操作的构造方法： PrintWriter(File file) PrintWriter(String path)
		 */
		PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
		// 以"行"为单位写出字符串
		pw.println("我爱北京天安门");
		pw.println("天安门上太阳升");

		pw.close();
	}
}
