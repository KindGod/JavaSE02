package homework02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҵ5
 * 
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("����", 15, "��", 3000));
		list.add(new Emp("����", 25, "Ů", 5000));
		list.add(new Emp("����", 26, "��", 8000));
		list.add(new Emp("����", 38, "Ů", 13000));

		FileOutputStream fos = new FileOutputStream("emplist.obj");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		System.out.println("���л����");
		oos.close();

		FileInputStream fis = new FileInputStream("emplist.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Emp> list1 = (List<Emp>) ois.readObject();// ǿת
		System.out.println("�����л���ϣ�");
		System.out.println(list1);
		System.out.println(list);

		System.out.println(list == list1);// ��Ȼ����һ����������ͬһ������
		ois.close();
	}
}
