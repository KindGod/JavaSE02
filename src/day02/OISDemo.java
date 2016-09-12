package day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream �ø߼����������ǿ��Է���Ķ�ȡһ���ֽڣ�Ȼ���� ��ԭ��ԭ����java����ǰ������һ���ֽڱ�������
 * ObjectionOutputStream��һ������ת����һ���ֽڣ�
 * 
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream("person.obj");

		ObjectInputStream ois = new ObjectInputStream(fis);

		Person p = (Person) ois.readObject();
		System.out.println(p);
		ois.close();

	}
}
