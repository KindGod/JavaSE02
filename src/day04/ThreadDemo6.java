package day04;

/**
 * 线程优先级 线程的优先级有10个等级，1最低，10最高，5默认 也可以使用Thread提供的常量： MIN_PRIORITY:最低优先级，对应数字为1
 * MAX_PRIORITY:最高优先级，对应数字为10 NORM_PRIORITY:默认优先级，对应数字为5
 * 原则上，优先级高的线程被分配CPU时间片的次数多
 * 
 * @author 24470
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("norm");
				}
			}
		};

		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);

		min.start();
		max.start();
		norm.start();
	}
}
