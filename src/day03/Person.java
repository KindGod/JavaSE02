package day03;

/**
 * 用于测试throw的其中一个作用 满足语法要求，但是不满足业务逻辑时，可以当做异常 并抛出给调用者告知原因。
 * 
 * @author Administrator
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	/**
	 * 通常方法中抛出异常，就应当在方法中使用throws 声明该异常的抛出，目的是告知调用者要处理这个错误！
	 * 
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age) throws IllegalAgeException {
		if (age < 0 || age > 100) {
			throw new IllegalAgeException();
		}
		this.age = age;
	}
}
