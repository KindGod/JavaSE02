package day05;

/**
 * ������߳�ͬʱ����һ������ʱ�������߳��л��Ĳ�ȷ���ԣ� ���ܻᵼ�³����߼����ң�����ʱ���ܵ���ϵͳ����
 * 
 * @author 24470
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table1 = new Table();
		final Table table2 = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					int bean = table1.getBean();
					System.out.println(getName() + ":" + bean);
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					int bean = table2.getBean();
					Thread.yield();
					System.out.println(getName() + ":" + bean);
				}
			}
		};
		t1.start();
		t2.start();

	}
}

class Table {
	private int beans = 20;

	/**
	 * synchronized�ؼ��ֿ������η��� �������˷������÷������ǡ�ͬ��������������߳� ����ͬʱ���ʷ����ڲ��������Ŷ�����
	 * ��ͽ���˶���߳�ͬʱ����ͬһ���ݵ��µĻ������⡣ synchronized�����ε��Ƿ���������������
	 * ��ǰ���������Ķ�����������������main �����ж����table����
	 * 
	 * @return
	 */
	// ��synchronized���α�ʾͬ����������ֹ���̲߳�����
	public synchronized int getBean() {
		if (beans == 0) {
			throw new RuntimeException("û�ж����ˣ�");
		}
		// ģ��CPUʱ��Ƭ�����л��߳�
		Thread.yield();
		return beans--;
	}
}
