package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ�˿���һ���� ��ȡ�����ֽڵķ���
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "r");
		raf.read();
		byte[] data = new byte[100];
		/*
		 * int read(byte[] d) �÷�������ͼһ���Զ�ȡ�������ֽ������ܳ��� ���ֽ�����������Щ�ֽ�˳��Ĵ���������ֽ������С�
		 * ����ֵΪʵ�ʶ�ȡ�����ֽ�����������ֵΪ -1�����ʾ��ȡ���ļ�ĩβ�ˡ�
		 */
		int len = raf.read(data);
		System.out.println("ʵ�ʶ�ȡ��:" + len + "���ֽ�");
		/*
		 * ���������ֽ������дӸ������±��Ӧ���ֽڿ�ʼ���� len���ֽڰ��ո������ַ���ת��Ϊ�ַ�����
		 */
		String str = new String(data, 20, len, "utf-8");
		System.out.println(str);
		raf.close();
	}
}
