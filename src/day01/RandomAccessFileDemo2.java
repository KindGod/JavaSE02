package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ�ļ�����
 * 
 * @author Administrator
 * 
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "r");
		/*
		 * int read() ���ļ��е�ǰָ��λ�ô���ȡһ���ֽ� ����int��ʽ���ء���intֵֻ��"�Ͱ�λ" ��Ч��
		 * �����ص�intֵΪ-1����ʾ��ȡ���ļ�ĩβ
		 * 
		 * 00000000 00000000 00000000 00000000
		 */
		int d = raf.read();
		System.out.println(d);
		raf.close();
	}
}
