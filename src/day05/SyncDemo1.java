package day05;

/**
 * 当多个线程同时操作一个数据时，由于线程切换的不确定性， 可能会导致出现逻辑混乱，严重时可能导致系统崩溃
 * 
 * @author 24470
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table1 = new Table();
		final Table table2 = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					int bean = table1.getBean();
					System.out.println(getName() + ":" + bean);
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					int bean = table2.getBean();
					Thread.yield();
					System.out.println(getName() + ":" + bean);
				}
			}
		};
		t1.start();
		t2.start();

	}
}

class Table {
	private int beans = 20;

	/**
	 * synchronized关键字可以修饰方法 当修饰了方法，该方法就是“同步”方法，多个线程 不能同时访问方法内部。必须排队做。
	 * 这就解决了多个线程同时操作同一数据导致的混乱问题。 synchronized若修饰的是方法，锁对象则是
	 * 当前方法所属的对象，在这个例子这就是main 方法中定义的table对象
	 * 
	 * @return
	 */
	// 用synchronized修饰表示同步方法，防止多线程并发！
	public synchronized int getBean() {
		if (beans == 0) {
			throw new RuntimeException("没有豆子了！");
		}
		// 模拟CPU时间片用完切换线程
		Thread.yield();
		return beans--;
	}
}
