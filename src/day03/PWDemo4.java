package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ����ʹ��������ʽ����PrintWriter,��ô���췽�� ��֧�ֵڶ����������ò���Ϊboolean�ͣ���ֵΪtrue ʱ�;������Զ����С�ˢ��
 * �Զ����С�ˢ�£�ÿ�����ǵ���println()����д��һ���ַ����� �ͻ��Զ�flush����д�� �������ή��д��Ч�ʣ�����д�����м�ʱ��
 * 
 * @author Administrator
 *
 */
public class PWDemo4 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		FileOutputStream fos = new FileOutputStream("note.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		// �����Զ���ˢ��
		PrintWriter pw = new PrintWriter(osw, true);

		String line = null;
		while (true) {
			line = scanner.nextLine();
			if ("exit".equals(line)) {
				break;
			}
			// ����println��ʱ����Զ�flush
			pw.println(line);
		}
		System.out.println("�ټ���");
		pw.close();
		scanner.close();
	}
}
