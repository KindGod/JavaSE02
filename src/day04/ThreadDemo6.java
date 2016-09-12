package day04;

/**
 * �߳����ȼ� �̵߳����ȼ���10���ȼ���1��ͣ�10��ߣ�5Ĭ�� Ҳ����ʹ��Thread�ṩ�ĳ����� MIN_PRIORITY:������ȼ�����Ӧ����Ϊ1
 * MAX_PRIORITY:������ȼ�����Ӧ����Ϊ10 NORM_PRIORITY:Ĭ�����ȼ�����Ӧ����Ϊ5
 * ԭ���ϣ����ȼ��ߵ��̱߳�����CPUʱ��Ƭ�Ĵ�����
 * 
 * @author 24470
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("norm");
				}
			}
		};

		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);

		min.start();
		max.start();
		norm.start();
	}
}
