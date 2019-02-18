package tk.ddvudo.io.ObjectStream;

import java.io.Serializable;

public class TestObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private int sex;
	public TestObject(String name, int age, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "TestObject [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
