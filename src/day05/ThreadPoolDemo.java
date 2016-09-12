package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳� ͨ���صĸ�����Ϊ�˽���������⣺ ���ã����������� �����̳߳���ҪҲ��Ϊ�˽���� �����߳� �����߳�����
 * 
 * �����ǵĳ���Ƶ�������̺߳������߳�ʱ ��Ӧ������ʹ���̳߳���ά���ˡ�
 * 
 * @author 24470
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		/*
		 * ExecutorService�̳߳� ����һ���̶��������̳߳أ��߳�����Ϊ����
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t + "������������");
						Thread.sleep(5000);
						System.out.println(t + "������������ϣ�");
					} catch (InterruptedException e) {
					}
				}
			};
			threadPool.execute(runnable);
		}

		System.out.println("main׼�������̳߳أ�");
		threadPool.shutdown();
		System.out.println("main�������̳߳أ�");
	}
}
