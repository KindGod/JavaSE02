package day01;

/**
 */
import java.io.File;

public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰ��Ŀ��Ŀ¼�´���Ŀ¼: a/b/c/d/e/f
		 */
		File dir = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "d" + File.separator + "e" + File.separator
				+ "f");
		if (!dir.exists()) {
			/*
			 * mkdirs()�ڴ�����ǰĿ¼��ͬʱ�� ���в����ڵĸ�Ŀ¼һͬ����
			 */
			dir.mkdirs();
			System.out.println("������ϣ�");
		}
	}
}
