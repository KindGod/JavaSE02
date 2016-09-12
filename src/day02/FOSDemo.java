package day02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream 文件字节输出流，负责将数据写出到文件中的流
 * 
 * @author Administrator
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream若使用一个参数 的构造方法创建，则为覆盖写操作。 意思是，每次创建流对给定文件写数据前，
		 * 都会先将该文件中的所有数据清除后再进行新的写操作。
		 */
		// FileOutputStream fos
		// = new FileOutputStream("fos.txt");
		/*
		 * FileOutputStream支持重载的构造方法， 允许传入第二个参数，该参数是 一个boolean值，应当值为true时，
		 * FileOutputStream就是追加写操作。 会在当前文件末尾开始写入新数据。
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt", true);

		String str = "我的滑板鞋时尚时尚最时尚";

		byte[] data = str.getBytes("UTF-8");

		fos.write(data);

		fos.close();
	}
}
