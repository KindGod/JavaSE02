package day03;

/**
 * java异常捕获机制
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了！");
		try {
			String str = "";
			/*
			 * 当jvm运行时遇到了异常后，会创建一个 该类异常的实例并封装完整的出错报告 信息然后将该异常抛出。
			 */
			System.out.println(str.length());// 空指针异常！

			System.out.println(str.charAt(0));// 下标越界异常！

			System.out.println(Integer.parseInt(str));
		} catch (NullPointerException e) {
			System.out.println("出现了一个空指针！");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("字符串下标越界了！");
		} catch (NumberFormatException e) {
			System.out.println("字符转换问题！");
		} catch (Exception e) {
			System.out.println("反正就是出了个错！");
		}

		System.out.println("程序结束了！");
	}
	// 应用闪退就是有没有被捕获的异常！

}
