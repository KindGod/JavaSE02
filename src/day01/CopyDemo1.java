package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ļ�
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ˼·:��������RandomAccessFile һ��������ԭ�ļ���ȡ����һ������д��Ŀ���ļ���
		 */
		// ����һ��RAF��ȡԭ�ļ�
		RandomAccessFile src = new RandomAccessFile("music.m4r", "r");
		// //����һ��RAF������Ŀ���ļ�д������
		RandomAccessFile desc = new RandomAccessFile("music_copy.m4r", "rw");
		// ����ÿ�ζ�ȡ��һ���ֽ�
		int d = -1;

		long start = System.currentTimeMillis();
		/*
		 * ����Ч�ʵͣ�ԭ������һ�ζ�д�������� ����Ӳ��Ƶ����д�� ����߶�дЧ�ʾ�Ҫ��߶�д�������������� ��д�Ĵ����Ӷ����Ч�ʡ�
		 */
		while ((d = src.read()) != -1) {
			desc.write(d);
		}

		long end = System.currentTimeMillis();

		System.out.println("�������!��ʱ:" + (end - start) + "ms");

		src.close();
		desc.close();
	}
}
