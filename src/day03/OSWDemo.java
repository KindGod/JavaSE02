package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java.io.OutputStreamWriter 字符输出流，以字符为单位写出数据 字符流都是高级流，方便我们读写字符
 * 底下本质还是读写字节，字符流只是帮助我们在字节与 字符之间做了转换。
 * 
 * @author Administrator
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/*
		 * 常用的两个构造方法： 1： OutputStreamWriter(OutputStream out)
		 * 该构造方法会将给定的字节流进行包装，然后当前流 就会按照系统默认的字符集将要写出的字符串转换为 对应的一组字节，在通过给定的字节流写出。
		 * 
		 * 2； OutputStreamWriter(OutputStream out,String charsetName)
		 * 使用给定的字符集将字符串转换为一组字节后写出。 通常我们使用当前流的目的就是要将字符串按照给定 的字符集写出，所以这个构造方法最常用。
		 */
		// OutputStreamWriter osw
		// = new OutputStreamWriter(fos);

		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		String str = "我爱北京天安门";
		osw.write(str);
		osw.write("天安门上太阳升");

		osw.write('!');
		osw.close();
		/*
		 * 打开WorkSpace看运行结果！
		 */

	}
}
