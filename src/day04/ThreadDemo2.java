package day04;

/**
 * �̵߳ĵڶ��ִ�����ʽ ʵ��Runnable�ӿڣ�����дrun������ ���������񣬵������̣߳�
 * 
 * @author Administrator
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();

		Thread t1 = new Thread(r1);// ���������ͬʱ������ָ�ɽ�ȥ
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
	}
}

/**
 * �ڶ��ִ����̵߳ķ�ʽ��ʵ�����ǵ��������߳�Ҫִ�е����� ����ʵ����һ�����߳��޹صĽӿ�Runnable
 * ����java�ӿڿ��Զ�ʵ�֣����Բ���Ӱ����ʵ�������ӿڣ� ͬʱ����û�м̳������࣬��ôҲ��������ָ�����ࡣ
 * 
 * �ڶ����������ǵ���ָ�����߳�Ҫִ�е����񣬲����� �����̵߳�ʱ��Ž�����ָ�ɽ�ȥ�����������߳��ڲ� ����������ͽ�����߳�������֮�����Ϲ�ϵ��
 * 
 * @author Administrator
 *
 */
class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭����");
		}
	}
}

class MyRunnable2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
}