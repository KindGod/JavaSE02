package day03;

/**
 * java�쳣�������
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ�ˣ�");
		try {
			String str = "";
			/*
			 * ��jvm����ʱ�������쳣�󣬻ᴴ��һ�� �����쳣��ʵ������װ�����ĳ����� ��ϢȻ�󽫸��쳣�׳���
			 */
			System.out.println(str.length());// ��ָ���쳣��

			System.out.println(str.charAt(0));// �±�Խ���쳣��

			System.out.println(Integer.parseInt(str));
		} catch (NullPointerException e) {
			System.out.println("������һ����ָ�룡");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�ַ����±�Խ���ˣ�");
		} catch (NumberFormatException e) {
			System.out.println("�ַ�ת�����⣡");
		} catch (Exception e) {
			System.out.println("�������ǳ��˸���");
		}

		System.out.println("��������ˣ�");
	}
	// Ӧ�����˾�����û�б�������쳣��

}
