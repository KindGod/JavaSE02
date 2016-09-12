package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectionOutputStream ������һ���߼�����ʹ�������ǿ��Ժܷ���Ľ�һ�� java�еĶ���ת��Ϊһ���ֽں�д����
 * 
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("person.obj");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		/*
		 * ͨ���������Ժܷ���Ľ�����ת��Ϊһ�� �ֽڣ�Ȼ������ͻ�ͨ���䴦���fos�� ��һ���ֽ�д���ļ������ˡ�
		 */
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Person p = new Person();
		p.setName("Tony");
		p.setAge(30);
		p.setGender("Ů");

		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("д����");
		otherInfo.add("�ٽ������Ļ�����");
		otherInfo.add("��һ����Ա");
		otherInfo.add("��һ������");

		p.setOtherInfo(otherInfo);
		/*
		 * void writeObject(Object o) ObjectOutputStream�ṩ�ĸ÷�������
		 * �������Ķ���ת��Ϊһ���Ӧ���ֽ�Ȼ��ͨ�� �䴦�����д����
		 * 
		 * ���뱻writeObject����ת��Ϊһ���ֽڣ� ǰ���Ǹö��������������ʵ���˿����л��ӿڡ� ������׳��쳣
		 * 
		 * ���л�:�����е����ݽṹת��Ϊһ���ֽڵĹ��̡� ������д�뵽�ļ���(������)�Ĺ��̣���֮Ϊ ���־û���
		 */
		oos.writeObject(p);

		oos.close();
	}
}
