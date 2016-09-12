package day03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader 字符输入流，该高级流的目的： 方便我们按照给定的字符集读取字符。 它会将对应的字节自动转换为字符。
 * 
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");

		InputStreamReader isr = new InputStreamReader(fis, "utf-8");// 不加字符集会有乱码！！

		int d = -1;
		while ((d = isr.read()) != -1) {
			char ch = (char) d;
			System.out.print(ch);
		}
		isr.close();
	}
}
