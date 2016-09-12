package day02;

import java.io.Serializable;
import java.util.List;

/**
 * �����������Զ�������д����
 * 
 * ����ǰ���ʵ����ϣ�����Ա�ObjectOutputStream ����ʵ��������ô�������ʵ��Serializable�ӿ�
 * 
 * @author Administrator
 *
 */
public class Person implements Serializable {
	/**
	 * ������ʵ����Serializable�ӿں� ͨ�����Ƕ������������������ά���汾�� �汾�Ŷ��ڶ���ķ����л����ź���Ҫ�����á� �ڷ����л�ʱ��
	 * ��ԭ���Ķ���汾�������еİ汾�Ų�ͬ�������л� ֱ��ʧ�ܣ�ԭ�򣺰汾�Ų�һ��
	 * 
	 * ��ԭ���Ķ���汾�������еİ汾����ͬ�������� ����ģʽ�� ԭ�������е����ԣ����ڻ��е���ԭ ԭ�������е����ԣ�����û���˾ͺ���
	 * ԭ������û�е����ԣ������е���ʹ��Ĭ��ֵ��
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient�ؼ��� ��������һ�����ԣ������ε����������л���ʱ�� ֵ�������ԣ����������Դﵽ�ö��������Ŀ�ġ�
	 * ����֮��ùؼ���û���������á�
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