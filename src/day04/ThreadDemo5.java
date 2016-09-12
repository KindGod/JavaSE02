package day04;

/**
 * 获取线程状态信息的相关方法
 * 
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		// 获取运行main方法的线程
		Thread t = Thread.currentThread();

		// 查看线程的唯一标识
		long id = t.getId();
		System.out.println("id:" + id);

		String name = t.getName();
		System.out.println("name:" + name);

		int priority = t.getPriority();
		System.out.println("优先级:" + priority);

		boolean isAlive = t.isAlive();
		System.out.println("isAlive:" + isAlive);

		boolean isDaemon = t.isDaemon();
		System.out.println("是否后台线程:" + isDaemon);

		boolean isInterrupted = t.isInterrupted();
		System.out.println("是否被中断:" + isInterrupted);
	}
}
