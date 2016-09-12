package day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream 该高级流的作用是可以方便的读取一组字节，然后将其 还原成原本的java对象。前提是这一组字节必须是由
 * ObjectionOutputStream将一个对象转换的一组字节！
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
