package day05;

/**
 * �߳��ṩ��һ������join �÷�������ǰ�߳̽�������״̬�ȴ���һ���̹߳��� ��ϡ�ͨ����ҪЭ�������̹߳�����ʱ���Ҫʹ�ø÷�����
 * 
 * @author 24470
 *
 */
public class ThreadDemo1 {
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
			}
		};

		Thread show = new Thread() {
			public void run() {
				System.out.println("show:��ʼ��ʾͼƬ");
				/*
				 * ������ȴ�download�߳��Ƚ�ͼƬ������ϡ�
				 */
				try {
					download.join();// show�������ȴ�downloadִ����ϣ�
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
