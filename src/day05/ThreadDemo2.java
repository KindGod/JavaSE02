package day05;

/**
 * Object�϶�������������wait��notify ��һ���̵߳�����һ�������wait�����󣬸��߳̾ͽ���
 * ����״̬��ֱ����������notify���������ø��߳� �Ż��������� ʹ����������������߳�ͬ�������ļ�ʱ�Ը�ǿ��join
 * ����ȵ��̹߳�����ϲſ��ԣ���ʱ����Խϲ
 * 
 * @author 24470
 *
 */
public class ThreadDemo2 {
	private static Object obj = new Object();
	// ��ʾͼƬ�Ƿ��������
	private static boolean isFinish = false;

	public static void main(String[] args) {
		final Thread download = new Thread() { // Ϊʲô��final?
			public void run() {
				System.out.println("down:��ʼ����ͼƬ");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:%" + i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:����ͼƬ��ϣ�");
				isFinish = true;
				/*
				 * ��ͼƬ������Ϻ󣬾Ϳ���֪ͨshow�߳̿�ʼ �����ˡ�
				 * 
				 * API�ĵ�����˵��:�����ǵ���ĳ�������wait ����notify����ʱ���÷�����Ҫʹ��synchronized��
				 * ����ͬ���������������wait��notify�����Ķ��� ������ʵ�����й�����ᷢ���쳣��
				 */
				synchronized (obj) {
					obj.notify();
				}

				System.out.println("down:��ʼ���ظ���...");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:%" + i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:���ظ�����ϣ�");
			}
		};

		Thread show = new Thread() {
			public void run() {
				System.out.println("show:��ʼ��ʾͼƬ");
				/*
				 * ������ȴ�download�߳��Ƚ�ͼƬ������ϡ�
				 */
				try {
					// download.join();
					/*
					 * ��show�߳�ִ����仰���ͽ��� ����״̬�ˣ�ֱ�� obj ��notify���������ã��Ž��������
					 */
					synchronized (obj) {
						obj.wait();
					}
				} catch (InterruptedException e) {
				}
				if (!isFinish) {
					throw new RuntimeException("ͼƬ����ʧ�ܣ�");
				}
				System.out.println("show:��ʾͼƬ���");
			}
		};

		download.start();
		show.start();
	}
}
