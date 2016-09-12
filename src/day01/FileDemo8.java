package day01;

import java.io.File;
import java.io.FileFilter;

/**
 * ʹ���ļ�����������ȡһ��Ŀ¼�����������Ĳ������� FileFilter:�ļ������� ��һ���ӿڣ�������ʵ������������Ҫ����һ����
 * ʵ�ָ��࣬����д�䶨���accept������������˹���
 * 
 * @author Administrator
 * 
 */
public class FileDemo8 {
	public static void main(String[] args) {
		FileFilter filter = new FileFilter() {
			/**
			 * accept�������ڶ������Ҫ�󣬵������� file��������Ҫ��ͷ���true���ɡ� ����Ĺ���������:
			 * �ļ�����"."��ͷ�ľ�����Ҫ��
			 */
			public boolean accept(File file) {
				System.out.println("���ڹ��ˣ�" + file);
				return file.getName().startsWith(".");
			}
		};
		File dir = new File(".");
		/*
		 * ���ص�listFiles���� Ҫ�����Ǵ���һ���ļ���������Ȼ��÷��� �Ὣ��ǰĿ¼�µ���������˳��Ĵ��ݸ�
		 * ��������accept������ֻ������Ϊtrue�� ����������մ���һ�����鲢���ء�
		 */
		File[] subs = dir.listFiles(filter);
		for (File sub : subs) {
			System.out.println(sub.getName());
		}
	}
}
