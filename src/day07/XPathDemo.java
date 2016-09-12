package day07;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPath快速检索XML文档中的信息
 * 
 * @author 24470
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));

			// /*
			// * 查看所有员工的名字
			// * /list/emp/name
			// */
			// List<Element> nameList
			// = doc.selectNodes(
			// "/list/emp/name"
			// );
			// for(Element nameEle : nameList){
			// System.out.println(
			// nameEle.getText()
			// );
			// }

			/*
			 * 查看工资高于6000的员工的名字 /list/emp[salary>6000]/name
			 */
			List<Element> nameList = doc
					.selectNodes("/list/emp[salary>6000]/name");
			for (Element nameEle : nameList) {
				System.out.println(nameEle.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
