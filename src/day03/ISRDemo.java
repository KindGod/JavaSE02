package day03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader �ַ����������ø߼�����Ŀ�ģ� �������ǰ��ո������ַ�����ȡ�ַ��� ���Ὣ��Ӧ���ֽ��Զ�ת��Ϊ�ַ���
 * 
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");

		InputStreamReader isr = new InputStreamReader(fis, "utf-8");// �����ַ����������룡��

		int d = -1;
		while ((d = isr.read()) != -1) {
			char ch = (char) d;
			System.out.print(ch);
		}
		isr.close();
	}
}
