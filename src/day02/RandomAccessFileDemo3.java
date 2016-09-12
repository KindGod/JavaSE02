package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile��д������������
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
		/*
		 * ��ȡRAFָ��λ�ã��մ���������RAF ָ��Ĭ��ָ���ļ��ĵ�һ���ֽڡ��±�Ϊ0.
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		int max = Integer.MAX_VALUE;
		// ��intֵд���ļ�
		/*
		 * 
		 * 01111111 11111111 11111111 11111111
		 */
		raf.write(max >>> 24);
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		raf.write(max);
		// һ��д��4���ֽڣ�����intֵ����д����
		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		raf.writeInt(max);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 8

		raf.writeLong(123L);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 16

		raf.writeDouble(123.123);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 24
		/*
		 * �����ȡ�ļ��ʼ��intֵ����Ҫ �Ƚ�ָ���ƶ�����Ӧ��λ���� void seek(long pos)
		 */
		raf.seek(0);
		/*
		 * ������ȡ4���ֽڲ�ת��Ϊintֵ���� ����ȡ���ļ�ĩβ�����׳�EOFException ���쳣��EOF(end of file)
		 */
		int i = raf.readInt();
		System.out.println(i);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		// �ƶ���longֵ��λ��
		raf.seek(8);
		/*
		 * ������ȡ8���ֽڣ�����longֵ���� ͬ���ģ�����ȡ���ļ�ĩβ�����׳��쳣
		 */
		long l = raf.readLong();
		System.out.println(l);
		raf.close();
	}
}
