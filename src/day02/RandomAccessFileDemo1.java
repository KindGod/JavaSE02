package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ��һ�� ����һ����д���ܶ��ֽڵķ���
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		String str = "Ħ��Ħ������ħ��Ĳ�����";
		/*
		 * String�ṩ�˿�����������ǰ����ת��Ϊ��Ӧ ��һ���ֽڵķ���:
		 * 
		 * byte[] getByte() ����ǰ�ַ������յ�ǰϵͳĬ���ַ���ת��Ϊ ��Ӧ��һ���ֽڣ����ﲻͬ�Ĳ���ϵͳ���ܴ���
		 * ���졣windows��GBK��linux��UTF-8
		 * 
		 * byte[] getBytes(String charset) ����ǰ�ַ������ո������ַ���ת��Ϊ һ���ֽ� ���õ��ַ���:
		 * GBK:������� UTF-8:unicode���Ӽ����׳�����롣 �����������ַ������� ������: ISO8859-1��ŷ�ޱ��룬��֧������
		 */
		byte[] data = str.getBytes("UTF-8");
		// ��������һ���ֽ�ȫ��һ����д��
		raf.write(data);
		raf.close();
	}
}
