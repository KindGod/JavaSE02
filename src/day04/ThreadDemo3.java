package day04;

/**
 * 使用匿名内部类的形式创建线程
 * 
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		/*
		 * 第一种方式：
		 */
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("你是谁啊？");
				}
			}
		};
		/*
		 * 第二种方式：
		 */
		Runnable r1 = new Runnable() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("我是修水表的！");
				}
			}
		};
		Thread t2 = new Thread(r1);

		t1.start();
		t2.start();
	}
}
