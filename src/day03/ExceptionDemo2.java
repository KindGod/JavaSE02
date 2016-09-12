package day03;

/**
 * 异常处理机制中的finally块 finally块可以直接跟在try{}后面，类似： try{ ... }finally{
 * 
 * } 跟常见的是跟在最后一个catch之后 finally是异常捕获机制的最后一个部分，其后不能再 添加catch。
 * finally块中的代码是无条件执行的，无论try语句中 的代码是否出错。通常将释放资源等操作放在finally 中
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		try {
			String str = "";
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了！");
		} finally {
			System.out.println("finally中的代码被执行了");
		}
	}
}
