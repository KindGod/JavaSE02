package day01;

import java.io.File;

/**
 * 删除多级目录 由于一个目录中可能含有子项。所以要删除当前这个 目录必须将所有子项删除才可以
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
	 * 将给定的File所表示的文件或目录删除 递归
	 * 
	 * @param files
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] subs = file.listFiles();
			for (File sub : subs) {
				deleteFile(sub);
				// 方法内部调自己方法，称为递归，不过递归伤性能
			}
		}
		file.delete();
		System.out.println("删除成功！");
	}
}
