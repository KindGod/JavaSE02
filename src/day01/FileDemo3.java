package day01;

import java.io.File;

/**
 * 使用一个File删除一个文件
 * 
 * @author Administrator
 * 
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * 将项目根目录下的demo.txt文件删除
		 */
		File file = new File("demo.txt");
		if (file.exists()) {
			// 删除文件
			file.delete();
			System.out.println("删除完毕！");
		}
	}
}
