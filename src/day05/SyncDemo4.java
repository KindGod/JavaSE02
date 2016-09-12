package day05;

/**
 * ��̬�����ϱ�synchronized���κ󣬸þ�̬������Ϊͬ���ġ� ���ھ�̬����������޹أ�������أ��������۵���
 * �ĸ�����������̬����������ͬ���ԡ���Ȼ����̬���� Ӧ��ʹ������.����( )����ʽ���ã�����Ӧ��ʹ�� ������á���̬���������������(������ǰ��Ķ���)
 * �ö����ʵ������ΪClass��������ڼ�������ʹ�õ� ÿ����ʱ���ᴴ��һ��Classʵ�������������Ա��˽�
 * ��������Щ���Է����ȡ�����ÿ����ֻ��һ�������
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
			System.out.println(t + "������method����");
			Thread.sleep(5000);
			System.out.println(t + "������method������");
		} catch (InterruptedException e) {
		}
	}

	public synchronized void methodB() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t + "������method����");
			Thread.sleep(5000);
			System.out.println(t + "������method������");
		} catch (InterruptedException e) {
		}
	}
}
