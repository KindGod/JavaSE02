package day03;

public class ExceptionDemo6 {
	public static void main(String[] args) {
		try {
			regAge("a");
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

	public static void regAge(String age) throws Exception {
		try {
			int a = Integer.parseInt(age);
		} catch (NullPointerException e) {

		} catch (NumberFormatException e) {
			/*
			 * ͨ���׳������Զ����쳣������һ�� ҵ�񼶱�Ĵ��󣬱���RegFailException(ע��ʧ���쳣)
			 */
			throw new Exception(e);
		}
	}

}
