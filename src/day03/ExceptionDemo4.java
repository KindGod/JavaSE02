package day03;

/**
 * 测试Person异常的抛出与解决
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		Person person = new Person();
		try {
			/*
			 * 当调用了一个具有throws声明抛出异常的 方法时，我们就要解决该异常，解决办法有两种： 1：使用try-catch捕获并处理
			 * 2：在当前方法上继续声明throws将异常抛出 但不要在main方法上声明throws
			 */
			person.setAge(10);
			System.out.println("年龄：" + person.getAge());
		} catch (Exception e) {
			System.out.println("不符合人类年龄！！");
		}
	}
}
