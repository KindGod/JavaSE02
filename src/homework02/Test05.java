package homework02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 作业5
 * 
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("张三", 15, "男", 3000));
		list.add(new Emp("李四", 25, "女", 5000));
		list.add(new Emp("王五", 26, "男", 8000));
		list.add(new Emp("赵六", 38, "女", 13000));

		FileOutputStream fos = new FileOutputStream("emplist.obj");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		System.out.println("序列化完毕");
		oos.close();

		FileInputStream fis = new FileInputStream("emplist.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Emp> list1 = (List<Emp>) ois.readObject();// 强转
		System.out.println("反序列化完毕！");
		System.out.println(list1);
		System.out.println(list);

		System.out.println(list == list1);// 虽然内容一样，但不是同一个对象
		ois.close();
	}
}
