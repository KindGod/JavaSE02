package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile读写基本类型数据
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
		/*
		 * 获取RAF指针位置，刚创建出来的RAF 指针默认指向文件的第一个字节。下标为0.
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		int max = Integer.MAX_VALUE;
		// 将int值写入文件
		/*
		 * 
		 * 01111111 11111111 11111111 11111111
		 */
		raf.write(max >>> 24);
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		raf.write(max);
		// 一次写出4个字节，将该int值完整写出。
		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		raf.writeInt(max);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 8

		raf.writeLong(123L);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 16

		raf.writeDouble(123.123);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);// 24
		/*
		 * 若想读取文件最开始的int值，需要 先将指针移动到相应的位置上 void seek(long pos)
		 */
		raf.seek(0);
		/*
		 * 连续读取4个字节并转换为int值返回 若读取到文件末尾，会抛出EOFException 的异常。EOF(end of file)
		 */
		int i = raf.readInt();
		System.out.println(i);

		pos = raf.getFilePointer();
		System.out.println("pos:" + pos);

		// 移动到long值的位置
		raf.seek(8);
		/*
		 * 连续读取8个字节，并将long值返回 同样的，若读取到文件末尾，会抛出异常
		 */
		long l = raf.readLong();
		System.out.println(l);
		raf.close();
	}
}
