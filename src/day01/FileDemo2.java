package day01;

import java.io.File;
import java.io.IOException;

/**
 * ʹ��File����һ�����ļ�
 * 
 * @author Administrator
 * 
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * �ڵ�ǰ��Ŀ��Ŀ¼�´���һ����Ϊdemo.txt ���ļ� �����ڵ�ǰĿ¼�£�"./"�ǿ��Ժ��Բ�д��
		 */
		File file = new File("demo.txt");
		// �����ļ��������򴴽�
		if (!file.exists()) {
			// �������ļ�
			file.createNewFile();
			System.out.println("������ϣ�");
		}
	}
}