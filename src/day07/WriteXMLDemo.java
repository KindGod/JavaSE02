package day07;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM生成XML文档
 * 
 * @author 24470
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		try {
			List<Emp> empList = new ArrayList<Emp>();

			empList.add(new Emp(1, "张三", 25, "男", 5000));
			empList.add(new Emp(2, "李四", 28, "女", 8000));
			empList.add(new Emp(3, "王五", 45, "男", 15000));
			empList.add(new Emp(4, "赵六", 35, "女", 12000));
			empList.add(new Emp(5, "钱七", 29, "男", 6500));
			/*
			 * 生成XML文档的大致步骤: 1:创建Document对象，表示文档 2:向Document中添加根元素
			 * 3:向根元素中添加若干层子元素完成 文档结构 4:创建XMLWriter 5:将Document写出，若写入文件则
			 * 会生成一个XML文件。若通过Socket 获取的输出流写出则是将XML数据发送 至远端计算机 6:关闭XMLWriter
			 */

			// 1
			/*
			 * 通过DOcumentHelper的静态方法来创建 一个Document实例
			 */
			Document document = DocumentHelper.createDocument();

			// 2
			/*
			 * Document提供了添加根元素的方法 Element addElement(String name)
			 * 向当前文档对象中添加给定名字的根元素，当 添加完毕后会将该元素以Element对象的形式 返回，便于我们通过它添加子标签。
			 * 
			 * 该方法不能被调用两次，因为一个文档中规定 只能有一个根元素
			 */
			Element root = document.addElement("list");

			// 3
			for (Emp emp : empList) {
				/*
				 * Element同样提供了addElement 方法，用于向当前标签中添加给定 名字，用于向当前标签中添加给定
				 * 名字的子标签: Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");

				// 向emp标签中追加子标签name
				Element nameEle = empEle.addElement("name");
				// 向标签中间添加文本信息
				nameEle.addText(emp.getName());

				// 添加age标签并设置值
				empEle.addElement("age").addText(emp.getAge() + "");

				// 添加gender标签并设置值
				empEle.addElement("gender").addText(emp.getGender());

				// 添加salary标签并设置值
				empEle.addElement("salary").addText(emp.getSalary() + "");

				// 添加id属性
				empEle.addAttribute("id", emp.getId() + "");
			}

			// 4
			XMLWriter writer = new XMLWriter();

			// 5
			writer.setOutputStream(new FileOutputStream("myemp.xml"));
			// 将文档对象写出
			writer.write(document);

			// 6
			writer.close();
			System.out.println("写出完毕！");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
