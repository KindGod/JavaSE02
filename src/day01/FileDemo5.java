package day01;

/**
 */
import java.io.File;

public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 在当前项目根目录下创建目录: a/b/c/d/e/f
		 */
		File dir = new File("a" + File.separator + "b" + File.separator + "c"
				+ File.separator + "d" + File.separator + "e" + File.separator
				+ "f");
		if (!dir.exists()) {
			/*
			 * mkdirs()在创建当前目录的同时将 所有不存在的父目录一同创建
			 */
			dir.mkdirs();
			System.out.println("创建完毕！");
		}
	}
}
