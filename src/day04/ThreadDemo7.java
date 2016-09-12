package day04;

/**
 * 守护线程，又叫做后台线程 使用上与前台线程没有区别，唯一在结束上有区别。 当线程结束时，无论后台线程是否还在运行都要强制结束。
 * 
 * @author 24470
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		/*
		 * rose：扮演者为前台线程
		 */
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("rose：let me go!");
					try {
						Thread.sleep(1000);// 卡1秒钟
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:啊啊啊啊啊啊啊。。。。。");
				System.out.println("特效：噗通");
			}
		};

		Thread jack = new Thread() {
			public void run() {
				while (true) {
					System.out.println("jack:you jump! i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		rose.start();

		// 设置为守护线程
		jack.setDaemon(true);
		jack.start();

		/*
		 * GC就是运行在一个守护线程上的。
		 */
	}
}
