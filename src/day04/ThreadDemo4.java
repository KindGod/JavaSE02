package day04;

/**
 * Thread�ṩ��һ����̬������ static Thread currentThread() �÷������ڻ�ȡ����������̡߳�
 * 
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	/**
	 * ������������һ��ǰ̨�̣߳�����java����� ������ͻ�����һ��ǰ̨�߳�������main������
	 * 
	 * ���̽�������һ�������е�����ǰ̨�̶߳������� ���̾ͽ����ˣ���������ֻ������main ��������һ��ǰ̨�̣߳����Ե�main����
	 * ִ����ϣ����߳������������� �����о�û��ǰ̨�߳��ˣ����Խ��� �����ˡ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ��ȡ����main�������߳�
		Thread t = Thread.currentThread();
		System.out.println("����main�������߳��ǣ�" + t); // Thread[main,5,main] 5��ʾ���ȼ�

		dosome();// ��main�����е���dosome����

		// �Զ����߳�
		Thread myT = new Thread() {
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("�Զ����߳�Ϊ" + t);
				dosome();
			}
		};
		myT.start();
	}

	public static void dosome() {
		// ��ȡ����dosome�����ĵ�ǰ�߳�
		Thread t = Thread.currentThread();
		System.out.println("����dosome�������߳���:" + t);
	}
}
