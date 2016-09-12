package day03;

/**
 * finally常见面试题： 1：请说出final，finally，finalize分别是什么？ final修饰类，属性 ，方法 修饰类：类不能被继承
 * 修饰属性：值不能被改变，而且给初值 修饰方法：不能被重写或覆盖
 * 
 * 2.下面程序输出的结果是？
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
	 * 该方法是JVM调用 当该对象即将被GC回收前，会调用该方法。
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
