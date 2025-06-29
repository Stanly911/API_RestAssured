package serialize_deserialize;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String course;
	
	public Student(String name, int age, String course) {
		this.name = name;
		this.age = age;
		this.course = course;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCourse() {
		return course;
	}
	
	public void display()
	{
		System.out.println("Name : "+name);
		System.out.println("age : "+age);
		System.out.println("course : "+course);
	}

}
