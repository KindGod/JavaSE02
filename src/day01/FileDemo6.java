package day01;

import java.io.File;

/**
 * 
 * @author Administrator
 */
public class FileDemo6 {
	public static void main(String[] args) {
		/*
		 * ɾ����Ŀ��Ŀ¼�µ�:a/b/c/d/e/f
		 */
		File dir = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "d" + File.separator + "e" + File.separator
				+ "f");

		if (dir.exists()) {
			/*
			 * ����ɾ��Ŀ¼��ǰ���Ǹ�Ŀ¼������ һ����Ŀ¼(Ŀ¼��û���κ�����) ����ɾ������
			 */
			dir.delete();
			System.out.println("ɾ����ϣ�");
		}
	}
}
