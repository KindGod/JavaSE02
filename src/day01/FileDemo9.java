package day01;

import java.io.File;

/**
 * ɾ���༶Ŀ¼ ����һ��Ŀ¼�п��ܺ����������Ҫɾ����ǰ��� Ŀ¼���뽫��������ɾ���ſ���
 * 
 * @author Administrator
 * 
 */
public class FileDemo9 {
	public static void main(String[] args) {
		File dir = new File("a");
		deleteFile(dir);
	}

	/**
	 * ��������File����ʾ���ļ���Ŀ¼ɾ�� �ݹ�
	 * 
	 * @param files
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] subs = file.listFiles();
			for (File sub : subs) {
				deleteFile(sub);
				// �����ڲ����Լ���������Ϊ�ݹ飬�����ݹ�������
			}
		}
		file.delete();
		System.out.println("ɾ���ɹ���");
	}
}
