package day02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream �ļ��ֽ����������������д�����ļ��е���
 * 
 * @author Administrator
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream��ʹ��һ������ �Ĺ��췽����������Ϊ����д������ ��˼�ǣ�ÿ�δ������Ը����ļ�д����ǰ��
		 * �����Ƚ����ļ��е���������������ٽ����µ�д������
		 */
		// FileOutputStream fos
		// = new FileOutputStream("fos.txt");
		/*
		 * FileOutputStream֧�����صĹ��췽���� ������ڶ����������ò����� һ��booleanֵ��Ӧ��ֵΪtrueʱ��
		 * FileOutputStream����׷��д������ ���ڵ�ǰ�ļ�ĩβ��ʼд�������ݡ�
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt", true);

		String str = "�ҵĻ���Ьʱ��ʱ����ʱ��";

		byte[] data = str.getBytes("UTF-8");

		fos.write(data);

		fos.close();
	}
}
