package day02;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.FileInputStream 文字字节输入流，也是低级流。作用是读取文件
 * 
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");

		byte[] data = new byte[100];

		int len = fis.read(data);

		String str = new String(data, 0, len, "UTF-8");

		System.out.println(str);

		fis.close();
	}
}
