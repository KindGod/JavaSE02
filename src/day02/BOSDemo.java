package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �����ֽ������BufferedOutputStream д�����ݵ�һ������: ͨ��������д�������ݲ�������д���������Ƚ����ݴ���
 * ���ڲ���һ���ֽ������У�ֻ���ֽ���������ˣ��Ż���� д��һ�Ρ�
 * 
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");

		BufferedOutputStream bos = new BufferedOutputStream(fos);

		String str = "���ɣ�";
		byte[] data = str.getBytes();

		bos.write(data);
		/*
		 * �÷����Ƚ�ǿ�ƣ����ܻ������Ƿ�װ�� ��Ҫ�������������е�����һ����д��ȥ�� Ҫ�����Ƶ������flush�����д��������
		 * �Ӷ�����д�����ܣ����ǿ�������д������ ��ʱ�ԡ�
		 */
		bos.flush();
		// close�����ڲ����ڹر�ǰ�Զ�flushһ��
		bos.close();

	}
}
