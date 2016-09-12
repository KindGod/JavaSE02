package day01;

import java.io.File;

/**
 * 使用File创建一个目录
 * 
 * @author Administrator
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * 在项目根目录下创建目录demo
		 */
		File dir = new File("demo");
		if (!dir.exists()) {
			// 创建目录
			dir.mkdir();
			System.out.println("创建完毕！");

		}
	}

}
