package day03;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter �����ַ��������������"��"Ϊ��λд���ַ��� ���幦����ʵ�ǿ�BufferedWriterʵ�ֵģ�PW����
 * ֮�⻹��һ���ù��ܣ��Զ�"��"ˢ�¡�
 * 
 * @author Administrator
 *
 */
public class PWDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ļ�ֱ�Ӳ����Ĺ��췽���� PrintWriter(File file) PrintWriter(String path)
		 */
		PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
		// ��"��"Ϊ��λд���ַ���
		pw.println("�Ұ������찲��");
		pw.println("�찲����̫����");

		pw.close();
	}
}
