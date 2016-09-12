package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 通常池的概念是为了解决两个问题： 重用，控制数量。 所以线程池主要也是为了解决： 重用线程 控制线程数量
 * 
 * 当我们的程序频繁创建线程和销毁线程时 就应当考虑使用线程池来维护了。
 * 
 * @author 24470
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		/*
		 * ExecutorService线程池 创建一个固定数量的线程池，线程数量为两条
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t + "正在运行任务");
						Thread.sleep(5000);
						System.out.println(t + "将任务运行完毕！");
					} catch (InterruptedException e) {
					}
				}
			};
			threadPool.execute(runnable);
		}

		System.out.println("main准备结束线程池！");
		threadPool.shutdown();
		System.out.println("main结束了线程池！");
	}
}
