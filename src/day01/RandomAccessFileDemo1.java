package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile ���ڶ�д�ļ����ݵ��� ����ʱ������ģʽ�� ֻ��ģʽ�����ļ�ֻ���ж�ȡ���� ��дģʽ:���Զ��ļ����б༭
 * 
 * @author Administrator
 * 
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ļ�demo.dat��д������
		 */
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		/*
		 * void write(int d) �÷��������ļ���ǰָ��ָ��λ��д�� 1���ֽڣ����ֽ�д���Ǹ�����intֵ ��"�Ͱ�λ"
		 * 
		 * 00000000 00000000 00000000 00000010
		 * 
		 * ���� ����
		 */
		raf.write(256);
		/*
		 * RAF = RandomAccessFile ʹ��RAF��д���ļ���һ��Ҫ�ǵ�close �ͷŵײ���Դ
		 */
		raf.close();
	}
}
