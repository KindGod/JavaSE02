package day04;

/**
 * ʹ�������ڲ������ʽ�����߳�
 * 
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		/*
		 * ��һ�ַ�ʽ��
		 */
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("����˭����");
				}
			}
		};
		/*
		 * �ڶ��ַ�ʽ��
		 */
		Runnable r1 = new Runnable() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("������ˮ��ģ�");
				}
			}
		};
		Thread t2 = new Thread(r1);

		t1.start();
		t2.start();
	}
}
