package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ�������ɸ����ļ��Ĳ���
 * 
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ˼·�� ʹ��FIS��ԭ�ļ��ж�ȡ�ֽڣ���ͨ��FOS ���ֽ�д��Ŀ���ļ����Ӷ���ɸ��Ʋ�����
		 */
		FileInputStream fis = new FileInputStream("wnwb.exe");
		FileOutputStream fos = new FileOutputStream("wnwb_copy2.exe");
		byte[] buf = new byte[1024 * 10];
		int len = -1;

		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		System.out.println("������ϣ�");

		fis.close();
		fos.close();
	}
}
