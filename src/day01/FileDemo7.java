package day01;

import java.io.File;

/**
 * 若File表示的是一个目录 我们可以获取该目录下的所有子项 子项无非还是文件或目录。
 * 
 * @author Administrator
 * 
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 获取当前项目根目录下的所有子项
		 */
		File dir = new File(".");
		if (dir.isDirectory()) {
			/*
			 * File[] listFiles() 该方法会获取当前目录下的所有子项 每一个子项无非还是文件或目录，所以
			 * 可以用若干File对象表示每一个子项 最终将他们存入一个数组返回。
			 */
			File[] subs = dir.listFiles();

			for (File sub : subs) {
				if (sub.isFile()) {
					System.out.println("文件:" + sub.getName());
				} else {
					System.out.println("目录:" + sub.getName());
				}
				/*
				 * 也可以使用三目运算符 System.out.println( (sub.isFile()?"文件:":"目录:") +
				 * sub.getName());
				 */
			}
		}
	}
}
