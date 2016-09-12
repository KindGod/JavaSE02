package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 更快速的复制方法 批量读写数据可以减少读写次数，从而可以提高复制效率
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("wnwb.exe", "r");
		RandomAccessFile desc = new RandomAccessFile("wnwb_cpoy2.exe", "rw");
		// 10k
		byte[] data = new byte[1024 * 10];// 定义一个字节数组（缓冲区）
		int len = -1;

		long start = System.currentTimeMillis();

		while ((len = src.read(data)) != -1) {
			desc.write(data, 0, len);
		}

		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:" + (end - start) + "ms");
		src.close();
		desc.close();
	}
}
