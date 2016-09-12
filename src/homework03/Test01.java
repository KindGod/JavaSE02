package homework03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 作业第一题
 * 
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"pw.txt")));
			String line = null;
			String str = "";
			while ((line = br.readLine()) != null) {
				str += line;
			}
			pw = new PrintWriter(new FileOutputStream("pw.txt", true));
			pw.println(str);
		} catch (Exception e) {
			System.out.println("出错了！");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
	}
}
