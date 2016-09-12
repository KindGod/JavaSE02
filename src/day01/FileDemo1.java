package day01;

import java.io.File;

/**
 * java.io.File 该类用来表示一个文件或目录 使用它可以： 1:访问文件或目录的属性(名字，大小，最后需改时间等)
 * 2:操作文件或目录(创建，删除)
 * 
 * @author Administrator
 * 
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * 表示当前项目根目录下的文件test.txt 在描述文件或目录时，我们指定的路径最好 使用相对路径，否则会出现系统差异，不利于 跨平台。
		 * ".":当前目录 在eclipse中运行时，表示当前项目的根目录
		 */
		/*
		 * java.io.File; 由于目录的层级分隔符不同系统也有差异： windows:"\",例如:d:\xxx.txt linux:"/"
		 * 所以应当使用File的常量表示: File.separartor
		 */
		File file = new File("." + File.separator + "test.txt");
		/*
		 * 获取属性信息的相关方法
		 */
		// 获取文件名
		String name = file.getName();
		System.out.println("名字:" + name);

		// 获取文件大小:long length()
		long length = file.length();
		System.out.println("占用:" + length + "字节");

		// 查看文件是否真实存在
		boolean exists = file.exists();
		System.out.println("文件是否真实存在:" + exists);

		// 查看是否表示的是文件
		boolean isFile = file.isFile();
		System.out.println("是文件:" + isFile);

		// 查看是否表示的是目录
		boolean isDir = file.isDirectory();
		System.out.println("是目录" + isDir);
		/*
		 * 以下三个方法判断文件或目录是否可写，可读，可运行
		 */
		file.canWrite();
		file.canRead();
		file.canExecute();
		// 是否为隐藏文件
		file.isHidden();

	}
}
