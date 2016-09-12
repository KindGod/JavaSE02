package day01;

import java.io.File;

/**
 * 
 * @author Administrator
 */
public class FileDemo6 {
	public static void main(String[] args) {
		/*
		 * 删除项目根目录下的:a/b/c/d/e/f
		 */
		File dir = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "d" + File.separator + "e" + File.separator
				+ "f");

		if (dir.exists()) {
			/*
			 * 若是删除目录，前提是该目录必须是 一个空目录(目录中没有任何内容) 否则删除不掉
			 */
			dir.delete();
			System.out.println("删除完毕！");
		}
	}
}
