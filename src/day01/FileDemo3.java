package day01;

import java.io.File;

/**
 * ʹ��һ��Fileɾ��һ���ļ�
 * 
 * @author Administrator
 * 
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * ����Ŀ��Ŀ¼�µ�demo.txt�ļ�ɾ��
		 */
		File file = new File("demo.txt");
		if (file.exists()) {
			// ɾ���ļ�
			file.delete();
			System.out.println("ɾ����ϣ�");
		}
	}
}
