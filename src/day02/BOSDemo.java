package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲字节输出流BufferedOutputStream 写出数据的一个问题: 通过缓冲流写出的数据不是立刻写出，而是先将数据存入
 * 其内部的一个字节数组中，只有字节数组存满了，才会真的 写出一次。
 * 
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");

		BufferedOutputStream bos = new BufferedOutputStream(fos);

		String str = "随便吧！";
		byte[] data = str.getBytes();

		bos.write(data);
		/*
		 * 该方法比较强制，不管缓冲区是否被装满 都要将缓冲区中现有的数据一次性写出去。 要清楚，频繁调用flush会提高写出次数，
		 * 从而降低写出性能，但是可以做到写出具有 即时性。
		 */
		bos.flush();
		// close方法内部会在关闭前自动flush一次
		bos.close();

	}
}
