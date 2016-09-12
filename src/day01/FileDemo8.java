package day01;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用文件过滤器来获取一个目录下满足条件的部分子项 FileFilter:文件过滤器 是一个接口，本身不能实例化，我们需要定义一个类
 * 实现该类，并重写其定义的accept方法来定义过滤规则。
 * 
 * @author Administrator
 * 
 */
public class FileDemo8 {
	public static void main(String[] args) {
		FileFilter filter = new FileFilter() {
			/**
			 * accept方法用于定义过滤要求，当给定的 file对象满足要求就返回true即可。 下面的过滤条件是:
			 * 文件名以"."开头的就满足要求。
			 */
			public boolean accept(File file) {
				System.out.println("正在过滤：" + file);
				return file.getName().startsWith(".");
			}
		};
		File dir = new File(".");
		/*
		 * 重载的listFiles方法 要求我们传入一个文件过滤器，然后该方法 会将当前目录下的所有子项顺序的传递给
		 * 过滤器的accept方法，只将返回为true的 子项保留，最终存入一个数组并返回。
		 */
		File[] subs = dir.listFiles(filter);
		for (File sub : subs) {
			System.out.println(sub.getName());
		}
	}
}
