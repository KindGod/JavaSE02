package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java.io.OutputStreamWriter �ַ�����������ַ�Ϊ��λд������ �ַ������Ǹ߼������������Ƕ�д�ַ�
 * ���±��ʻ��Ƕ�д�ֽڣ��ַ���ֻ�ǰ����������ֽ��� �ַ�֮������ת����
 * 
 * @author Administrator
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/*
		 * ���õ��������췽���� 1�� OutputStreamWriter(OutputStream out)
		 * �ù��췽���Ὣ�������ֽ������а�װ��Ȼ��ǰ�� �ͻᰴ��ϵͳĬ�ϵ��ַ�����Ҫд�����ַ���ת��Ϊ ��Ӧ��һ���ֽڣ���ͨ���������ֽ���д����
		 * 
		 * 2�� OutputStreamWriter(OutputStream out,String charsetName)
		 * ʹ�ø������ַ������ַ���ת��Ϊһ���ֽں�д���� ͨ������ʹ�õ�ǰ����Ŀ�ľ���Ҫ���ַ������ո��� ���ַ���д��������������췽����á�
		 */
		// OutputStreamWriter osw
		// = new OutputStreamWriter(fos);

		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		String str = "�Ұ������찲��";
		osw.write(str);
		osw.write("�찲����̫����");

		osw.write('!');
		osw.close();
		/*
		 * ��WorkSpace�����н����
		 */

	}
}
