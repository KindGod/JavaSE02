package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * ����ָ�����ַ�������PrintWriter
 * 
 * @author Administrator
 *
 */
public class PWDemo3 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw2.txt");
		// ͨ��OSWָ���ַ���
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		PrintWriter pw = new PrintWriter(osw);

		pw.println("����");

		pw.close();
	}
}
