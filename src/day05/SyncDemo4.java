package day05;

/**
 * 静态方法上被synchronized修饰后，该静态方法变为同步的。 由于静态方法与对象无关，和类相关，所以无论调用
 * 哪个对象的这个静态方法都具有同步性。当然，静态方法 应当使用类名.方法( )的形式调用，而不应该使用 对象调用。静态方法锁的是类对象(描述当前类的对象)
 * 该对象的实际类型为Class，虚拟机在加载我们使用的 每个类时都会创建一个Class实例来描述它，以便了解
 * 该类有哪些属性方法等。所以每个类只有一个类对象。
 * 
 * @author 24470
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b1 = new Boo();
		final Boo b2 = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				b1.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				b2.methodB();
			}
		};

		t1.start();
		t2.start();
	}
}

class Boo {
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t + "调用了method方法");
			Thread.sleep(5000);
			System.out.println(t + "调用完method方法了");
		} catch (InterruptedException e) {
		}
	}

	public synchronized void methodB() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t + "调用了method方法");
			Thread.sleep(5000);
			System.out.println(t + "调用完method方法了");
		} catch (InterruptedException e) {
		}
	}
}
