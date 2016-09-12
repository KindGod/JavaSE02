package day03;

/**
 * Exception常见API
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "";
			System.out.println(str.charAt(0));
		} catch (Exception e) {
			/*
			 * 输出错误堆栈信息，了解错误出现过程 便于调试代码
			 */
			e.printStackTrace();
			// 获取错误信息！
			System.out.println(e.getMessage());
		}
		System.out.println("程序结束了");
	}
}
