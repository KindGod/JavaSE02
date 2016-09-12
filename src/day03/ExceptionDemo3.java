package day03;

/**
 * finally���������⣺ 1����˵��final��finally��finalize�ֱ���ʲô�� final�����࣬���� ������ �����ࣺ�಻�ܱ��̳�
 * �������ԣ�ֵ���ܱ��ı䣬���Ҹ���ֵ ���η��������ܱ���д�򸲸�
 * 
 * 2.�����������Ľ���ǣ�
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo3 {

	public static void main(String[] args) {
		System.out.println(test("0") + "," + test(null) + "," + test(""));
	}

	public static int test(String str) {
		try {
			return '0' - str.charAt(0);
		} catch (NullPointerException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	/**
	 * �÷�����JVM���� ���ö��󼴽���GC����ǰ������ø÷�����
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
