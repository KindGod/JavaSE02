package day01;

import java.io.File;

/**
 * ʹ��File����һ��Ŀ¼
 * 
 * @author Administrator
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * ����Ŀ��Ŀ¼�´���Ŀ¼demo
		 */
		File dir = new File("demo");
		if (!dir.exists()) {
			// ����Ŀ¼
			dir.mkdir();
			System.out.println("������ϣ�");

		}
	}

}
