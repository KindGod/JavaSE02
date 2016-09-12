package day05;

/**
 * 线程提供了一个方法join 该方法允许当前线程进入阻塞状态等待另一个线程工作 完毕。通常需要协调两个线程工作的时候就要使用该方法。
 * 
 * @author 24470
 *
 */
public class ThreadDemo1 {
	// 表示图片是否下载完毕
	private static boolean isFinish = false;

	public static void main(String[] args) {
		final Thread download = new Thread() { // 为什么加final?
			public void run() {
				System.out.println("down:开始下载图片");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:%" + i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:下载图片完毕！");
				isFinish = true;
			}
		};

		Thread show = new Thread() {
			public void run() {
				System.out.println("show:开始显示图片");
				/*
				 * 在这里等待download线程先将图片下载完毕。
				 */
				try {
					download.join();// show阻塞，等待download执行完毕！
				} catch (InterruptedException e) {
				}
				if (!isFinish) {
					throw new RuntimeException("图片加载失败！");
				}
				System.out.println("show:显示图片完毕");
			}
		};

		download.start();
		show.start();
	}
}
