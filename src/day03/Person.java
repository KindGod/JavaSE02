package day03;

/**
 * ���ڲ���throw������һ������ �����﷨Ҫ�󣬵��ǲ�����ҵ���߼�ʱ�����Ե����쳣 ���׳��������߸�֪ԭ��
 * 
 * @author Administrator
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	/**
	 * ͨ���������׳��쳣����Ӧ���ڷ�����ʹ��throws �������쳣���׳���Ŀ���Ǹ�֪������Ҫ�����������
	 * 
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age) throws IllegalAgeException {
		if (age < 0 || age > 100) {
			throw new IllegalAgeException();
		}
		this.age = age;
	}
}
