package day02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ٵĸ��Ʒ��� ������д���ݿ��Լ��ٶ�д�������Ӷ�������߸���Ч��
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("wnwb.exe", "r");
		RandomAccessFile desc = new RandomAccessFile("wnwb_cpoy2.exe", "rw");
		// 10k
		byte[] data = new byte[1024 * 10];// ����һ���ֽ����飨��������
		int len = -1;

		long start = System.currentTimeMillis();

		while ((len = src.read(data)) != -1) {
			desc.write(data, 0, len);
		}

		long end = System.currentTimeMillis();
		System.out.println("�������!��ʱ:" + (end - start) + "ms");
		src.close();
		desc.close();
	}
}
