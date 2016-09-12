package day04;

/**
 * Thread提供了一个静态方法： static Thread currentThread() 该方法用于获取这个方法的线程。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	/**
	 * 进程中至少有一个前台线程，而当java虚拟机 启动后就会启动一个前台线程来运行main方法。
	 * 
	 * 进程结束：当一个进程中的所有前台线程都结束了 进程就结束了，由于我们只有运行main 方法的这一个前台线程，所以当main方法
	 * 执行完毕，该线程完成任务结束。 进程中就没有前台线程了，所以进程 结束了。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取运行main方法的线程
		Thread t = Thread.currentThread();
		System.out.println("运行main方法的线程是：" + t); // Thread[main,5,main] 5表示优先级

		dosome();// 在main方法中调用dosome方法

		// 自定义线程
		Thread myT = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("自定义线程为" + t);
				dosome();
			}
		};
		myT.start();
	}

	public static void dosome() {
		// 获取运行dosome方法的当前线程
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是:" + t);
	}
}
