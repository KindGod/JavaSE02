package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ�û�������߶�дЧ��
 * 
 * @author Administrator
 *
 */
public class CpoyDemo3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("wnwb.exe");
		// ʹ�û�����������߶�ȡЧ��
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("wnwb_cpoy4.exe");
		// ʹ�û�����������д��Ч��
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int d = -1;
		/*
		 * BufferedInputStream��read����: ����ֻ�Ƕ�ȡ��һ���ֽڡ�BIS�ڲ�ά����һ��
		 * ������(�ֽ�����)�������ǵ���read������ȡ һ���ֽ�ʱ��ʵ����BIS�������������� (�����������FIS)һ���Զ�ȡ�����ֽڣ�������
		 * �ڲ����ֽ������У�Ȼ�󽫵�һ���ֽڷ��ء� �����������ô����ڣ��������ٴε���read���� ��ȡһ���ֽ�ʱ������ֱ�ӽ��ֽ���������һ��
		 * �ֽڷ��أ���������ȥ��ȡ������ԭ����һ�� ��ȡ�����ֽڣ����ٶ�ȡ������ߵĶ�ȡЧ�ʡ�
		 */
		while ((d = bis.read()) != -1) {
			bos.write(d);
		}

		System.out.println("������ϣ�");

		bis.close();// ��������ֻ������������
		bos.close();
	}
}
