package day04;

/**
 * �ػ��̣߳��ֽ�����̨�߳� ʹ������ǰ̨�߳�û������Ψһ�ڽ����������� ���߳̽���ʱ�����ۺ�̨�߳��Ƿ������ж�Ҫǿ�ƽ�����
 * 
 * @author 24470
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		/*
		 * rose��������Ϊǰ̨�߳�
		 */
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("rose��let me go!");
					try {
						Thread.sleep(1000);// ��1����
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:������������������������");
				System.out.println("��Ч����ͨ");
			}
		};

		Thread jack = new Thread() {
			public void run() {
				while (true) {
					System.out.println("jack:you jump! i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		rose.start();

		// ����Ϊ�ػ��߳�
		jack.setDaemon(true);
		jack.start();

		/*
		 * GC����������һ���ػ��߳��ϵġ�
		 */
	}
}
