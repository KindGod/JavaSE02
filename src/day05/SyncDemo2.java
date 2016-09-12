package day05;

/**
 * 在方法上使用synchronized虽然可以起到同步的效果 但是由于整个方法所有代码变为同步，对于并发执行的效率
 * 来讲会有所降低。除非整个方法所有代码都需要这样做 否则我们应当使用synchronized块的形式，将需要同步的代码
 * 括起来减小同步范围，这样在保证安全的前提下 也提高了并发执行的效率。
 * 
 * @author 24470
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread() {
			public void run() {
				try {
					shop.buy();
				} catch (InterruptedException e) {
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				try {
					shop.buy();
				} catch (InterruptedException e) {
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop {
	public void buy() throws InterruptedException {
		Thread t = Thread.currentThread();

		System.out.println(t + "正在挑衣服..");
		Thread.sleep(5000);
		synchronized (this) {
			System.out.println(t + "正在试衣服..");
			Thread.sleep(5000);
		}

		System.out.println(t + "结账离开");

	}
}