package day05;

/**
 * Object上定义了两个方法wait，notify 当一个线程调用了一个对象的wait方法后，该线程就进入
 * 阻塞状态，直到这个对象的notify方法被调用该线程 才会解除阻塞。 使用这两个方法完成线程同步操作的即时性更强，join
 * 必须等到线程工作完毕才可以，即时性相对较差。
 * 
 * @author 24470
 *
 */
public class ThreadDemo2 {
	private static Object obj = new Object();
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
				/*
				 * 当图片下载完毕后，就可以通知show线程开始 工作了。
				 * 
				 * API文档上有说明:当我们调用某个对象的wait 或者notify方法时，该方法需要使用synchronized块
				 * 进行同步，而锁对象就是wait与notify所属的对象 否则在实际运行过程这会发生异常。
				 */
				synchronized (obj) {
					obj.notify();
				}

				System.out.println("down:开始下载附件...");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:%" + i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:下载附件完毕！");
			}
		};

		Thread show = new Thread() {
			public void run() {
				System.out.println("show:开始显示图片");
				/*
				 * 在这里等待download线程先将图片下载完毕。
				 */
				try {
					// download.join();
					/*
					 * 当show线程执行这句话，就进入 阻塞状态了，直到 obj 的notify方法被调用，才解除阻塞。
					 */
					synchronized (obj) {
						obj.wait();
					}
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
