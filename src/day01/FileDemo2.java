package day01;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个新文件
 * 
 * @author Administrator
 * 
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前项目根目录下创建一个名为demo.txt 的文件 若是在当前目录下，"./"是可以忽略不写的
		 */
		File file = new File("demo.txt");
		// 若该文件不存在则创建
		if (!file.exists()) {
			// 创建新文件
			file.createNewFile();
			System.out.println("创建完毕！");
		}
	}
}