package day04;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Thread�ṩ��һ����̬����sleep ����������sleep���߳̽�������״ָ̬�����롣 ����ʱ�󣬸��̻߳��Զ��ص�runnable״̬�ȴ�����
 * CPUʱ��Ƭ�ٴ����С�
 * 
 * @author 24470
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		/*
		 * ʵ�ֵ��ӱ��� ÿ�������һ�ε�ǰϵͳʱ�� HH:mm:ss
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		while (true) {
			System.out.println(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
