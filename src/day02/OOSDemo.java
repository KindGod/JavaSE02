package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectionOutputStream 该流是一个高级流，使用它我们可以很方便的将一个 java中的对象转换为一组字节后写出。
 * 
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("person.obj");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		/*
		 * 通过该流可以很方便的将对象转换为一组 字节，然后该流就会通过其处理的fos将 这一组字节写入文件保存了。
		 */
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Person p = new Person();
		p.setName("Tony");
		p.setAge(30);
		p.setGender("女");

		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("写大字");
		otherInfo.add("促进中日文化交流");
		otherInfo.add("是一名演员");
		otherInfo.add("是一名歌手");

		p.setOtherInfo(otherInfo);
		/*
		 * void writeObject(Object o) ObjectOutputStream提供的该方法用于
		 * 将给定的对象转换为一组对应的字节然后通过 其处理的流写出。
		 * 
		 * 若想被writeObject方法转换为一组字节， 前提是该对象所属的类必须实现了可序列化接口。 否则会抛出异常
		 * 
		 * 序列化:将现有的数据结构转换为一组字节的过程。 将数据写入到文件中(磁盘中)的过程，称之为 “持久化”
		 */
		oos.writeObject(p);

		oos.close();
	}
}
