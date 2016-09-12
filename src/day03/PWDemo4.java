package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 凡是使用流的形式创建PrintWriter,那么构造方法 都支持第二个参数，该参数为boolean型，当值为true 时就具有了自动“行”刷新
 * 自动“行”刷新：每当我们调用println()方法写出一行字符串后 就会自动flush（）写出 这样做会降低写出效率，但是写出具有即时性
 * 
 * @author Administrator
 *
 */
public class PWDemo4 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		FileOutputStream fos = new FileOutputStream("note.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		// 具有自动行刷新
		PrintWriter pw = new PrintWriter(osw, true);

		String line = null;
		while (true) {
			line = scanner.nextLine();
			if ("exit".equals(line)) {
				break;
			}
			// 调用println的时候会自动flush
			pw.println(line);
		}
		System.out.println("再见！");
		pw.close();
		scanner.close();
	}
}
