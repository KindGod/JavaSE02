package day01;

import java.io.File;

/**
 * ��File��ʾ����һ��Ŀ¼ ���ǿ��Ի�ȡ��Ŀ¼�µ��������� �����޷ǻ����ļ���Ŀ¼��
 * 
 * @author Administrator
 * 
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰ��Ŀ��Ŀ¼�µ���������
		 */
		File dir = new File(".");
		if (dir.isDirectory()) {
			/*
			 * File[] listFiles() �÷������ȡ��ǰĿ¼�µ��������� ÿһ�������޷ǻ����ļ���Ŀ¼������
			 * ����������File�����ʾÿһ������ ���ս����Ǵ���һ�����鷵�ء�
			 */
			File[] subs = dir.listFiles();

			for (File sub : subs) {
				if (sub.isFile()) {
					System.out.println("�ļ�:" + sub.getName());
				} else {
					System.out.println("Ŀ¼:" + sub.getName());
				}
				/*
				 * Ҳ����ʹ����Ŀ����� System.out.println( (sub.isFile()?"�ļ�:":"Ŀ¼:") +
				 * sub.getName());
				 */
			}
		}
	}
}
