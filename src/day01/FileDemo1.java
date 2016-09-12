package day01;

import java.io.File;

/**
 * java.io.File ����������ʾһ���ļ���Ŀ¼ ʹ�������ԣ� 1:�����ļ���Ŀ¼������(���֣���С��������ʱ���)
 * 2:�����ļ���Ŀ¼(������ɾ��)
 * 
 * @author Administrator
 * 
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * ��ʾ��ǰ��Ŀ��Ŀ¼�µ��ļ�test.txt �������ļ���Ŀ¼ʱ������ָ����·����� ʹ�����·������������ϵͳ���죬������ ��ƽ̨��
		 * ".":��ǰĿ¼ ��eclipse������ʱ����ʾ��ǰ��Ŀ�ĸ�Ŀ¼
		 */
		/*
		 * java.io.File; ����Ŀ¼�Ĳ㼶�ָ�����ͬϵͳҲ�в��죺 windows:"\",����:d:\xxx.txt linux:"/"
		 * ����Ӧ��ʹ��File�ĳ�����ʾ: File.separartor
		 */
		File file = new File("." + File.separator + "test.txt");
		/*
		 * ��ȡ������Ϣ����ط���
		 */
		// ��ȡ�ļ���
		String name = file.getName();
		System.out.println("����:" + name);

		// ��ȡ�ļ���С:long length()
		long length = file.length();
		System.out.println("ռ��:" + length + "�ֽ�");

		// �鿴�ļ��Ƿ���ʵ����
		boolean exists = file.exists();
		System.out.println("�ļ��Ƿ���ʵ����:" + exists);

		// �鿴�Ƿ��ʾ�����ļ�
		boolean isFile = file.isFile();
		System.out.println("���ļ�:" + isFile);

		// �鿴�Ƿ��ʾ����Ŀ¼
		boolean isDir = file.isDirectory();
		System.out.println("��Ŀ¼" + isDir);
		/*
		 * �������������ж��ļ���Ŀ¼�Ƿ��д���ɶ���������
		 */
		file.canWrite();
		file.canRead();
		file.canExecute();
		// �Ƿ�Ϊ�����ļ�
		file.isHidden();

	}
}
