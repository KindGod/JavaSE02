package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流提高读写效率
 * 
 * @author Administrator
 *
 */
public class CpoyDemo3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("wnwb.exe");
		// 使用缓冲输入流提高读取效率
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("wnwb_cpoy4.exe");
		// 使用缓冲输出流提高写出效率
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int d = -1;
		/*
		 * BufferedInputStream的read方法: 并不只是读取了一个字节。BIS内部维护了一个
		 * 缓冲区(字节数组)，当我们调用read方法读取 一个字节时，实际上BIS会从它处理的流中 (这个例子中是FIS)一次性读取若干字节，并存入
		 * 内部的字节数组中，然后将第一个字节返回。 这样的做法好处在于，当我们再次调用read方法 读取一个字节时，它会直接将字节数组中下一个
		 * 字节返回，而不是再去读取。所以原理还是一次 读取若干字节，减少读取次数提高的读取效率。
		 */
		while ((d = bis.read()) != -1) {
			bos.write(d);
		}

		System.out.println("复制完毕！");

		bis.close();// 缓冲流（只关最外层的流）
		bos.close();
	}
}
