package day03;

/**
 * Exception����API
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = "";
			System.out.println(str.charAt(0));
		} catch (Exception e) {
			/*
			 * ��������ջ��Ϣ���˽������ֹ��� ���ڵ��Դ���
			 */
			e.printStackTrace();
			// ��ȡ������Ϣ��
			System.out.println(e.getMessage());
		}
		System.out.println("���������");
	}
}
