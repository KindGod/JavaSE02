package day05;

/**
 * synchronized���ֵĻ����� ��һ�������������������synchronized���Σ� �����������������˻����ԡ�
 * ��synchronized����������β�ͬ�Ĵ��룬���� ��������������ͬ�������������Ҳ�л����ԡ�
 * 
 * @author 24470
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo foo = new Foo();

		Thread t1 = new Thread() {
			public void run() {
				foo.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				foo.methodB();
			}
		};

		t1.start();
		t2.start();
	}
}

class Foo {
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t + "���ڵ���A����");
			Thread.sleep(5000);
			System.out.println(t + "ִ����A������");
		} catch (InterruptedException e) {
		}
	}

	public synchronized void methodB() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t + "���ڵ���B����");
			Thread.sleep(5000);
			System.out.println(t + "ִ����B������");
		} catch (InterruptedException e) {
		}
	}
}
