package day03;

/**
 * ����Person�쳣���׳�����
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		Person person = new Person();
		try {
			/*
			 * ��������һ������throws�����׳��쳣�� ����ʱ�����Ǿ�Ҫ������쳣������취�����֣� 1��ʹ��try-catch���񲢴���
			 * 2���ڵ�ǰ�����ϼ�������throws���쳣�׳� ����Ҫ��main����������throws
			 */
			person.setAge(10);
			System.out.println("���䣺" + person.getAge());
		} catch (Exception e) {
			System.out.println("�������������䣡��");
		}
	}
}
