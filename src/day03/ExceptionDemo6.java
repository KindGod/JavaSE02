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
			 * 通常抛出的是自定义异常，描述一个 业务级别的错误，比如RegFailException(注册失败异常)
			 */
			throw new Exception(e);
		}
	}

}
