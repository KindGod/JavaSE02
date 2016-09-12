package day05;

/**
 * �ڷ�����ʹ��synchronized��Ȼ������ͬ����Ч�� �������������������д����Ϊͬ�������ڲ���ִ�е�Ч��
 * �������������͡����������������д��붼��Ҫ������ ��������Ӧ��ʹ��synchronized�����ʽ������Ҫͬ���Ĵ���
 * ��������Сͬ����Χ�������ڱ�֤��ȫ��ǰ���� Ҳ����˲���ִ�е�Ч�ʡ�
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

		System.out.println(t + "�������·�..");
		Thread.sleep(5000);
		synchronized (this) {
			System.out.println(t + "�������·�..");
			Thread.sleep(5000);
		}

		System.out.println(t + "�����뿪");

	}
}