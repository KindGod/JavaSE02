package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter��װ��������
 * 
 * @author Administrator
 *
 */
public class PWDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw1.txt");
		/*
		 * ����ֱ�ӽ��ֽ������ת��Ϊ�����ַ������ ���������ŵ����ڼ򵥡� ȱ�����ڲ��ܰ���ָ���ַ���д���ַ����� ֻ�ܰ���ϵͳĬ���ַ���д��
		 */
		PrintWriter pw = new PrintWriter(fos);

		pw.println("����");

		pw.close();
	}
}
