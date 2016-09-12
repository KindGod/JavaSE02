package day02;

import java.io.Serializable;
import java.util.List;

/**
 * 该类用来测试对象流读写对象
 * 
 * 若当前类的实例化希望可以被ObjectOutputStream 进行实例化，那么该类必须实现Serializable接口
 * 
 * @author Administrator
 *
 */
public class Person implements Serializable {
	/**
	 * 当我们实现了Serializable接口后 通常我们都定义下面这个常量来维护版本号 版本号对于对象的反序列化有着很重要的作用。 在反序列化时：
	 * 若原来的对象版本号与现有的版本号不同，反序列化 直接失败，原因：版本号不一致
	 * 
	 * 若原来的对象版本号与现有的版本号相同，则启用 兼容模式： 原来对象有的属性，现在还有的则还原 原来对象有的属性，现在没有了就忽略
	 * 原来对象没有的属性，现在有的则使用默认值。
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient关键字 用来修饰一个属性，被修饰的属性在序列化的时候 值将被忽略，这样做可以达到让对象瘦身的目的。
	 * 除此之外该关键字没有其他作用。
	 */
	private transient List<String> otherInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String toString() {
		return name + "," + age + "," + gender + "," + otherInfo;
	}

}