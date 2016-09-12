package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader 缓冲字符输入流，特点：以“行”为单位读取字符串
 * 
 * @author Administrator
 *
 */
public class BRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("." + File.separator + "src"
				+ File.separator + "day03" + File.separator + "BRDemo.java");
		InputStreamReader isr = new InputStreamReader(fis);
		/*
		 * 缓冲字符流不支持直接字符流转换为 缓冲流，所以上面需要先使用ISR将字节流 转换为字符流才可以在这里使用
		 */
		BufferedReader br = new BufferedReader(isr);
		/*
		 * String readLine() BufferedReader提供了上述方法，该方法 会尝试读取若干字符，直到读取到换行符为止
		 * 然后将换行符前的所有字符组成一个字符串然后 返回。这个字符串中不含有换行符！ 若返回值为NULL表示再没有数据可读。
		 * 若一行中只有一个换行符，那么返回值为空 字符串，也不会是NULL!
		 */
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
