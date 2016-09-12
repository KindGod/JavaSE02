package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 按照指定的字符集创建PrintWriter
 * 
 * @author Administrator
 *
 */
public class PWDemo3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		// 通过OSW指定字符集
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		PrintWriter pw = new PrintWriter(osw);

		pw.println("随便吧");

		pw.close();
	}
}
