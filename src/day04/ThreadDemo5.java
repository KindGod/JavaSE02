package day04;

/**
 * ��ȡ�߳�״̬��Ϣ����ط���
 * 
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		// ��ȡ����main�������߳�
		Thread t = Thread.currentThread();

		// �鿴�̵߳�Ψһ��ʶ
		long id = t.getId();
		System.out.println("id:" + id);

		String name = t.getName();
		System.out.println("name:" + name);

		int priority = t.getPriority();
		System.out.println("���ȼ�:" + priority);

		boolean isAlive = t.isAlive();
		System.out.println("isAlive:" + isAlive);

		boolean isDaemon = t.isDaemon();
		System.out.println("�Ƿ��̨�߳�:" + isDaemon);

		boolean isInterrupted = t.isInterrupted();
		System.out.println("�Ƿ��ж�:" + isInterrupted);
	}
}
