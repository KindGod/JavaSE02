package day04;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Thread提供了一个静态方法sleep 用于让运行sleep的线程进入阻塞状态指定毫秒。 当超时后，该线程会自动回到runnable状态等待分配
 * CPU时间片再次运行。
 * 
 * @author 24470
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		/*
		 * 实现电子表功能 每秒钟输出一次当前系统时间 HH:mm:ss
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
