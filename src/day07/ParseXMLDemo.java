package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * 
 * @author 24470
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 使用DOM解析XML文档的大致流程 1:创建SAXReader 2:读取XML文档数据并进行解析(读取就
			 * 解析了)，返回Document对象 Document对象就表示XML文档信息了 耗时操作，会将XML信息全部载入内存
			 * 3:通过Document对象获取根元素 4:根据XML文档结构，通过根元素逐层遍历， 最终达到遍历XML文档的目的。
			 */
			// 1
			SAXReader reader = new SAXReader();

			// 2
			Document document = reader.read(new File("emplist.xml"));

			// 3
			/*
			 * Document提供了获取根元素的方法: Element getRootElement()
			 * 
			 * Element用于表示XML文档中的一个 元素(一对标签)。
			 * 
			 * org.dom4j.Element
			 */
			Element root = document.getRootElement();

			// 4
			/*
			 * 将XML中配置的每一个emp标签表示的员工 信息解析出来，并以一个Emp对象保存， 并存入一个集合。
			 * 实际开发中，我们不会每次使用员工信息都去 读取XML文件，而是只解析一次，然后重复去 使用其中每一个Emp对象。
			 */
			List<Emp> empList = new ArrayList<Emp>();
			/*
			 * Element提供了一些常用的获取子标签的 方法: Element element(String name)
			 * 获取当前标签下给定名字的子标签。
			 * 
			 * List elements() 获取当前标签下所有的子标签
			 * 
			 * List elements(String name) 获取当前标签下所有同名子标签
			 */
			List<Element> list = root.elements();
			// 遍历获取每一个emp标签
			for (Element empEle : list) {
				// 解析名字
				Element nameEle = empEle.element("name");
				/*
				 * String getText() 获取当前标签中间的文本信息 String getTextTrim()
				 * 获取文本的同时去除两边的空白
				 */
				String name = nameEle.getTextTrim();

				// 解析AGE
				int age = Integer.parseInt(empEle.elementTextTrim("age"));// trim:去空白

				// 解析GENDER
				String gender = empEle.elementText("gender");

				// 解析SALARY
				int salary = Integer.parseInt(empEle.elementText("salary"));

				// 解析ID
				/*
				 * Element提供了用于获取当前标签属性 信息的方法: Attribute attribute(int index)
				 * 获取指定下标对应的属性，0表示第一个属性
				 * 
				 * Attribute attribute(String name) 获取给定名字的属性
				 * 
				 * Attribute的每一个实例都表示某个标签 中的一个属性，通过它可以获取该属性的 名字以及对应的值。
				 */

				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());

				Emp emp = new Emp(id, name, age, gender, salary);

				empList.add(emp);
			}

			System.out.println("解析了" + empList.size() + "个员工信息");
			for (Emp e : empList) {
				System.out.println(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
