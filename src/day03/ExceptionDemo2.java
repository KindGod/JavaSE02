package day03;

/**
 * �쳣��������е�finally�� finally�����ֱ�Ӹ���try{}���棬���ƣ� try{ ... }finally{
 * 
 * } ���������Ǹ������һ��catch֮�� finally���쳣������Ƶ����һ�����֣�������� ���catch��
 * finally���еĴ�����������ִ�еģ�����try����� �Ĵ����Ƿ����ͨ�����ͷ���Դ�Ȳ�������finally ��
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
			System.out.println("�����ˣ�");
		} finally {
			System.out.println("finally�еĴ��뱻ִ����");
		}
	}
}
