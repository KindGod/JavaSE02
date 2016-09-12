package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader �����ַ����������ص㣺�ԡ��С�Ϊ��λ��ȡ�ַ���
 * 
 * @author Administrator
 *
 */
public class BRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("." + File.separator + "src"
				+ File.separator + "day03" + File.separator + "BRDemo.java");
		InputStreamReader isr = new InputStreamReader(fis);
		/*
		 * �����ַ�����֧��ֱ���ַ���ת��Ϊ ������������������Ҫ��ʹ��ISR���ֽ��� ת��Ϊ�ַ����ſ���������ʹ��
		 */
		BufferedReader br = new BufferedReader(isr);
		/*
		 * String readLine() BufferedReader�ṩ�������������÷��� �᳢�Զ�ȡ�����ַ���ֱ����ȡ�����з�Ϊֹ
		 * Ȼ�󽫻��з�ǰ�������ַ����һ���ַ���Ȼ�� ���ء�����ַ����в����л��з��� ������ֵΪNULL��ʾ��û�����ݿɶ���
		 * ��һ����ֻ��һ�����з�����ô����ֵΪ�� �ַ�����Ҳ������NULL!
		 */
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
